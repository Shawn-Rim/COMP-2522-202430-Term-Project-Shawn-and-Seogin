package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.Random;

public final class Soil extends Tile {
    private static final int IMAGE_SIZE = 10;
    private static final Random RANDOM = new Random();
    private static final Image[] NON_PLANTABLE = new Image[IMAGE_SIZE];
    private static final Image[] PLANTABLE_NO_WATER = new Image[IMAGE_SIZE];
    private static final Image[] PLANTABLE_WATER = new Image[IMAGE_SIZE];

    private boolean isPlantable;
    private boolean isWatered;
    private int imageNum;

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


    public Soil(final int xCoordinate, final int yCoordinate, final int cellSize) {
        super(xCoordinate, yCoordinate, cellSize);

        this.isPlantable = false;
        this.isWatered = false;
        this.imageNum = RANDOM.nextInt(IMAGE_SIZE);
    }

    public boolean getIsWatered() {
        return this.isWatered;
    }

    public boolean getIsPlantable() {
        return this.isPlantable;
    }

    public void togglePlantable() {
        if (this.decorator == null) {
            this.isWatered = false;
            this.isPlantable = !this.isPlantable;
        }
    }

    public void waterSoil() {
        this.isWatered = true;
    }

    public void drySoil() {
        this.isWatered = false;
    }

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

        gc.drawImage(image, this.xCoordinate * this.cellSize, this.yCoordinate * this.cellSize, this.cellSize, this.cellSize);
        super.drawTile(gc);
    }
}
