package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

public final class CarrotSeed extends Seed {
    private static final BigInteger BUY_PRICE = new BigInteger("500");

    public CarrotSeed(int quantity) {
        super("Carrot Seed", BUY_PRICE, 0.2, quantity);
    }
}
