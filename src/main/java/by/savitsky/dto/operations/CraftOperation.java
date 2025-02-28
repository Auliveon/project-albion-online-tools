package by.savitsky.dto.operations;

import java.util.*;

public class CraftOperation implements ICraftOperation {

    private String id;

    private int stage;

    private Recipe recipe;

    private String resultItemId;

    private int count;

    private int pricePerOneCraft;

    private int costPerOneCraft;

    private double returnOfResourcesPercent;

    private List<ResultInfo> previousResultInfos = new ArrayList<>();

    public CraftOperation() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public ResultInfo getResult() {
        final ResultInfo resultInfo = new ResultInfo();
        if (count > 0) {
            for (ResultInfo iterable : previousResultInfos) {
                final Queue<ItemInfo> items = iterable.getItems();
            }
            final Queue items = previousResultInfos
        } else {
            resultInfo.setItems(itemInfos);
            resultInfo.setExpenses(0);
        }
        return resultInfo;
    }

    @Override
    public int getStage() {
        return stage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getResultItemId() {
        return resultItemId;
    }

    public void setResultItemId(String resultItemId) {
        this.resultItemId = resultItemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPricePerOneCraft() {
        return pricePerOneCraft;
    }

    public void setPricePerOneCraft(int pricePerOneCraft) {
        this.pricePerOneCraft = pricePerOneCraft;
    }

    public int getCostPerOneCraft() {
        return costPerOneCraft;
    }

    public void setCostPerOneCraft(int costPerOneCraft) {
        this.costPerOneCraft = costPerOneCraft;
    }

    public int getItemsPerOneCraft() {
        return itemsPerOneCraft;
    }

    public void setItemsPerOneCraft(int itemsPerOneCraft) {
        this.itemsPerOneCraft = itemsPerOneCraft;
    }

    public double getReturnOfResourcesPercent() {
        return returnOfResourcesPercent;
    }

    public void setReturnOfResourcesPercent(double returnOfResourcesPercent) {
        this.returnOfResourcesPercent = returnOfResourcesPercent;
    }

}
