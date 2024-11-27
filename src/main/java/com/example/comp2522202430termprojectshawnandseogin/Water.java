package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Represents a tile that blocks movement and render game image on the board.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class Water extends Tile implements BlockTile {
    private static final Image WATER = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Water/Water1.png")));

    /**
     * Constructs an object Type of Water.
     *
     * @param xCoordinate of int
     * @param yCoordinate of int
     * @param cellSize of int
     */
    public Water(final int xCoordinate, final int yCoordinate, final int cellSize) {
        super(xCoordinate, yCoordinate, cellSize);
    }

    /**
     * Draws water image.
     *
     * @param gc of GraphicsContext
     */
    @Override
    public void drawTile(final GraphicsContext gc) {
        drawWater(gc, this.xCoordinate, this.yCoordinate, this.cellSize);
        super.drawTile(gc);
    }

    /**
     * Draws water image.
     *
     * @param gc of GraphicsContext
     * @param x of x coordinate
     * @param y of y coordinate
     * @param cellSize of int
     */
    public static void drawWater(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(WATER, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
