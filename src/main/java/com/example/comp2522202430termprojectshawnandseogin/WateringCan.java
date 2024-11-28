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
        super("Watering Can", BUY_PRICE);
        this.remainingUses = USES;
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
     * Returns remaining uses of watering can.
     *
     * @return remainingUses as an int
     */
    public int getRemainingUses() {
        return this.remainingUses;
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

    /**
     * Returns a String representation of this WateringCan.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        return "WateringCan{" + "remainingUses=" + remainingUses + '}';
    }

    /**
     * Compares this WateringCan object with another object for equality.
     *
     * @param object of Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        WateringCan that = (WateringCan) object;
        return remainingUses == that.remainingUses;
    }

    /**
     * Returns the hash code value for this WateringCan object.
     *
     * @return hashcode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), remainingUses);
    }
}
