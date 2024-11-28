package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class HoeTest {
    private Hoe hoe;

    @BeforeEach
    void setUp() {
        hoe = new Hoe();
    }

    @Test
    void testHoeGetName() {
        assertEquals("Hoe", hoe.getName());
    }

    @Test
    void testHoeInitialQuantity() {
        assertEquals(1, hoe.getQuantity());
    }

    @Test
    void testHoeIncrementQuantity() {
        hoe.addQuantity();
        assertEquals(2, hoe.getQuantity());
    }

    @Test
    void testHoeGetBuyPrice() {
        assertEquals(new BigInteger("1000"), hoe.getBuyPrice());
    }

    @Test
    void testHoeDecrementQuantity() {
        hoe.subtractQuantity();
        assertEquals(0, hoe.getQuantity());
    }

    @Test
    void testHoeUseToolNonPlantableSoil() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);

        hoe.useTool(soil);

        assertTrue(soil.getIsPlantable());
    }

    @Test
    void testHoeUseToolPlantableSoil() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();

        hoe.useTool(soil);

        assertFalse(soil.getIsPlantable());
    }

    @Test
    void testHoeToString() {
        assertEquals("Tool{name='Hoe', quantity=1, buyPrice=1000}", hoe.toString());
    }

    @Test
    void testHoeToStringAfterIncrementing() {
        hoe.addQuantity();
        assertEquals("Tool{name='Hoe', quantity=2, buyPrice=1000}", hoe.toString());
    }

    @Test
    void testHoeToStringAfterDecrementing() {
        hoe.subtractQuantity();
        assertEquals("Tool{name='Hoe', quantity=0, buyPrice=1000}", hoe.toString());
    }

    @Test
    void testHoeEquals() {
        Hoe newHoe = new Hoe();
        assertEquals(newHoe, hoe);
    }

    @Test
    void testHoeEqualsAfterIncrementing() {
        Hoe newHoe = new Hoe();
        newHoe.addQuantity();
        assertEquals(newHoe, hoe);
    }

    @Test
    void testHoeEqualsAfterDecrementing() {
        Hoe newHoe = new Hoe();
        newHoe.subtractQuantity();
        assertEquals(newHoe, hoe);
    }

    @Test
    void testHoeHashCodeEquals() {
        Hoe newHoe = new Hoe();
        assertEquals(newHoe.hashCode(), hoe.hashCode());
    }

    @Test
    void testHoeHashCodeNotEquals() {
        Hoe newHoe = new Hoe();
        hoe.addQuantity();
        boolean result = newHoe.hashCode() == hoe.hashCode();
        assertFalse(result);
    }
}
