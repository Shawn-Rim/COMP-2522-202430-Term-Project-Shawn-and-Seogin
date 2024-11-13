package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

public final class NPC extends Character {
    private boolean visited;

    public NPC(final String name, final GraphicsContext gc, final int x, final int y) {
        super(name, gc, x, y);

        this.visited = false;
    }

    public String talk() {
        return "Hello!";
    }

    public void visit() {
        this.visited = true;
    }
}
