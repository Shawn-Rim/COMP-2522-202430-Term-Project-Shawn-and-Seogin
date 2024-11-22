package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

public abstract class Item {
    protected final String name;
    protected int quantity;

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

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity() {
        this.quantity++;
    }

    public void subtractQuantity() {
        this.quantity--;
    }

    public abstract void drawItem(GraphicsContext gc, int x, int y, int cellSize);

    @Override
    public String toString() {
        return "Item{" + "name='" + this.name + '\'' + ", quantity=" + this.quantity + '}';
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.quantity);
    }
}
