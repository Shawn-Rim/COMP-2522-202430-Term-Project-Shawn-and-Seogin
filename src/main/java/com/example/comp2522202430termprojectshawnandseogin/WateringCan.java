package com.example.comp2522202430termprojectshawnandseogin;

public final class WateringCan extends Tool {
    private int remainingUses;

    public WateringCan() {
        super("Watering Can", "1000");
        this.remainingUses = 0;
    }


    public void fillWater() {
        this.remainingUses = 3;
    }

    @Override
    public void useTool(Soil soil) {
        if (this.remainingUses > 0 && soil.getIsPlantable()) {
            soil.waterSoil();
            this.remainingUses--;
        }
    }
}
