package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

public abstract class Seed extends Tool {
    protected double growthRate;

    public Seed(final String name, final BigInteger buyPrice, final double growthRate) {
        if (Double.compare(growthRate, 0.0) <= 0) {
            throw new IllegalArgumentException("Growth must be a positive floating point number.");
        }

        super(name, buyPrice);
        this.growthRate = growthRate;
    }

    public double getGrowthRate() {
        return this.growthRate;
    }

    @Override
    public void useTool(Soil soil) {
        if (soil.getDecorator() == null && soil.getIsPlantable() && this.quantity > 0) {
            this.quantity--;
            soil.setDecorator(new Planted(this, soil));
        }
    }
}
