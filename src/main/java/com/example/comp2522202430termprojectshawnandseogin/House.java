package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class House extends Decorator {
    private static final Image HOUSE = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/House/House.png")));
    private static final Image GROUND = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/Ground/middle.png")));

    private final boolean showHouse;

    public House(final boolean showHouse) {
        super();

        this.showHouse = showHouse;
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        if (showHouse) {
            gc.drawImage(HOUSE, x * cellSize - cellSize * 2, y * cellSize - cellSize * 2, cellSize * 3, cellSize * 3);
        }
    }

    @Override
    public void interact(final Item item) {

    }
}
