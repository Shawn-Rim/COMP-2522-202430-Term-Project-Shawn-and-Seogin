package com.example.comp2522202430termprojectshawnandseogin;

public abstract class Character {
    protected String name;
    protected Inventory inventory;

    public Character(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be null or empty.");
        }

        this.name = name;
        this.inventory = new Inventory();
    }
}
