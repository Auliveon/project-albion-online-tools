package by.savitsky.dto.operations;

import java.util.LinkedList;
import java.util.List;

public class ResultInfo {

    private List<ItemInfo> items;

    private int expenses;

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public void addItem(ItemInfo item) {
        if (this.items == null) {
            this.items = new LinkedList<>();
        }
        this.items.add(item);
    }

    public void addItems(List<ItemInfo> items) {
        if (this.items == null) {
            this.items = new LinkedList<>();
        }
        this.items.addAll(items);
    }

    public boolean isEmpty() {
        return getItems().isEmpty();
    }

}
