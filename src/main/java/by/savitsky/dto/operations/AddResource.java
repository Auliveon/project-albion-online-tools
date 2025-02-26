package by.savitsky.dto.operations;

public class AddResource implements IOperation {

    private String id;

    private String name;

    private int count;

    private int perOnePrice;

    private double sellTax;

    private double buyOrderTax;

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

    public double getSellTax() {
        return sellTax;
    }

    public void setSellTax(double sellTax) {
        this.sellTax = sellTax;
    }

    public double getBuyOrderTax() {
        return buyOrderTax;
    }

    public void setBuyOrderTax(double buyOrderTax) {
        this.buyOrderTax = buyOrderTax;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "AddResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", perOnePrice=" + perOnePrice +
                ", sellTax=" + sellTax +
                ", buyOrderTax=" + buyOrderTax +
                ", free=" + free +
                '}';
    }

    @Override
    public int getExpenses() {
        return 0;
    }

}
