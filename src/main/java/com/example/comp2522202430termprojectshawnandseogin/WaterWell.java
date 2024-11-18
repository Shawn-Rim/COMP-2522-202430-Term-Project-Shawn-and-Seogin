package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class WaterWell extends Decorator {
    private final static int X_COORDINATE = 4;
    private final static int Y_COORDINATE = 3;
    private GraphicsContext gc;
    private final int cellSize;
    public WaterWell(final GraphicsContext gc, final int cellSize) {
        super();
        this.gc = gc;
        this.cellSize = cellSize;
    }

    public void drawWaterWell() {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/WaterWell/Water well.png")));
        gc.drawImage(image, X_COORDINATE * this.cellSize, Y_COORDINATE * this.cellSize, this.cellSize, this.cellSize);
    }

    @Override
    public void interact(final Tool tool) {

    }
}
