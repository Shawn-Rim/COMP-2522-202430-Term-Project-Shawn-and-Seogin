package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

public final class WateringCan extends Tool {
    private static final int USES = 3;
    private static final BigInteger BUY_PRICE = new BigInteger("1000");
    private static final Image WATERING_CAN = new Image(Objects.requireNonNull(
            WateringCan.class.getResourceAsStream("/Tools/WaterCan.png")));

    private int remainingUses;

    public WateringCan() {
        super("Watering Can", BUY_PRICE);
        this.remainingUses = 3;
    }


    public void fillWater() {
        this.remainingUses = USES;
    }

    @Override
    public void useTool(final Soil soil) {
        if (this.remainingUses > 0 && soil.getIsPlantable()) {
            soil.waterSoil();
            this.remainingUses--;
        }
    }
    @Override
    public void drawItem(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(WATERING_CAN, x, y, cellSize, cellSize);
    }
}
