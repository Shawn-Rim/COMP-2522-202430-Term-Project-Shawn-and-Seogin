package com.example.comp2522202430termprojectshawnandseogin;

public final class Inventory {
    public static final int MAX_CAPACITY = 6;

    private final Item[] items;
    private int currentCapacity;

    public Inventory() {
        this.items = new Item[MAX_CAPACITY];
        this.currentCapacity = 2;

        // add items to the inventory
        this.items[0] = new Hoe();
        this.items[1] = new WateringCan();
    }

    public void addItem(final Item item) {
        for (int i = 0; i < this.currentCapacity; i++) {
            if (this.items[i] == item) {
                this.items[i].addQuantity();
                return;
            }
        }

        this.items[this.currentCapacity] = item;
        this.currentCapacity++;
    }

    public void removeItem(final Item item) {
        for (int i = 0; i < this.currentCapacity; i++) {
            if (items[i] == item) {
                items[i].subtractQuantity();
            }

            if (items[i].getQuantity() == 0) {
                items[i] = null;
            }
        }
    }

    public int getCapacity() {
        return this.currentCapacity;
    }

    public Item getItem(final int index) {
        if (index < 0 || index >= MAX_CAPACITY) {
            throw new IllegalArgumentException("Index out of bounds.");
        }

        return this.items[index];
    }
}
