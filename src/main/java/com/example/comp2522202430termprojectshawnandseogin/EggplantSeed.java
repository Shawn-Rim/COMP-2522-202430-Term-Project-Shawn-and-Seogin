package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

public final class EggplantSeed extends Seed {
    public static final BigInteger BUY_PRICE = new BigInteger("500");
    private static final double GROWTH_RATE = 0.2;
    private final static Image EGGPLANT_SEED = new Image(Objects.requireNonNull(
            EggplantSeed.class.getResourceAsStream("/Seeds/EggPlantSeed.png")));

    public EggplantSeed() {
        super("Eggplant Seed", BUY_PRICE, GROWTH_RATE);
    }
}
