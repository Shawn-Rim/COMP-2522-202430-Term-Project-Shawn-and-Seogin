package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents a refillable tool that waters plantable soil.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class WateringCan extends Tool {
    private static final int USES = 3;
    private static final BigInteger BUY_PRICE = new BigInteger("1000");
    private static final Image WATERING_CAN = new Image(Objects.requireNonNull(
            WateringCan.class.getResourceAsStream("/Tools/WaterCan.png")));

    private int remainingUses;

    /**
     * Constructs an object Type of WateringCan.
     */
    public WateringCan() {
        final int defaultUse = 3;
        super("Watering Can", BUY_PRICE);
        this.remainingUses = defaultUse;
    }

    /**
     * Fills the watering can.
     */
    public void fillWater() {
        this.remainingUses = USES;
    }

    /**
     * Uses watering can if watering can is not empty and the soil is plantable.
     *
     * @param soil of Soil
     */
    @Override
    public void useTool(final Soil soil) {
        if (this.remainingUses > 0 && soil.getIsPlantable()) {
            soil.waterSoil();
            this.remainingUses--;
        }
    }

    /**
     * Draws watering can image.
     *
     * @param gc a GraphicsContext
     * @param x an int representing the x coordinate
     * @param y an int representing the y coordinate
     * @param cellSize an int representing the size
     */
    @Override
    public void drawItem(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(WATERING_CAN, x, y, cellSize, cellSize);
    }
}
