package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class Grass extends Decorator {
    // Todo: Change the image to a more appropriate one
    private final static Image IMAGE = new Image(Objects.requireNonNull(Grass.class.getResourceAsStream("/FarmingPlants/Carrot1.png")));

    public Grass() {
        super();
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(IMAGE, x * cellSize, y * cellSize, cellSize, cellSize);
    }

    @Override
    public void interact(final Item item) {

    }
}
