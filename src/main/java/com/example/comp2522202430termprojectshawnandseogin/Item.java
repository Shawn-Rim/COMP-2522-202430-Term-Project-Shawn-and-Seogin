package com.example.comp2522202430termprojectshawnandseogin;

public abstract class Item {
    protected final String name;
    private int quantity;

    public Item(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }

        this.name = name;
        this.quantity = 1;
    }
    public String getName() {
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void addQuantity() {
        this.quantity++;
    }
}
