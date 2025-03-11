package by.savitsky.dto.operations;

import java.util.*;
import java.util.stream.Collectors;

import static by.savitsky.util.CommonUtil.getRecipeMap;

public class CraftOperation implements ICraftOperation {

    private String uid;

    private int stage;

    private Recipe recipe;

    private int count;

    private double returnOfResourcesPercent;

    private List<ResultInfo> previousResultInfos = new ArrayList<>();

    public CraftOperation() {
        this.uid = UUID.randomUUID().toString();
    }

    @Override
    public ResultInfo getResult() {
        final ResultInfo resultInfo = new ResultInfo();
        final Map<String, Integer> itemCountMap = getRecipeMap(recipe);
        final List<ItemInfo> resultItems = craft(itemCountMap);
        resultInfo.setItems(resultItems);
        resultInfo.setExpenses(recipe.getCraftCost() * resultItems.size());
        return resultInfo;

    }

    @Override
    public int getStage() {
        return stage;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getReturnOfResourcesPercent() {
        return returnOfResourcesPercent;
    }

    public void setReturnOfResourcesPercent(double returnOfResourcesPercent) {
        this.returnOfResourcesPercent = returnOfResourcesPercent;
    }

    private List<ItemInfo> craft(Map<String, Integer> recipeMap) {
        final List<ItemInfo> result = new ArrayList<>();
        int remainCount = count;
        for (; remainCount > 0; remainCount--) {
            final Map<String, List<ItemInfo>> resourceMap = recipeMap.keySet().stream()
                    .collect(Collectors.toMap(key -> key, key -> new ArrayList<>()));
            for (Map.Entry<String, Integer> entry : recipeMap.entrySet()) {
                for (ResultInfo resultInfo : previousResultInfos) {
                    final Iterator<ItemInfo> itemInfoIterator = resultInfo.getItems().listIterator();
                    while (itemInfoIterator.hasNext()) {
                        final ItemInfo itemInfo = itemInfoIterator.next();
                        if (resourceMap.get(entry.getKey()).size() != entry.getValue()) {
                            resourceMap.get(entry.getKey()).add(itemInfo);
                            itemInfoIterator.remove();
                        } else {
                            break;
                        }
                    }
                }
            }
            if (isFilled(recipeMap, resourceMap)) {
                result.add(new ItemInfo(recipe.getId()));
            }
        }
        final int crafted = count - remainCount;
        return result;
    }

    private List<ItemInfo> fillByReturnOfResourcesPercent(Recipe recipe, int crafted, double returnOfResourcesPercent) {
        final List<ItemInfo> result = new ArrayList<>();



        return result;
    }

    private List<ItemInfo> isEnoughForCraft(int crafted, Map<String, Integer> recipeMap, double returnOfResourcesPercent) {
        final List<ItemInfo> result = new ArrayList<>();



        return result;
    }

    private boolean isFilled(Map<String, Integer> recipeMap, Map<String, List<ItemInfo>> resourceMap) {
        return recipeMap.entrySet().stream()
                .allMatch(entry -> resourceMap.get(entry.getKey()).size() == entry.getValue());
    }

}
