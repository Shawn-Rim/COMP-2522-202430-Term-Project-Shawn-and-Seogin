package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class WaterWell extends Decorator {
    private final static Image WATERWELL = new Image(Objects.requireNonNull(WaterWell.class.getResourceAsStream("/WaterWell/Water well.png")));
    private final static Image GROUND = new Image(Objects.requireNonNull(WaterWell.class.getResourceAsStream("/Ground/middle.png")));

    public WaterWell() {
        super();
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        gc.drawImage(WATERWELL, x * cellSize, y * cellSize, cellSize, cellSize);
    }

    @Override
    public void interact(final Item item) {
        if (item instanceof WateringCan) {
            ((WateringCan) item).fillWater();
        }
    }
}
