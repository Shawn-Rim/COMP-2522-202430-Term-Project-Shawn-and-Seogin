package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Character {
    protected Inventory inventory;
    protected GraphicsContext graphicsContext;
    protected int xCoordinate;
    protected int yCoordinate;
    protected int cellSize;

    public Character(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        if (gc == null) {
            throw new IllegalArgumentException("GraphicsContext is null.");
        } else if (x < 0 || x >= Main.ROWS || y < 0 || y >= Main.COLS) {
            throw new IllegalArgumentException("X and Y Coordinate out of bounds.");
        } else if(cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be a positive integer.");
        }

        this.inventory = new Inventory();
        this.graphicsContext = gc;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.cellSize = cellSize;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void drawCharacter() {
        this.graphicsContext.setFill(Color.RED);
            this.graphicsContext.fillRect(
                    this.xCoordinate * this.cellSize, this.yCoordinate * this.cellSize,
                    this.cellSize, this.cellSize);
    }
}
