package by.savitsky.dto.items;

import java.util.UUID;

public class ResultItem {

    private String uid;

    private String id;

    private int cost;

    public ResultItem() {
        this.uid = UUID.randomUUID().toString();
    }

    public ResultItem(String id, int cost) {
        this.uid = UUID.randomUUID().toString();
        this.id = id;
        this.cost = cost;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ResultItem{" +
                "uid='" + uid + '\'' +
                ", id='" + id + '\'' +
                ", cost=" + cost +
                '}';
    }

}
