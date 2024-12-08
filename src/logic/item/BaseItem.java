package logic.item;

import logic.pal.BasePal;

public abstract class BaseItem {
    protected String name;
    protected String description;
    protected int quantity;

    // Constructor
    public BaseItem(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    // Abstract method for using the item
    public abstract void use(BasePal target);

    // Increase quantity
    public void addQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    // Decrease quantity
    public void reduceQuantity(int amount) {
        if (amount > 0) {
            this.quantity -= amount;
            if (this.quantity < 0) this.quantity = 0;
        }
    }

    // Check if the item can be used
    public boolean canUse() {
        return quantity > 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }
}

