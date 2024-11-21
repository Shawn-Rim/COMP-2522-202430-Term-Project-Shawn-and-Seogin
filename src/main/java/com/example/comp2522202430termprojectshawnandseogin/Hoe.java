package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

public final class Hoe extends Tool {
    private static final BigInteger BUY_PRICE = new BigInteger("1000");

    public Hoe() {
        super("Hoe", BUY_PRICE);
    }

    @Override
    public void useTool(final Soil soil) {
        // TODO: implement useTool
        soil.togglePlantable();
    }
}
