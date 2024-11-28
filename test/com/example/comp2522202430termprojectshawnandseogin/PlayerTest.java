package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private final int xCoordinate = 3;
    private final int yCoordinate = 3;
    private final int cellSize = 50;

    private final int invalidX = -1;
    private final int invalidY = -1;
    private final int invalidCellSize = -1;

    @Test
    void testInvalidXCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Player(invalidX, yCoordinate, cellSize));
        assertEquals("X and Y Coordinate out of bounds.", exception.getMessage());
    }

    @Test
    void testInvalidYCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Player(xCoordinate, invalidY, cellSize));
        assertEquals("X and Y Coordinate out of bounds.", exception.getMessage());
    }

    @Test
    void testInvalidCellSize() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Player(xCoordinate, yCoordinate, invalidCellSize));
        assertEquals("Cell size must be a positive integer.", exception.getMessage());
    }

    @Test
    void testGetHand() {
        Hoe hoe = new Hoe();
        Player player = new Player(xCoordinate, yCoordinate, cellSize);
        assertEquals(hoe, player.getHand());
    }



}