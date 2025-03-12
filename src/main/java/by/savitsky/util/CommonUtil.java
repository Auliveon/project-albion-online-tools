package by.savitsky.util;

import by.savitsky.dto.operations.ItemInfo;
import by.savitsky.dto.operations.Recipe;
import by.savitsky.dto.operations.RecipeItem;

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

    public static List<ItemInfo> generateItems(String id, int count) {
       return IntStream.of(count).mapToObj(i -> new ItemInfo(id)).collect(Collectors.toList());
    }

}
