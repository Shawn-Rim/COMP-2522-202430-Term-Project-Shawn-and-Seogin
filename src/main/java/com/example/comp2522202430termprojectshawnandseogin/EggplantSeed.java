package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents the Eggplant Seed in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class EggplantSeed extends Seed {
    private static final BigInteger BUY_PRICE = new BigInteger("500");
    private static final double GROWTH_RATE = 0.2;
    private static final Image EGGPLANT_SEED = new Image(Objects.requireNonNull(
            EggplantSeed.class.getResourceAsStream("/Seeds/EggPlantSeed.png")));

    /**
     * Creates an instance of EggplantSeed.
     */
    public EggplantSeed() {
        super("Eggplant Seed", BUY_PRICE, GROWTH_RATE);
    }

    @Override
    public void drawItem(final GraphicsContext graphicsContext,
                         final int x, final int y, final int cellSize) {
        graphicsContext.drawImage(EGGPLANT_SEED, x, y, cellSize, cellSize);
    }
}
