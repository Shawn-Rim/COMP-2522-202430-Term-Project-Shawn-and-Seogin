package com.example.comp2522202430termprojectshawnandseogin;

public abstract class Item {
    protected final String name;

    public Item(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
