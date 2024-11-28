package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class EggplantSeedTest {
    private EggplantSeed eggplantSeed;

    @BeforeEach
    void setUp() {
        eggplantSeed = new EggplantSeed();
    }

    @Test
    void testEggplantSeedGetName() {
        assertEquals("Eggplant Seed", eggplantSeed.getName());
    }

    @Test
    void testEggplantSeedInitialQuantity() {
        assertEquals(1, eggplantSeed.getQuantity());
    }

    @Test
    void testEggplantSeedIncrementQuantity() {
        eggplantSeed.addQuantity();
        assertEquals(2, eggplantSeed.getQuantity());
    }

    @Test
    void testEggplantSeedDecrementQuantity() {
        eggplantSeed.subtractQuantity();
        assertEquals(0, eggplantSeed.getQuantity());
    }

    @Test
    void testEggplantSeedGetBuyPrice() {
        assertEquals(new BigInteger("500"), eggplantSeed.getBuyPrice());
    }

    @Test
    void testEggplantSeedGetGrowthRate() {
        assertEquals(0.2, eggplantSeed.getGrowthRate());
    }

    @Test
    void testEggplantSeedUseToolNonPlantableSoil() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);

        eggplantSeed.useTool(soil);

        assertEquals(1, eggplantSeed.getQuantity());
    }

    @Test
    void testEggplantSeedUseToolPlantableSoilNoDecorator() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();

        eggplantSeed.useTool(soil);

        assertEquals(0, eggplantSeed.getQuantity());
    }

    @Test
    void testEggplantSeedUseToolPlantableSoilWithDecorator() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();
        soil.setDecorator(new Grass());

        eggplantSeed.useTool(soil);

        assertEquals(1, eggplantSeed.getQuantity());
    }

    @Test
    void testEggplantSeedUseToolZeroQuantity() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();

        eggplantSeed.subtractQuantity();
        eggplantSeed.useTool(soil);

        assertEquals(0, eggplantSeed.getQuantity());
    }

//    @Test
//    void testEggplantSeedToString() { }
//
//    @Test
//    void testEggplantSeedToStringAfterIncrementing() {
//        eggplantSeed.addQuantity();
//    }
//
//    @Test
//    void testEggplantSeedToStringAfterDecrementing() {
//        eggplantSeed.subtractQuantity();
//    }

    @Test
    void testEggplantSeedEquals() {
        EggplantSeed newEggplantSeed = new EggplantSeed();
        assertEquals(newEggplantSeed, eggplantSeed);
    }

    @Test
    void testEggplantSeedHashCodeEquals() {
        EggplantSeed newEggplantSeed = new EggplantSeed();
        assertEquals(newEggplantSeed.hashCode(), eggplantSeed.hashCode());
    }

    @Test
    void testEggplantSeedHashCodeNotEquals() {
        EggplantSeed newEggplantSeed = new EggplantSeed();
        eggplantSeed.addQuantity();
        boolean result = newEggplantSeed.hashCode() == eggplantSeed.hashCode();
        assertFalse(result);
    }
}
