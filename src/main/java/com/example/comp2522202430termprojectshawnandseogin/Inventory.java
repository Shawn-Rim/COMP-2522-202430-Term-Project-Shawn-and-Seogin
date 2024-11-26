package com.example.comp2522202430termprojectshawnandseogin;

import java.io.Serializable;

public final class Inventory implements Serializable {
    public static final int MAX_CAPACITY = 6;

    private final Item[] items;

    public Inventory() {
        this.items = new Item[MAX_CAPACITY];

        // add items to the inventory
        this.items[0] = new Hoe();
        this.items[1] = new WateringCan();
    }

    public void addItem(final Item item) {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] != null && this.items[i].equals(item)) {
                this.items[i].addQuantity();
                return;
            }
        }

        // If the items does not exist yet, add the item to an empty space
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                return;
            }
        }
    }

    public void checkItem() {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] != null && this.items[i].getQuantity() <= 0) {
                this.items[i] = null;
            }
        }
    }

    public void removeItem(final Item item) {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] != null && this.items[i].equals(item)) {
                this.items[i].subtractQuantity();
            }
        }
    }

    public Item getItem(final int index) {
        if (index < 0 || index >= MAX_CAPACITY) {
            throw new IllegalArgumentException("Index out of bounds.");
        }

        return this.items[index];
    }
}
