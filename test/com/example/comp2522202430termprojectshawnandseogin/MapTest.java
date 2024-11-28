package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    private final int xCoordinate = 10;
    private final int yCoordinate = 10;
    private final int cellSize = 50;
    private final int secondX = 11;

    private final int invalidX = -1;
    private final int invalidY = -1;
    private final int invalidCellSize = -1;

    @Test
    void testInvalidXCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Map(invalidX, yCoordinate, cellSize));
        assertEquals("Rows or columns must be a positive number.", exception.getMessage());
    }

    @Test
    void testInvalidYCoordinate() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Map(xCoordinate, invalidY, cellSize));
        assertEquals("Rows or columns must be a positive number.", exception.getMessage());
    }

    @Test
    void testInvalidCellSize() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Map(xCoordinate, yCoordinate, invalidCellSize));
        assertEquals("Cell size must be bigger than or equal to zero.", exception.getMessage());
    }

    @Test
    void testGetBoard() {
        Map map = new Map(xCoordinate, yCoordinate, cellSize);
        List<Tile> board = new ArrayList<>();
        assertEquals(board, map.getBoard());
    }

    @Test
    void testToString() {
        Map map = new Map(xCoordinate, yCoordinate, cellSize);
        assertEquals("Map{rows=10, cols=10, cellSize=50, board=[]}", map.toString());
    }

    @Test
    void testEquals() {
        Map map = new Map(xCoordinate, yCoordinate, cellSize);
        Map map1 = new Map(xCoordinate, yCoordinate, cellSize);
        assertEquals(map, map1);
    }

    @Test
    void testNotEquals() {
        Map map = new Map(xCoordinate, yCoordinate, cellSize);
        Map map1 = new Map(secondX, yCoordinate, cellSize);
        assertNotEquals(map, map1);
    }

    @Test
    void testEqualHashCode() {
        Map map = new Map(xCoordinate, yCoordinate, cellSize);
        Map map1 = new Map(xCoordinate, yCoordinate, cellSize);
        assertEquals(map.hashCode(), map1.hashCode());
    }

    @Test
    void testNotEqualHashCode() {
        Map map = new Map(xCoordinate, yCoordinate, cellSize);
        Map map1 = new Map(secondX, yCoordinate, cellSize);
        assertNotEquals(map.hashCode(), map1.hashCode());
    }

}