package com.example.comp2522202430termprojectshawnandseogin;

import java.util.ArrayList;
import java.util.List;

public final class Inventory {
    private final List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        for (Item inventoryItem : this.items) {
            if (item.getQuantity() == 0) {
                items.remove(inventoryItem);
                break;
            }
        }
    }

    public int capacity() {
        return this.items.size();
    }

    public Item getItem(final int index) {
        if (index < 0 || index >= this.items.size()) {
            throw new IllegalArgumentException("Index out of bounds.");
        }

        return this.items.get(index);
    }
}
