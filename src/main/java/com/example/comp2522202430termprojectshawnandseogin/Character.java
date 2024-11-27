package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.Objects;

public abstract class Character implements Serializable {
    protected Inventory inventory;
    protected int xCoordinate;
    protected int yCoordinate;
    protected int cellSize;

    public Character(final int x, final int y, final int cellSize) {
        if (x < 0 || x >= GameManager.ROWS || y < 0 || y >= GameManager.COLS) {
            throw new IllegalArgumentException("X and Y Coordinate out of bounds.");
        } else if(cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be a positive integer.");
        }

        this.inventory = new Inventory();
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
        GraphicsContext gc = GameManager.getGameManager().getGraphicsContext();

       gc .setFill(Color.RED);
            gc.fillRect(
                    this.xCoordinate * this.cellSize, this.yCoordinate * this.cellSize,
                    this.cellSize, this.cellSize);
    }

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

        if (this.cellSize != character.cellSize) {
            return false;
        }

        return  this.inventory.equals(character.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory, xCoordinate, yCoordinate, cellSize);
    }
}
