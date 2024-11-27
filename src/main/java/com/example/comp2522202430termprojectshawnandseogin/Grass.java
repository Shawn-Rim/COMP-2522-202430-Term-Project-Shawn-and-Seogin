package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Represents a Grass decorator in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class Grass extends Decorator {
    private static final Image IMAGE = new Image(Objects.requireNonNull(Grass.class.getResourceAsStream("/Decorator/Grass.png")));
    private static final int OFFSET = 10;

    /**
     * Creates an instance of this Grass.
     */
    public Grass() {
        super();
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(IMAGE, x * cellSize + OFFSET, y * cellSize + OFFSET, cellSize - OFFSET * 2, cellSize - OFFSET * 2);
    }

    @Override
    public void interact(final Item item) { }

    @Override
    public String toString() {
        return "Grass{}";
    }
}
