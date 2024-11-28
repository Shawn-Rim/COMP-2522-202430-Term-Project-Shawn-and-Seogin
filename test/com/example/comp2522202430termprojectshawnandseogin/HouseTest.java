package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {
    private House house;

    @BeforeEach
    void setup() {
        house = new House(false);
    }

    @Test
    void testHouseToString() {
        assertEquals("House{showHouse=false}", house.toString());
    }

    @Test
    void testHouseToStringShowHouseTrue() {
        house = new House(true);
        assertEquals("House{showHouse=true}", house.toString());
    }

    @Test
    void testHouseEquals() {
        House newHouse = new House(false);
        assertEquals(newHouse, house);
    }

    @Test
    void testHouseNotEquals() {
        House newHouse = new House(true);
        boolean result = house.equals(newHouse);
        assertFalse(result);
    }

    @Test
    void testHouseHashCodeEquals() {
        House newHouse = new House(false);
        assertEquals(newHouse.hashCode(), house.hashCode());
    }

    @Test
    void testHouseHashCodeNotEquals() {
        House newHouse = new House(true);
        boolean result = newHouse.hashCode() == house.hashCode();
        assertFalse(result);
    }
}
