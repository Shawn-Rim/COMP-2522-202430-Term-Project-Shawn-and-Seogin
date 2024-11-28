package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class EggplantTest {
    private Eggplant eggplant;

    @BeforeEach
    void setUp() {
        eggplant = new Eggplant();
    }

    @Test
    void testEggplantGetName() {
        assertEquals("Eggplant", eggplant.getName());
    }

    @Test
    void testEggplantGetSellPrice() {
        assertEquals(new BigInteger("1000"), eggplant.getSellPrice());
    }

    @Test
    void testEggplantInitialQuantity() {
        assertEquals(1, eggplant.getQuantity());
    }

    @Test
    void testEggplantIncrementQuantity() {
        eggplant.addQuantity();
        assertEquals(2, eggplant.getQuantity());
    }

    @Test
    void testEggplantDecrementQuantity() {
        eggplant.subtractQuantity();
        assertEquals(0, eggplant.getQuantity());
    }

    @Test
    void testEggplantToString() {
        assertEquals("Crop{name='Eggplant', quantity=1, sellPrice=1000}", eggplant.toString());
    }

    @Test
    void testEggplantToStringAfterIncrementing() {
        eggplant.addQuantity();
        assertEquals("Crop{name='Eggplant', quantity=2, sellPrice=1000}", eggplant.toString());
    }

    @Test
    void testEggplantToStringAfterDecrementing() {
        eggplant.subtractQuantity();
        assertEquals("Crop{name='Eggplant', quantity=0, sellPrice=1000}", eggplant.toString());
    }

    @Test
    void testEggplantEquals() {
        Eggplant newEggplant = new Eggplant();
        assertEquals(newEggplant, eggplant);
    }

    @Test
    void testEggplantEqualsAfterIncrementing() {
        Eggplant newEggplant = new Eggplant();
        newEggplant.addQuantity();
        assertEquals(newEggplant, eggplant);
    }

    @Test
    void testEggplantEqualsAfterDecrementing() {
        Eggplant newEggplant = new Eggplant();
        newEggplant.subtractQuantity();
        assertEquals(newEggplant, eggplant);
    }

    @Test
    void testEggplantHashCodeEquals() {
        Eggplant newEggplant = new Eggplant();
        assertEquals(newEggplant.hashCode(), eggplant.hashCode());
    }

    @Test
    void testEggplantHashCodeNotEquals() {
        Eggplant newEggplant = new Eggplant();
        eggplant.addQuantity();
        boolean result = newEggplant.hashCode() == eggplant.hashCode();
        assertFalse(result);
    }
}