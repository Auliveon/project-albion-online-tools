package by.savitsky.dto.items;

import java.util.UUID;

public class ItemInfo {

    private String uid;

    private String id;

    private long cost;
    private double buyOrderTaxPercent;

    public ItemInfo() {
        this.uid = UUID.randomUUID().toString();
    }

    public ItemInfo(String id) {
        this.uid = UUID.randomUUID().toString();
        this.id = id;
    }

    public ItemInfo(String id, long cost, double buyOrderTaxPercent) {
        this.uid = UUID.randomUUID().toString();
        this.id = id;
        this.cost = cost;
        this.buyOrderTaxPercent = buyOrderTaxPercent;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double isBuyOrderTaxPercent() {
        return buyOrderTaxPercent;
    }

    public void setBuyOrderTaxPercent(double buyOrderTaxPercent) {
        this.buyOrderTaxPercent = buyOrderTaxPercent;
    }

    public double evaluateCost() {
        double result = 0;
        if (cost > 0) {
            result = buyOrderTaxPercent > 0 ? cost + (cost * buyOrderTaxPercent / 100) : cost;
        }
        return result;
    }

}
