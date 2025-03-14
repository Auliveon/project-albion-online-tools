package by.savitsky.util;

import by.savitsky.dto.items.ItemInfo;
import by.savitsky.dto.items.Recipe;
import by.savitsky.dto.items.RecipeItem;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonUtil {

    public static Map<String, Integer> getRecipeMap(Recipe recipe) {
        return recipe.getRecipeItems()
                .stream()
                .collect(Collectors.toMap(RecipeItem::getId, item -> 1, Integer::sum));
    }

    public static Recipe generateRecipe(Map<String, Integer> recipeMap, int craftCost, String resultItemId, int resultItemCost) {
        final Recipe recipe = new Recipe();
        recipe.setCraftCost(craftCost);
        recipe.setResultItemId(resultItemId);
        final List<RecipeItem> recipeItems = recipeMap.entrySet().stream()
                .map(entry -> IntStream.of(entry.getValue()).mapToObj(i -> new RecipeItem(entry.getKey()))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream).toList();
        recipe.setRecipeItems(recipeItems);
        recipe.setResultItemCost(resultItemCost);
        return recipe;
    }

    public static List<ItemInfo> generateItemInfos(String id, int count) {
       return IntStream.range(0, count).mapToObj(i -> new ItemInfo(id)).collect(Collectors.toList());
    }

    public static List<ItemInfo> generateItemInfos(String id, int count, int cost, double buyOrderTaxPercent) {
       return IntStream.range(0, count).mapToObj(i -> new ItemInfo(id, cost, buyOrderTaxPercent)).collect(Collectors.toList());
    }

    public static List<RecipeItem> getRecipeItems(String id, int count) {
       return IntStream.range(0, count).mapToObj(i -> new RecipeItem(id)).collect(Collectors.toList());
    }

}
