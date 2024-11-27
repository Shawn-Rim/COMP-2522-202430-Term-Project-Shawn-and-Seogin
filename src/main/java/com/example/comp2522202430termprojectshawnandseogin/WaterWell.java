package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Represents Decorator to refill the watering can.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class WaterWell extends Decorator {
    private static final Image WATERWELL = new Image(Objects.requireNonNull(WaterWell.class.getResourceAsStream("/WaterWell/Water well.png")));
    private static final Image GROUND = new Image(Objects.requireNonNull(WaterWell.class.getResourceAsStream("/Ground/middle.png")));

    /**
     * Constructs an object Type of WaterWell.
     */
    public WaterWell() {
        super();
    }

    /**
     * Draws water well on the board.
     *
     * @param gc a GraphicContext
     * @param x an int representing the x coordinate
     * @param y an int representing the y coordinate
     * @param cellSize an int representing the size
     */
    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        gc.drawImage(WATERWELL, x * cellSize, y * cellSize, cellSize, cellSize);
    }

    /**
     * Fills water to watering can.
     *
     * @param item an Item
     */
    @Override
    public void interact(final Item item) {
        if (item instanceof WateringCan) {
            ((WateringCan) item).fillWater();
        }
    }
}
