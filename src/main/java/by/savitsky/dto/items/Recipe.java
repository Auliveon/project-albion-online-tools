package by.savitsky.dto.items;

import java.util.List;
import java.util.UUID;

public class Recipe {

    private String uid;

    private String resultItemId;

    private int resultItemCost;

    private List<RecipeItem> recipeItems;

    private int craftCost;

    public Recipe() {
        this.uid = UUID.randomUUID().toString();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getResultItemId() {
        return resultItemId;
    }

    public void setResultItemId(String resultItemId) {
        this.resultItemId = resultItemId;
    }

    public int getResultItemCost() {
        return resultItemCost;
    }

    public void setResultItemCost(int resultItemCost) {
        this.resultItemCost = resultItemCost;
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
                "uid='" + uid + '\'' +
                ", resultItemId='" + resultItemId + '\'' +
                ", resultItemCost=" + resultItemCost +
                ", recipeItems=" + recipeItems +
                ", craftCost=" + craftCost +
                '}';
    }

}
