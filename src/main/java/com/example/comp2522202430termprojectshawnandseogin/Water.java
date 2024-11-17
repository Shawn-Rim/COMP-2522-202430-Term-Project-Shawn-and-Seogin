package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class Water extends Tile implements BlockTile{
    private static final Image WATER = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Water/Water1.png")));

    public Water(final int xCoordinate, final int yCoordinate, final int cellSize) {
        super(xCoordinate, yCoordinate, cellSize);
    }

    @Override
    public void drawTile(final GraphicsContext gc) {
        drawWater(gc, this.xCoordinate, this.yCoordinate, this.cellSize);
    }

    public static void drawWater(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(WATER, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
