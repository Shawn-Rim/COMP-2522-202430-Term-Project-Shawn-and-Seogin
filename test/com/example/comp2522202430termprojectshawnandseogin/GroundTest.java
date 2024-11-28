package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroundTest {
    private Ground ground;

    @BeforeEach
    void setup() {
        final int xCoordinate = 5;
        final int yCoordinate = 5;
        final int cellSize = 5;
        ground = new Ground(xCoordinate, yCoordinate, cellSize);
    }

    @Test
    void testGroundFullConstructor() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        final GroundDirection dir = GroundDirection.leftBottom;
        ground = new Ground(xCoordinate, yCoordinate, cellSize, dir);

        assertEquals(xCoordinate, ground.getXCoordinate());
        assertEquals(yCoordinate, ground.getYCoordinate());
        assertNull(ground.getDecorator());
        assertEquals(dir, ground.getDir());
    }

    @Test
    void testGroundSimpleConstructor() {
        final int xCoordinate = 0;
        final int yCoordinate = 0;
        final int cellSize = 5;
        ground = new Ground(xCoordinate, yCoordinate, cellSize);

        assertEquals(xCoordinate, ground.getXCoordinate());
        assertEquals(yCoordinate, ground.getYCoordinate());
        assertNull(ground.getDecorator());
        assertEquals(GroundDirection.middle, ground.getDir());
    }

    @Test
    void testGroundGetXCoordinate() {
        assertEquals(5, ground.getXCoordinate());
    }

    @Test
    void testGroundGetYCoordinate() {
        assertEquals(5, ground.getYCoordinate());
    }

    @Test
    void testGroundGetDecorator() {
        assertNull(ground.getDecorator());
    }

    @Test
    void testGroundSetDecorator() {
        Decorator decorator = new Grass();
        ground.setDecorator(decorator);

        assertEquals(decorator, ground.getDecorator());
    }

    @Test
    void testGroundToString() {
        assertEquals(
                "Ground{decorator=null, xCoordinate=5, yCoordinate=5, cellSize=5, dir=middle}",
                ground.toString()
        );
    }

    @Test
    void testGroundToStringWithDecorator() {
        Decorator decorator = new Grass();
        ground.setDecorator(decorator);

        assertEquals(
                "Ground{decorator=Grass{}, xCoordinate=5, yCoordinate=5, cellSize=5, dir=middle}",
                ground.toString()
        );
    }

    @Test
    void testGroundEquals() {
        final int sameX = 5;
        final int sameY = 5;
        final int sameCellSize = 5;
        final GroundDirection sameDir = GroundDirection.middle;
        Ground newGround = new Ground(sameX, sameY, sameCellSize, sameDir);

        assertEquals(newGround, ground);
    }

    @Test
    void testGroundXNotEquals() {
        final int diffX = 0;
        final int sameY = 5;
        final int sameCellSize = 5;
        final GroundDirection sameDir = GroundDirection.middle;
        Ground newGround = new Ground(diffX, sameY, sameCellSize, sameDir);

        boolean result = ground.equals(newGround);

        assertFalse(result);
    }

    @Test
    void testGroundYNotEquals() {
        final int sameX = 5;
        final int diffY = 0;
        final int sameCellSize = 5;
        final GroundDirection sameDir = GroundDirection.middle;
        Ground newGround = new Ground(sameX, diffY, sameCellSize, sameDir);

        boolean result = ground.equals(newGround);

        assertFalse(result);
    }

    @Test
    void testGroundCellSizeNotEquals() {
        final int sameX = 5;
        final int sameY = 5;
        final int diffCellSize = 50;
        final GroundDirection sameDir = GroundDirection.middle;
        Ground newGround = new Ground(sameX, sameY, diffCellSize, sameDir);

        boolean result = ground.equals(newGround);

        assertFalse(result);
    }

    @Test
    void testGroundDirectionNotEquals() {
        final int sameX = 5;
        final int sameY = 5;
        final int sameCellSize = 5;
        final GroundDirection diffDir = GroundDirection.leftBottom;
        Ground newGround = new Ground(sameX, sameY, sameCellSize, diffDir);

        boolean result = ground.equals(newGround);

        assertFalse(result);
    }

    @Test
    void testGroundHashCodeEquals() {
        final int sameX = 5;
        final int sameY = 5;
        final int sameCellSize = 5;
        final GroundDirection sameDir = GroundDirection.middle;
        Ground newGround = new Ground(sameX, sameY, sameCellSize, sameDir);

        assertEquals(newGround.hashCode(), ground.hashCode());
    }

    @Test
    void testGroundHashCodeNotEquals() {
        final int diffX = 0;
        final int diffY = 0;
        final int diffCellSize = 50;
        final GroundDirection diffDir = GroundDirection.leftBottom;
        Ground newGround = new Ground(diffX, diffY, diffCellSize, diffDir);

        boolean result = newGround.hashCode() == ground.hashCode();

        assertFalse(result);
    }
}
