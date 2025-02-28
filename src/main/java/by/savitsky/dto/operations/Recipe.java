package by.savitsky.dto.operations;

import java.util.List;

public class Recipe {

    private List<RecipeItem> recipeItems;

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

}
