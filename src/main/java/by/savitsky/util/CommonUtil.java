package by.savitsky.util;

import by.savitsky.dto.operations.Recipe;
import by.savitsky.dto.operations.RecipeItem;

import java.util.Map;
import java.util.stream.Collectors;

public class CommonUtil {

    public static Map<String, Integer> getRecipeMap(Recipe recipe) {
        return recipe.getRecipeItems()
                .stream()
                .collect(Collectors.toMap(RecipeItem::getId, item -> 1, Integer::sum));

    }

}
