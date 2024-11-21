package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

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
}
