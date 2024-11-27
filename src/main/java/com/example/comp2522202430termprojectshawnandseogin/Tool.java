package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

/**
 * Represents an abstract class with functionality to interact with soil.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public abstract class Tool extends Item {
    protected BigInteger buyPrice;

    /**
     * Constructs an object Type of Tool
     *
     * @param name of String
     * @param buyPrice of BigInteger
     * @throws IllegalArgumentException if buyPrice is null
     */
    public Tool(final String name, final BigInteger buyPrice) throws IllegalArgumentException {
        if (buyPrice == null) {
            throw new IllegalArgumentException("Buy price cannot be null or an empty string.");
        }

        super(name);

        this.buyPrice = buyPrice;
    }

    /**
     * Returns the buy price of the tool.
     *
     * @return buyPrice as a BigInteger
     */
    public BigInteger getBuyPrice() {
        return this.buyPrice;
    }

    public abstract void useTool(Soil soil);
}
