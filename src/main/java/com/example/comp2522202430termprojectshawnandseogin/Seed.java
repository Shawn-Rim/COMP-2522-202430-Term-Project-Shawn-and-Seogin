package com.example.comp2522202430termprojectshawnandseogin;

public abstract class Seed extends Tool {
    protected double growthRate;

    public Seed(final String name, final String buyPrice, final double growthRate) {
        if (Double.compare(growthRate, 0.0) <= 0) {
            throw new IllegalArgumentException("Growth must be a positive floating point number.");
        }

        super(name, buyPrice);
        this.growthRate = growthRate;
    }

    @Override
    public void useTool(Soil soil) {

    }
}
