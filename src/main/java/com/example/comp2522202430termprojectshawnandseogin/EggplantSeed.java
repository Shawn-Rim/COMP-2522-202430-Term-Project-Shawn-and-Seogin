package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.image.Image;

import java.util.Objects;

public final class EggplantSeed extends Seed {
    private final static Image EGGPLANT_SEED = new Image(Objects.requireNonNull(
            EggplantSeed.class.getResourceAsStream("/Seeds/EggPlantSeed.png")));

    public EggplantSeed(int quantity) {
        super("Eggplant Seed", "500", 0.2, quantity);
    }
}
