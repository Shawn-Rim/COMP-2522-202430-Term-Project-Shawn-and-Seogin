package com.example.comp2522202430termprojectshawnandseogin;

public final class NPC extends Character {
    private boolean visited;

    public NPC(final String name) {
        super(name);

        this.visited = false;
    }

    public String talk() {
        return "Hello!";
    }

    public void visit() {
        this.visited = true;
    }
}
