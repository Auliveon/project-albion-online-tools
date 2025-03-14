package by.savitsky.dto.items;

import java.util.UUID;

public class AddItem {

    private String uid;

    private String id;

    private int count;

    private int cost;

    private double buyOrderTaxPercent;

    public AddItem() {
        this.uid = UUID.randomUUID().toString();
    }

    public AddItem(String id, int count, int cost, double buyOrderTaxPercent) {
         this.uid = UUID.randomUUID().toString();
        this.id = id;
        this.count = count;
        this.cost = cost;
        this.buyOrderTaxPercent = buyOrderTaxPercent;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getBuyOrderTaxPercent() {
        return buyOrderTaxPercent;
    }

    public void setBuyOrderTaxPercent(double buyOrderTaxPercent) {
        this.buyOrderTaxPercent = buyOrderTaxPercent;
    }

}
