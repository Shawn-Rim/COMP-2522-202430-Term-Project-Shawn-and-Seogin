package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

public abstract class Decorator {
    public Decorator() { }

    public abstract void drawDecorator(GraphicsContext gc, int x, int y, int cellSize);

    public abstract void interact(Tool tool);

}
