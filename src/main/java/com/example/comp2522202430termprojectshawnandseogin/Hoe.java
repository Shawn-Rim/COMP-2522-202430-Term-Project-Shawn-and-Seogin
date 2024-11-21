package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

public final class Hoe extends Tool {
    private static final BigInteger BUY_PRICE = new BigInteger("1000");

    private static final Image HOE = new Image(Objects.requireNonNull(
            Hoe.class.getResourceAsStream("/Tools/Hoe.png")));

    public Hoe() {
        super("Hoe", BUY_PRICE);
    }

    @Override
    public void useTool(final Soil soil) {
        // to-do: implement useTool
        soil.togglePlantable();
    }

    @Override
    public void drawItem(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(HOE, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
