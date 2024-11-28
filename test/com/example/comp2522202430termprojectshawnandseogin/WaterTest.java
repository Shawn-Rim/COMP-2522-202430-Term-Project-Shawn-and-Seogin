package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterTest {
    private final int xCoordinate = 3;
    private final int yCoordinate = 3;
    private final int cellSize = 50;

    private final int invalidX = -1;
    private final int invalidY = -1;
    private final int invalidCellSize = -1;

    @Test
    void testInvalidXCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Water(invalidX, yCoordinate, cellSize));
        assertEquals("X Coordinate and Y Coordinate out of range.", exception.getMessage());
    }

    @Test
    void testInvalidYCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Water(xCoordinate, invalidY, cellSize));
        assertEquals("X Coordinate and Y Coordinate out of range.", exception.getMessage());
    }

    @Test
    void testInvalidCellSize() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Water(xCoordinate, yCoordinate, invalidCellSize));
        assertEquals("Cell size must be a positive integer.", exception.getMessage());
    }

    @Test
    void testGetXCoordinate() {
        Water water = new Water(xCoordinate, yCoordinate, cellSize);
        assertEquals(3, water.getXCoordinate());
    }

    @Test
    void testGetYCoordinate() {
        Water water = new Water(xCoordinate, yCoordinate, cellSize);
        assertEquals(3, water.getYCoordinate());
    }

    @Test
    void testGetDecorator() {
        Water water = new Water(xCoordinate, yCoordinate, cellSize);
        assertNull(water.getDecorator());
    }

    @Test
    void testSetDecorator() {
        Grass grass = new Grass();
        Water water = new Water(xCoordinate, yCoordinate, cellSize);
        water.setDecorator(grass);
        assertEquals(grass, water.getDecorator());
    }

}