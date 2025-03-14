package by.savitsky.dto.operations;

import by.savitsky.dto.items.AddItem;
import by.savitsky.dto.items.ResultInfo;
import by.savitsky.dto.items.ItemInfo;
import by.savitsky.util.CommonUtil;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddOperation implements IOperation {

    private String uid;

    private List<AddItem> items;

    private int stage;

    public AddOperation() {
        this.uid = UUID.randomUUID().toString();
    }

     @Override
    public ResultInfo execute(List<ResultInfo> previousResultInfos) {
        final List<ItemInfo> itemInfos = items.stream()
                .map(item -> CommonUtil.generateItemInfos(item.getId(), item.getCount(), item.getCost(), item.getBuyOrderTaxPercent()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        final int sum = itemInfos.stream().mapToInt(itemInfo -> (int) itemInfo.evaluateCost()).sum();
        final ResultInfo resultInfo = new ResultInfo();
        resultInfo.setItems(itemInfos);
        resultInfo.setExpenses(sum);
        return resultInfo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<AddItem> getItems() {
        return items;
    }

    public void setItems(List<AddItem> items) {
        this.items = items;
    }

    @Override
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

}
