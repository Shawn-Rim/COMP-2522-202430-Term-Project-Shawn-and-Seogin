package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an Item in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public abstract class Item implements Serializable {
    /**
     * Stores the name of this Item.
     */
    protected final String name;
    /**
     * Stores the quantity of this Item.
     */
    protected int quantity;

    /**
     * Creates an instance of this Item.
     *
     * @param name a String
     * @throws IllegalArgumentException if name is null or an empty String
     */
    public Item(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }

        this.name = name;
        this.quantity = 1;
    }

    /**
     * Returns the name of this item.
     *
     * @return name as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns the quantity of this item.
     *
     * @return quantity as an int
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Increments the quantity of this item.
     */
    public void addQuantity() {
        this.quantity++;
    }

    /**
     * Decrements the quantity of this item.
     */
    public void subtractQuantity() {
        this.quantity--;
    }

    /**
     * Draws this item to the canvas.
     *
     * @param graphicsContext a GraphicsContext
     * @param x an int representing the x coordinate
     * @param y an int representing the y coordinate
     * @param cellSize an int representing the size
     */
    public abstract void drawItem(GraphicsContext graphicsContext, int x, int y, int cellSize);

    /**
     * Returns the String representation of this item.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        return "Item{" + "name='" + this.name + '\'' + ", quantity=" + this.quantity + '}';
    }

    /**
     * Compares the equality of this item against the given object.
     *
     * @param object an Object to compare
     * @return the equality of this item against the object
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Item item = (Item) object;

        return this.name.compareTo(item.name) == 0;
    }

    /**
     * Returns the hash code of this item.
     *
     * @return the hash code as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.quantity);
    }
}
