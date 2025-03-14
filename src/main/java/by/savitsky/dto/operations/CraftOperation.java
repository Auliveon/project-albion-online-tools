package by.savitsky.dto.operations;

import by.savitsky.dto.items.ResultInfo;
import by.savitsky.dto.items.ItemInfo;
import by.savitsky.dto.items.Recipe;
import by.savitsky.util.CalculationUtil;
import by.savitsky.util.CommonUtil;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static by.savitsky.util.CommonUtil.generateItemInfos;

public class CraftOperation implements ICraftOperation {

    private String uid;

    private int stage;

    private Recipe recipe;

    private int count;

    private double returnOfResourcesPercent;

    public CraftOperation() {
        this.uid = UUID.randomUUID().toString();
    }

    @Override
    public ResultInfo execute(List<ResultInfo> previousResultInfos) {
        final ResultInfo resultInfo = new ResultInfo();
        final List<ItemInfo> resultItems = craft(recipe, count, new AtomicInteger(count), returnOfResourcesPercent,
                previousResultInfos.stream()
                        .map(ResultInfo::getItems)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));
        resultInfo.setItems(resultItems);
        resultInfo.setExpenses(recipe.getCraftCost() * resultItems.size());
        return resultInfo;
    }

    @Override
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public double getReturnOfResourcesPercent() {
        return returnOfResourcesPercent;
    }

    @Override
    public void setReturnOfResourcesPercent(double returnOfResourcesPercent) {
        this.returnOfResourcesPercent = returnOfResourcesPercent;
    }

    private List<ItemInfo> craft(Recipe recipe, int count, AtomicInteger remainCount, double returnOfResourcesPercent,
            List<ItemInfo> incomingResources) {
        final List<ItemInfo> result = new ArrayList<>();
        final Map<String, Integer> recipeMap = CommonUtil.getRecipeMap(recipe);
        for (; remainCount.get() > 0; remainCount.decrementAndGet()) {
            final Map<String, List<ItemInfo>> resourceMap = recipeMap.keySet().stream()
                    .collect(Collectors.toMap(key -> key, key -> new ArrayList<>()));
            for (Map.Entry<String, Integer> entry : recipeMap.entrySet()) {
                extractItems(incomingResources.listIterator(), entry.getKey(), entry.getValue(), resourceMap);
            }
            if (isFilled(recipeMap, resourceMap)) {
                result.add(new ItemInfo(recipe.getResultItemId(), recipe.getResultItemCost(), 0));
            }
        }
        if (remainCount.get() > 0) {
            final List<ItemInfo> returnedResources = CommonUtil.getRecipeMap(recipe).entrySet().stream()
                    .map(entry -> generateItemInfos(entry.getKey(),
                            CalculationUtil.getPercentFromCount(entry.getValue() * result.size(),
                                    returnOfResourcesPercent)))
                    .flatMap(Collection::stream).toList();
            result.addAll(craft(recipe, count, remainCount, returnOfResourcesPercent, returnedResources));
        }
        return result;
    }

    private boolean isFilled(Map<String, Integer> recipeMap, Map<String, List<ItemInfo>> resourceMap) {
        return recipeMap.entrySet().stream()
                .allMatch(entry -> resourceMap.get(entry.getKey()).size() == entry.getValue());
    }

    private void extractItems(Iterator<ItemInfo> itemInfoIterator, String key, Integer requiredCount,
            Map<String, List<ItemInfo>> resourceMap) {
        while (itemInfoIterator.hasNext()) {
            final ItemInfo itemInfo = itemInfoIterator.next();
            if (resourceMap.get(key).size() != requiredCount && key.equals(itemInfo.getId())) {
                resourceMap.get(key).add(itemInfo);
                itemInfoIterator.remove();
            } else {
                break;
            }
        }
    }

}
