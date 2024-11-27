package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoilTest {
    private final int xCoordinate = 3;
    private final int yCoordinate = 3;
    private final int cellSize = 50;

    @Test
    void testInitialStatus() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertFalse(soil.getIsPlantable());
    }
    @Test
    void testTogglePlantableFromFalse() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();
        assertTrue(soil.getIsPlantable());
    }

}