package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public abstract class Tile implements Serializable {
    protected Decorator decorator;
    protected int xCoordinate;
    protected int yCoordinate;
    protected int cellSize;

    public Tile(final int xCoordinate, final int yCoordinate, final int cellSize) {
        if (xCoordinate < 0 || xCoordinate > GameManager.ROWS
                || yCoordinate < 0 || yCoordinate > GameManager.COLS) {
            throw new IllegalArgumentException("X Coordinate and Y Coordinate out of range.");
        } else if (cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be a positive integer.");
        }

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.cellSize = cellSize;
        this.decorator = null;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public void setDecorator(final Decorator decorator) {
        this.decorator = decorator;
    }

    public void drawTile(final GraphicsContext gc) {
        if (this.decorator != null) {
            this.decorator.drawDecorator(gc, xCoordinate, yCoordinate, cellSize);
        }
    }
}
