package by.savitsky.dto.result;

import by.savitsky.dto.items.ResultInfo;
import by.savitsky.dto.items.ResultItem;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AlbionOnlineResultContainer implements IResultContainer {

    private String uid;

    private long expenses;

    private List<ResultItem> resultItems;

    public AlbionOnlineResultContainer(List<ResultInfo> resultInfos) {
        this.uid = UUID.randomUUID().toString();
        this.expenses = resultInfos.stream().mapToInt(ResultInfo::getExpenses).sum();
        this.resultItems = resultInfos.stream()
                .map(ResultInfo::getItems)
                .flatMap(Collection::stream)
                .map(item -> new ResultItem(item.getId(), item.getCost()))
                .collect(Collectors.toList());
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getExpenses() {
        return expenses;
    }

    public void setExpenses(long expenses) {
        this.expenses = expenses;
    }

    public List<ResultItem> getResultItems() {
        return resultItems;
    }

    public void setResultItems(List<ResultItem> resultItems) {
        this.resultItems = resultItems;
    }

    @Override
    public String toString() {
        return "AlbionOnlineResultContainer{" +
                "uid='" + uid + '\'' +
                ", expenses=" + expenses +
                ", profit=" + (resultItems.stream().mapToInt(ResultItem::getCost).sum() - expenses) +
                '}';
    }

}
