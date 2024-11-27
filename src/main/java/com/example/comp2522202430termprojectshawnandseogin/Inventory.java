package com.example.comp2522202430termprojectshawnandseogin;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents an Inventory for a Character.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class Inventory implements Serializable {
    /**
     * Stores the max capacity of an inventory.
     */
    public static final int MAX_CAPACITY = 6;
    private static int numOfInventory = 0;

    private final int inventoryID;
    private final Item[] items;

    /**
     * Creates an instance of Inventory.
     */
    public Inventory() {
        this.items = new Item[MAX_CAPACITY];

        // add items to the inventory
        this.items[0] = new Hoe();
        this.items[1] = new WateringCan();

        numOfInventory++;
        this.inventoryID = numOfInventory;
    }

    /**
     * Adds an item to the items array.
     *
     * @param item an Item
     */
    public void addItem(final Item item) {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] != null && this.items[i].equals(item)) {
                this.items[i].addQuantity();
                return;
            }
        }

        // If the items do not exist yet, add the item to an empty space
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                return;
            }
        }
    }

    /**
     * Checks and remove items that has the quantity of 0.
     */
    public void checkItem() {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] != null && this.items[i].getQuantity() <= 0) {
                this.items[i] = null;
            }
        }
    }

    /**
     * Removes the given item from the items array.
     *
     * @param item an Item
     */
    public void removeItem(final Item item) {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (this.items[i] != null && this.items[i].equals(item)) {
                this.items[i].subtractQuantity();
            }
        }
    }

    /**
     * Returns the item.
     *
     * @param index the index as an int
     * @return an item in items array
     * @throws IllegalArgumentException if index is out of bounds
     */
    public Item getItem(final int index) {
        if (index < 0 || index >= MAX_CAPACITY) {
            throw new IllegalArgumentException("Index out of bounds.");
        }

        return this.items[index];
    }

    @Override
    public String toString() {
        return "Inventory{" + "items=" + Arrays.toString(this.items) + '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Inventory inventory = (Inventory) object;

        return this.inventoryID == inventory.inventoryID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.inventoryID, Arrays.hashCode(this.items));
    }
}
