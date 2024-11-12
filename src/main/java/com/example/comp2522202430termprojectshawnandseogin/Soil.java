package com.example.comp2522202430termprojectshawnandseogin;

public final class Soil extends Tile {
    private boolean isPlantable;

    public Soil() {
        super();

        this.isPlantable = false;
    }

    public void changeSoil() {
        this.isPlantable = true;
    }
}
