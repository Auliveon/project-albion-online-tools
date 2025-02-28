package by.savitsky.dto.operations;

import java.util.List;

public class AddResource implements IOperation {

    private String id;

    private List<ItemInfo> itemInfos;

    private int stage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemInfo> getItemInfos() {
        return itemInfos;
    }

    public void setItemInfos(List<ItemInfo> itemInfos) {
        this.itemInfos = itemInfos;
    }

    @Override
    public ResultInfo getResult() {
        final int sum = itemInfos.stream().mapToInt(itemInfo -> (int) itemInfo.evaluateCost()).sum();
        final ResultInfo resultInfo = new ResultInfo();
        resultInfo.setItems(itemInfos);
        resultInfo.setExpenses(sum);
        return resultInfo;
    }

    @Override
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

}
