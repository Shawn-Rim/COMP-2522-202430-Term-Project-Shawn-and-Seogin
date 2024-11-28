package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Abstract class, allowing seeds to be planted.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public abstract class Seed extends Tool {
    protected double growthRate;

    /**
     * Constructs an object Type of Seed.
     *
     * @param name of String
     * @param buyPrice of BigInteger
     * @param growthRate should be the positive floating point number
     */
    public Seed(final String name, final BigInteger buyPrice, final double growthRate) {
        if (Double.compare(growthRate, 0.0) <= 0) {
            throw new IllegalArgumentException("Growth must be a positive floating point number.");
        }

        super(name, buyPrice);
        this.growthRate = growthRate;
    }

    /**
     * Returns the growth rate of seed.
     *
     * @return growth rate as a double
     */
    public double getGrowthRate() {
        return this.growthRate;
    }

    /**
     * Plants a seed in the given soil if the soil is empty, plantable, and the seed quantity is greater than 0.
     *
     * @param soil where the seed will be planted
     */
    @Override
    public void useTool(Soil soil) {
        if (soil.getDecorator() == null && soil.getIsPlantable() && this.quantity > 0) {
            this.quantity--;
            soil.setDecorator(new Planted(this, soil));
        }
    }

    @Override
    public String toString() {
        return "Seed{" + "growthRate=" + growthRate + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Seed seed = (Seed) object;
        return Double.compare(growthRate, seed.growthRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), growthRate);
    }
}
