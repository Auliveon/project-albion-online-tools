package by.savitsky.dto.operations;

public class ItemInfo {

    private String id;

    private double cost;
    private double buyOrderTaxPercent;

    public ItemInfo() {
    }

    public ItemInfo(String id, double cost, double buyOrderTaxPercent) {
        this.id = id;
        this.cost = cost;
        this.buyOrderTaxPercent = buyOrderTaxPercent;
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
