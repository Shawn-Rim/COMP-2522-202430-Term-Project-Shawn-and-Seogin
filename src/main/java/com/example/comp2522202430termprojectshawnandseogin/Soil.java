package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a tile that can be plantable, watered, or dry,
 * and displays the appropriate image based on its state.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class Soil extends Tile {
    private static final int IMAGE_SIZE = 10;
    private static final Random RANDOM = new Random();
    private static final Image[] NON_PLANTABLE = new Image[IMAGE_SIZE];
    private static final Image[] PLANTABLE_NO_WATER = new Image[IMAGE_SIZE];
    private static final Image[] PLANTABLE_WATER = new Image[IMAGE_SIZE];

    private boolean isPlantable;
    private boolean isWatered;
    private final int imageNum;

    static {
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            NON_PLANTABLE[i - 1] = new Image(Objects.requireNonNull(
                    Soil.class.getResourceAsStream("/Soil/Non_plantable/noPlant" + i + ".png")));
            PLANTABLE_NO_WATER[i - 1] = new Image(Objects.requireNonNull(
                    Soil.class.getResourceAsStream(
                            "/Soil/Plantable_nonWater/noWater" + i + ".png")));
            PLANTABLE_WATER[i - 1] = new Image(Objects.requireNonNull(
                    Soil.class.getResourceAsStream(
                            "/Soil/Plantable_water/waterSoil" + i + ".png")));
        }
    }

    /**
     * Constructs an object Type of Soil.
     *
     * @param xCoordinate of int
     * @param yCoordinate of int
     * @param cellSize of int
     */
    public Soil(final int xCoordinate, final int yCoordinate, final int cellSize) {
        super(xCoordinate, yCoordinate, cellSize);

        this.isPlantable = false;
        this.isWatered = false;
        this.imageNum = RANDOM.nextInt(IMAGE_SIZE);
    }

    /**
     * Returns current status of soil if it is watered.
     *
     * @return true if it is watered, false otherwise
     */
    public boolean getIsWatered() {
        return this.isWatered;
    }

    /**
     * Returns current status of soil if it is plantable.
     *
     * @return true if it is plantable, false otherwise
     */
    public boolean getIsPlantable() {
        return this.isPlantable;
    }

    /**
     * Toggles status of soil.
     */
    public void togglePlantable() {
        if (this.decorator == null) {
            this.isWatered = false;
            this.isPlantable = !this.isPlantable;
        }
    }

    /**
     * Changes the soil to watered.
     */
    public void waterSoil() {
        this.isWatered = true;
    }

    /**
     * Changes the soil to dry.
     */
    public void drySoil() {
        this.isWatered = false;
    }

    /**
     * Draws soil based on the status.
     *
     * @param gc of GraphicsContext
     */
    @Override
    public void drawTile(final GraphicsContext gc) {
        Image image;

        if (isWatered) {
            image = PLANTABLE_WATER[imageNum];
        } else if (isPlantable) {
            image = PLANTABLE_NO_WATER[imageNum];
        } else {
            image = NON_PLANTABLE[imageNum];
        }

        gc.drawImage(image, this.xCoordinate * this.cellSize,
                this.yCoordinate * this.cellSize, this.cellSize, this.cellSize);
        super.drawTile(gc);
    }
}
