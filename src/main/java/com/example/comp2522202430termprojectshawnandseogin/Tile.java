package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

/**
 * Represents abstract class for grid elements, storing position, and size.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public abstract class Tile implements Serializable {
    /**
     * Represents Decorator for the Tile.
     */
    protected Decorator decorator;
    /**
     * Represents x coordinate of int.
     */
    protected int xCoordinate;
    /**
     * Represents y coordinate of int.
     */
    protected int yCoordinate;
    /**
     * Represents cell size of int.
     */
    protected int cellSize;

    /**
     * Constructs an object Type of Tile.
     *
     * @param xCoordinate of int
     * @param yCoordinate of int
     * @param cellSize of int
     * @throws IllegalArgumentException if x, y coordinate is bigger the than range or negative
     * @throws IllegalArgumentException if cell size is negative
     */
    public Tile(final int xCoordinate, final int yCoordinate, final int cellSize)
            throws IllegalArgumentException {
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

    /**
     * Returns x coordinate of Tile.
     *
     * @return xCoordinate as an int
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Returns y coordinate of Tile.
     *
     * @return yCoordinate as an int
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Returns the Decorator of Tile.
     *
     * @return decorator as a Decorator
     */
    public Decorator getDecorator() {
        return this.decorator;
    }

    /**
     * Assign the decorator from parameter.
     *
     * @param decorator of Decorator
     */
    public void setDecorator(final Decorator decorator) {
        this.decorator = decorator;
    }

    /**
     * Draws tile if the decorator is not null.
     *
     * @param gc of GraphicsContext
     */
    public void drawTile(final GraphicsContext gc) {
        if (this.decorator != null) {
            this.decorator.drawDecorator(gc, xCoordinate, yCoordinate, cellSize);
        }
    }
}
