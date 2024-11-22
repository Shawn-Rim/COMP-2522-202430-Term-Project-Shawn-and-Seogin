package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public abstract class Decorator implements Serializable {
    public Decorator() { }

    public abstract void drawDecorator(GraphicsContext gc, int x, int y, int cellSize);

    public abstract void interact(Item item);

}
