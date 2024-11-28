package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoilTest {
    private final int xCoordinate = 3;
    private final int yCoordinate = 3;
    private final int cellSize = 50;

    private final int invalidX = -1;
    private final int invalidY = -1;
    private final int invalidCellSize = -1;

    @Test
    void testInvalidXCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Soil(invalidX, yCoordinate, cellSize));
        assertEquals("X Coordinate and Y Coordinate out of range.", exception.getMessage());
    }

    @Test
    void testInvalidYCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Soil(xCoordinate, invalidY, cellSize));
        assertEquals("X Coordinate and Y Coordinate out of range.", exception.getMessage());
    }

    @Test
    void testInvalidCellSize() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Soil(xCoordinate, yCoordinate, invalidCellSize));
        assertEquals("Cell size must be a positive integer.", exception.getMessage());
    }

    @Test
    void testGetXCoordinate() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertEquals(3, soil.getXCoordinate());
    }

    @Test
    void testGetYCoordinate() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertEquals(3, soil.getYCoordinate());
    }

    @Test
    void testGetDecorator() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertNull(soil.getDecorator());
    }

    @Test
    void testSetDecorator() {
        Grass grass = new Grass();
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.setDecorator(grass);
        assertEquals(grass, soil.getDecorator());
    }

    @Test
    void testInitialPlantableStatus() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertFalse(soil.getIsPlantable());
    }

    @Test
    void testTogglePlantableFromFalse() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();
        assertTrue(soil.getIsPlantable());
    }

    @Test
    void testTogglePlantableFromTrue() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.togglePlantable();
        soil.togglePlantable();
        assertFalse(soil.getIsPlantable());
    }

    @Test
    void testInitialWatered() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertFalse(soil.getIsWatered());
    }

    @Test
    void testWaterSoil() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.waterSoil();
        assertTrue(soil.getIsWatered());
    }

    @Test
    void testDrySoil() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        soil.drySoil();
        assertFalse(soil.getIsWatered());
    }

    @Test
    void testToString() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        assertEquals("Soil{isPlantable=false, isWatered=false}", soil.toString());
    }

    @Test
    void testEquals() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        Soil soil1 = new Soil(xCoordinate, yCoordinate, cellSize);
        assertEquals(soil, soil1);
    }

    @Test
    void testNonEquals() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        Ground ground = new Ground(xCoordinate, yCoordinate, cellSize);
        assertNotEquals(soil, ground);
    }

    @Test
    void testHashEquals() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        Soil soil1 = new Soil(xCoordinate, yCoordinate, cellSize);
        assertEquals(soil.hashCode(), soil1.hashCode());
    }

    @Test
    void testNonHashEquals() {
        Soil soil = new Soil(xCoordinate, yCoordinate, cellSize);
        Ground ground = new Ground(xCoordinate, yCoordinate, cellSize);
        assertNotEquals(soil.hashCode(), ground.hashCode());
    }

}