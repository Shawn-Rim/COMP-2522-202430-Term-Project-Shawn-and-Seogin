package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class NPC extends Decorator {
    private boolean visited;
    private final static Image NPC = new Image(Objects.requireNonNull(NPC.class.getResourceAsStream("/NPC/NPC.png")));


    public NPC() {
        super();

        this.visited = false;
    }

    public String talk() {
        return "Hello!";
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public void interact(Tool tool) {

    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(NPC, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
