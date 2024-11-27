package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents a Crop in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public abstract class Crop extends Item {
    /**
     * Stores the sell price as a BigInteger
     */
    protected BigInteger sellPrice;

    /**
     * Creates an instance of Crop.
     *
     * @param name a String representing the name
     * @param sellPrice a String representing the sellPrice
     */
    public Crop(final String name, final String sellPrice) {
        if (sellPrice == null || sellPrice.trim().isEmpty()) {
            throw new IllegalArgumentException("Buy price cannot be null or an empty string.");
        }

        super(name);

        this.sellPrice = new BigInteger(sellPrice);
    }

    /**
     * Returns the sell price of this crop
     *
     * @return the sell price as BigInteger
     */
    public BigInteger getSellPrice() {
        return this.sellPrice;
    }

    /**
     * Returns the String representation of this crop.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        return "Crop{" +
                "name='" + this.name + '\'' +
                ", quantity=" + this.quantity +
                ", sellPrice=" + this.sellPrice + '}';
    }

    /**
     * Compares the equality of this crop against the given object.
     *
     * @param object an Object to compare
     * @return the equality of this crop against the object
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

        Crop crop = (Crop) object;

        return this.sellPrice.equals(crop.sellPrice);
    }

    /**
     * Returns the hash code of this crop.
     *
     * @return the hash code as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.sellPrice);
    }
}
