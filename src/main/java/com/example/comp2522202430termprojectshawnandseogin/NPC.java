package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class NPC extends Character {
    private boolean visited;
    private final static Image NPC = new Image(Objects.requireNonNull(WaterWell.class.getResourceAsStream("/NPC/NPC.png")));

    public NPC(final String name, final GraphicsContext gc, final int x, final int y, final int cellSize) {
        super(name, gc, x, y, cellSize);

        this.visited = false;
    }

    public String talk() {
        return "Hello!";
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public void drawCharacter() {
        graphicsContext.drawImage(NPC, xCoordinate * cellSize, yCoordinate * cellSize, cellSize, cellSize);
    }
}
