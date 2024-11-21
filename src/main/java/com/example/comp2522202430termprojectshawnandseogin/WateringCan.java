package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

public final class WateringCan extends Tool {
    private static final BigInteger BUY_PRICE = new BigInteger("1000");

    private int remainingUses;

    public WateringCan() {
        super("Watering Can", BUY_PRICE);
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
