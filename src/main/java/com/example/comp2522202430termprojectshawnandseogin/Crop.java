package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;
import java.util.Objects;

public abstract class Crop extends Item {
    protected BigInteger sellPrice;

    public Crop(final String name, final String sellPrice) {
        // TODO: How to check if buyPrice is consisting of digits only
        if (sellPrice == null || sellPrice.trim().isEmpty()) {
            throw new IllegalArgumentException("Buy price cannot be null or an empty string.");
        }

        super(name);

        this.sellPrice = new BigInteger(sellPrice);
    }

    public BigInteger getSellPrice() {
        return this.sellPrice;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + this.name + '\'' +
                ", quantity=" + this.quantity +
                ", sellPrice=" + this.sellPrice + '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }

        Crop crop = (Crop) object;

        return this.sellPrice.equals(crop.sellPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.sellPrice);
    }
}
