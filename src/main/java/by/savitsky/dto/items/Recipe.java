package by.savitsky.dto.items;

import java.util.List;
import java.util.UUID;

public class Recipe {

    private String uid;

    private String resultItemId;

    private long resultItemCost;

    private List<RecipeItem> recipeItems;

    private long craftCost;

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

    public long getResultItemCost() {
        return resultItemCost;
    }

    public void setResultItemCost(long resultItemCost) {
        this.resultItemCost = resultItemCost;
    }

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public long getCraftCost() {
        return craftCost;
    }

    public void setCraftCost(long craftCost) {
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
