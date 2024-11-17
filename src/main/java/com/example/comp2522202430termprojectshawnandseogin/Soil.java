package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.image.Image;

import java.util.Objects;

public final class Soil extends Tile {
    private static final int IMAGE_SIZE = 10;
    private static final Image[] NON_PLANTABLE = new Image[IMAGE_SIZE];
    private static final Image[] PLANTABLE_NO_WATER = new Image[IMAGE_SIZE];
    private static final Image[] PLANTABLE_WATER = new Image[IMAGE_SIZE];
    private boolean isPlantable;
    private boolean isWatered;

    static {
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            try {
                NON_PLANTABLE[i - 1] = new Image(Objects.requireNonNull(
                        Soil.class.getResourceAsStream("/Soil/Non_plantable/noPlant" + i + ".png")));
                PLANTABLE_NO_WATER[i - 1] = new Image(Objects.requireNonNull(
                        Soil.class.getResourceAsStream("/Soil/Plantable_nonWater/noWater" + i + ".png")));
                PLANTABLE_WATER[i - 1] = new Image(Objects.requireNonNull(
                        Soil.class.getResourceAsStream("/Soil/Plantable_water/waterSoil" + i + ".png")));
            } catch (NullPointerException e) {
                System.err.println("Failed to load image for index " + i);
                e.printStackTrace();
            }
        }
    }


    public Soil(final int xCoordinate, final int yCoordinate) {
        super(xCoordinate, yCoordinate);

        this.isPlantable = false;
        this.isWatered = false;
    }

    public boolean getIsWatered() {
        return this.isWatered;
    }

    public boolean getIsPlantable() {
        return this.isPlantable;
    }

    public static Image[] getNonPlantable() {
        return NON_PLANTABLE;
    }

    public static Image[] getPlantableNoWater() {
        return PLANTABLE_NO_WATER;
    }

    public static Image[] getPlantableWater() {
        return PLANTABLE_WATER;
    }

    public void togglePlantable() {
        this.isPlantable = !this.isPlantable;
    }

    public void waterSoil() {
        this.isWatered = true;
    }
}
