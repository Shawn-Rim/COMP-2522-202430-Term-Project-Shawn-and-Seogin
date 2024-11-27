package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

/**
 * Represents a Decorator of a Tile in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public abstract class Decorator implements Serializable {
    /**
     * Creates an instance of this Decorator.
     */
    public Decorator() { }

    /**
     * Draws this decorator to the canvas.
     *
     * @param gc a GraphicContext
     * @param x an int representing the x coordinate
     * @param y an int representing the y coordinate
     * @param cellSize an int representing the size
     */
    public abstract void drawDecorator(GraphicsContext gc, int x, int y, int cellSize);

    /**
     * Interacts with this decorator using the given Item.
     *
     * @param item an Item
     */
    public abstract void interact(Item item);
}
