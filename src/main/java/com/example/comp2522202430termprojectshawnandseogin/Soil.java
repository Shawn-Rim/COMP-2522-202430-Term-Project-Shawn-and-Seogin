package com.example.comp2522202430termprojectshawnandseogin;

public final class Soil extends Tile {
    private boolean isPlantable;

    public Soil(final int xCoordinate, final int yCoordinate) {
        super(xCoordinate, yCoordinate);

        this.isPlantable = false;
    }

    public boolean getIsPlantable() {
        return this.isPlantable;
    }

    public void setSoilPlantable() {
        this.isPlantable = true;
    }

    public void setSoilUnPlantable() {
        this.isPlantable = false;
    }
}
