package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents a Hoe tool in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class Hoe extends Tool {
    private static final BigInteger BUY_PRICE = new BigInteger("1000");

    private static final Image HOE = new Image(Objects.requireNonNull(
            Hoe.class.getResourceAsStream("/Tools/Hoe.png")));

    /**
     * Creates an instance of a Hoe.
     */
    public Hoe() {
        super("Hoe", BUY_PRICE);
    }

    @Override
    public void useTool(final Soil soil) {
        soil.togglePlantable();
    }

    @Override
    public void drawItem(final GraphicsContext graphicsContext,
                         final int x, final int y, final int cellSize) {
        graphicsContext.drawImage(HOE, x, y, cellSize, cellSize);
    }
}
