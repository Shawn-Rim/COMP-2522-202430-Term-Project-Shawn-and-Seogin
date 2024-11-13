package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Character {
    protected String name;
    protected Inventory inventory;
    protected GraphicsContext graphicsContext;
    protected int xCoordinate;
    protected int yCoordinate;

    public Character(final String name, final GraphicsContext gc, final int x, final int y) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be null or empty.");
        } else if (gc == null) {
            throw new IllegalArgumentException("GraphicsContext is null.");
        } else if (x < 0 || x >= Main.ROWS || y < 0 || y >= Main.COLS) {
            throw new IllegalArgumentException("X and Y Coordinate out of bounds.");
        }

        this.name = name;
        this.inventory = new Inventory();
        this.graphicsContext = gc;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public void drawCharacter() {
        this.graphicsContext.setFill(Color.RED);
            this.graphicsContext.fillRect(
                    this.xCoordinate * Main.CELLSIZE, this.yCoordinate * Main.CELLSIZE,
                    Main.CELLSIZE, Main.CELLSIZE);
    }
}
