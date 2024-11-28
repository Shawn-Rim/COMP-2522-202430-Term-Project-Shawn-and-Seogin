package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;
import java.util.Objects;

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

    /**
     * Returns a String representation of this Tool.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        return "Tool{"
                + "name='" + this.name + '\''
                + ", quantity=" + this.quantity
                + ", buyPrice="+ this.buyPrice
                + '}';
    }

    /**
     * Compares this Tool object with another object for equality.
     *
     * @param object of Object
     * @return boolean
     */
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
        Tool tool = (Tool) object;
        return Objects.equals(buyPrice, tool.buyPrice);
    }

    /**
     * Returns the hash code value for this Tool object.
     *
     * @return hashcode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buyPrice);
    }
}
