package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Represents an Eggplant in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class Eggplant extends Crop {
    private static final int IMAGE_SIZE = 4;
    private static final Image[] EGGPLANT_IMAGE = new Image[IMAGE_SIZE];

    static {
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            EGGPLANT_IMAGE[i - 1] = new Image(Objects.requireNonNull(Eggplant.class.
                    getResourceAsStream("/FarmingPlants/EggPlant" + i + ".png")));
        }
    }

    /**
     * Creates an instance of this Eggplant.
     */
    public Eggplant() {
        super("Eggplant", "1000");
    }

    @Override
    public void drawItem(final GraphicsContext graphicsContext,
                         final int x, final int y, final int cellSize) {
        graphicsContext.drawImage(EGGPLANT_IMAGE[IMAGE_SIZE - 1], x, y, cellSize, cellSize);
    }
}
