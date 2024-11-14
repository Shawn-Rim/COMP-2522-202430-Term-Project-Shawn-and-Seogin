package com.example.comp2522202430termprojectshawnandseogin;

public final class Soil extends Tile {
    private boolean isPlantable;
    private boolean isWatered;

    public Soil(final int xCoordinate, final int yCoordinate) {
        super(xCoordinate, yCoordinate);

        this.isPlantable = false;
        this.isWatered = false;
    }

    public boolean getIsWatered() {
        return this.isWatered;
    }

    public boolean getIsPlantable() {
        return this.isPlantable;
    }

    public void togglePlantable() {
        this.isPlantable = !this.isPlantable;
    }

    public void waterSoil() {
        this.isWatered = true;
    }
}
