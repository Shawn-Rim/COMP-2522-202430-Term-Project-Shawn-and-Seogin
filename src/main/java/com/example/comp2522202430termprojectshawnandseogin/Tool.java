package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

public abstract class Tool extends Item {
    protected BigInteger buyPrice;

    public Tool(final String name, final String buyPrice) {
        // TODO: How to check if buyPrice is consisting of digits only
        if (buyPrice == null || buyPrice.trim().isEmpty()) {
            throw new IllegalArgumentException("Buy price cannot be null or an empty string.");
        }

        super(name);

        this.buyPrice = new BigInteger(buyPrice);
    }

    public BigInteger getBuyPrice() {
        return this.buyPrice;
    }

    public abstract void useTool(Soil soil);
}
