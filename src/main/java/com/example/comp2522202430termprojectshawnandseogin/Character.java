package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a Character in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public abstract class Character implements Serializable {
    /**
     * Stores the inventory of the character.
     */
    protected Inventory inventory;
    /**
     * Stores the x coordinate of the character.
     */
    protected int xCoordinate;
    /**
     * Stores the y coordinate of the character.
     */
    protected int yCoordinate;
    /**
     * Stores the size of the character.
     */
    protected int cellSize;

    /**
     * Creates an instance of Character.
     *
     * @param x an int representing the x coordinate
     * @param y an int representing the y coordinate
     * @param cellSize an int representing the size
     * @throws IllegalArgumentException if x and y is out of bounds
     *                                  or cellSize is not a positive integer
     */
    public Character(final int x, final int y, final int cellSize) {
        if (x < 0 || x >= GameManager.ROWS || y < 0 || y >= GameManager.COLS) {
            throw new IllegalArgumentException("X and Y Coordinate out of bounds.");
        } else if (cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be a positive integer.");
        }

        this.inventory = new Inventory();
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.cellSize = cellSize;
    }

    /**
     * Returns the xCoordinate of this character.
     *
     * @return xCoordinate as an int
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Returns the yCoordinate of this character.
     *
     * @return yCoordinate as an int
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Returns the inventory of this character.
     *
     * @return inventory as Inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Draws this character to the canvas.
     */
    public void drawCharacter() {
        GraphicsContext gc = GameManager.getGameManager().getGraphicsContext();

       gc .setFill(Color.RED);
            gc.fillRect(
                    this.xCoordinate * this.cellSize, this.yCoordinate * this.cellSize,
                    this.cellSize, this.cellSize);
    }

    /**
     * Returns the String representation of this character.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Character{")
                .append("inventory=")
                .append(this.inventory)
                .append(", xCoordinate=")
                .append(this.xCoordinate)
                .append(", yCoordinate=")
                .append(this.yCoordinate)
                .append(", cellSize=")
                .append(this.cellSize)
                .append('}')
                .toString();
    }

    /**
     * Compares the equality of this character against the given object.
     *
     * @param object an Object to compare
     * @return the equality of this character against the object
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Character character = (Character) object;

        if (this.xCoordinate != character.xCoordinate) {
            return false;
        }

        if (this.yCoordinate != character.yCoordinate) {
            return false;
        }

        return this.cellSize == character.cellSize;
    }

    /**
     * Returns the hash code of this character.
     *
     * @return the hash code as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, cellSize);
    }
}
