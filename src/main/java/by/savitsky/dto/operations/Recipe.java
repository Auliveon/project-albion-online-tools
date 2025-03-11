package by.savitsky.dto.operations;

import java.util.List;

public class Recipe {

    private String id;

    private String resultItemId;

    private List<RecipeItem> recipeItems;

    private int craftCost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultItemId() {
        return resultItemId;
    }

    public void setResultItemId(String resultItemId) {
        this.resultItemId = resultItemId;
    }

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public int getCraftCost() {
        return craftCost;
    }

    public void setCraftCost(int craftCost) {
        this.craftCost = craftCost;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", recipeItems=" + recipeItems +
                ", craftCost=" + craftCost +
                '}';
    }

}
