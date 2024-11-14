package com.example.comp2522202430termprojectshawnandseogin;

public abstract class Tile {
    protected Decorator decorator;
    protected int xCoordinate;
    protected int yCoordinate;

    public Tile(final int xCoordinate, final int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate > Main.ROWS || yCoordinate < 0 || yCoordinate > Main.COLS) {
            throw new IllegalArgumentException("X Coordinate and Y Coordinate out of range.");
        }

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
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
}
