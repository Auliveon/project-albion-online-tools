package by.savitsky.dto.operations;

public class AddResource implements IStartOperation {

    private String id;

    private String name;

    private int count;

    private int perOnePrice;

    private double sellTaxPercent;

    private double buyOrderTaxPercent;

    private boolean free;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPerOnePrice() {
        return perOnePrice;
    }

    public void setPerOnePrice(int perOnePrice) {
        this.perOnePrice = perOnePrice;
    }

    public double getSellTaxPercent() {
        return sellTaxPercent;
    }

    public void setSellTaxPercent(double sellTaxPercent) {
        this.sellTaxPercent = sellTaxPercent;
    }

    public double getBuyOrderTaxPercent() {
        return buyOrderTaxPercent;
    }

    public void setBuyOrderTaxPercent(double buyOrderTaxPercent) {
        this.buyOrderTaxPercent = buyOrderTaxPercent;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public int getExpenses() {
        return 0;
    }

}
