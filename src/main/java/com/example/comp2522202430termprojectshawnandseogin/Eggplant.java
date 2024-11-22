package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class Eggplant extends Crop {
    private final static int IMAGE_SIZE = 4;
    private final static Image[] EGGPLANT_IMAGE = new Image[IMAGE_SIZE];
    static {
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            EGGPLANT_IMAGE[i - 1] = new Image(Objects.requireNonNull(Eggplant.class.
                    getResourceAsStream("/FarmingPlants/EggPlant" + i + ".png")));
        }
    }
    public Eggplant() {
        super("Eggplant", "1000");
    }

    @Override
    public void drawItem(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(EGGPLANT_IMAGE[IMAGE_SIZE - 1], x, y, cellSize, cellSize);
    }
}
