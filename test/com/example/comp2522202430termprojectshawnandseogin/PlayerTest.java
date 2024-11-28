package com.example.comp2522202430termprojectshawnandseogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private final int xCoordinate = 3;
    private final int yCoordinate = 3;
    private final int cellSize = 50;

    private final int invalidX = -1;
    private final int invalidY = -1;
    private final int invalidCellSize = -1;

    private Player character;
    private Map board;

    @BeforeEach
    void setup() {
        character = new Player(xCoordinate, yCoordinate, cellSize);
        board = new Map(10, 10, 50);
        board.makeBoard();
    }

    @Test
    void testValidConstructor() {
        Player player = new Player(xCoordinate, yCoordinate, cellSize);

        assertEquals(xCoordinate, player.getXCoordinate());
        assertEquals(yCoordinate, player.getYCoordinate());
        assertEquals("-10000", player.getMoney());
        assertEquals(new Hoe(), player.getHand());
    }

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
    void testGetXCoordinate() {
        assertEquals(xCoordinate, character.getXCoordinate());
    }

    @Test
    void testGetYCoordinate() {
        assertEquals(yCoordinate, character.getYCoordinate());
    }

    @Test
    void testGetHand() {
        Hoe hoe = new Hoe();
        assertEquals(hoe, character.getHand());
    }

    @Test
    void testMoveUp() {
        // Need to move twice to face upwards then actually move
        character.move(Direction.up, board.getBoard());
        character.move(Direction.up, board.getBoard());

        assertEquals(3, character.getXCoordinate());
        assertEquals(2, character.getYCoordinate());
    }

    @Test
    void testMoveDown() {
        character.move(Direction.down, board.getBoard());

        assertEquals(3, character.getXCoordinate());
        assertEquals(4, character.getYCoordinate());
    }

    @Test
    void testMoveLeft() {
        // Need to move twice to face left then actually move
        character.move(Direction.left, board.getBoard());
        character.move(Direction.left, board.getBoard());

        assertEquals(2, character.getXCoordinate());
        assertEquals(3, character.getYCoordinate());
    }

    @Test
    void testMoveRight() {
        // Need to move twice to face right then actually move
        character.move(Direction.right, board.getBoard());
        character.move(Direction.right, board.getBoard());

        assertEquals(4, character.getXCoordinate());
        assertEquals(3, character.getYCoordinate());
    }

    @Test
    void testAddMoney() {
        BigInteger value = new BigInteger("10000");
        character.addMoney(value);

        assertEquals("0", character.getMoney());
    }

    @Test
    void testSubtractMoney() {
        BigInteger value = new BigInteger("10000");
        character.subtractMoney(value);

        assertEquals("-20000", character.getMoney());
    }

    @Test
    void testGetMoney() {
        assertEquals("-10000", character.getMoney());
    }

    @Test
    void testChangeHandToWateringCan() {
        character.changeHand(1);
        assertEquals(new WateringCan(), character.getHand());
    }

    @Test
    void testChangeHandToNull() {
        character.changeHand(5);
        assertNull(character.getHand());
    }

    @Test
    void testChangeHandIndexLessThanZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> character.changeHand(-1));
        assertEquals("Index out of bounds.", exception.getMessage());
    }

    @Test
    void testChangeHandIndexBiggerThanMaximumCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> character.changeHand(Inventory.MAX_CAPACITY + 1));
        assertEquals("Index out of bounds.", exception.getMessage());
    }

    @Test
    void testToString() {
        assertEquals(
                "Player{inventory=Inventory{items=[" +
                        "Tool{name='Hoe', quantity=1, buyPrice=1000}" +
                        ", Tool{name='Watering Can', quantity=1, buyPrice=1000, remainingUses=0}" +
                        ", null, null, null, null]}" +
                        ", xCoordinate=3, yCoordinate=3, cellSize=50, money=-10000, view=down" +
                        ", hand=Tool{name='Hoe', quantity=1, buyPrice=1000}}"
                , character.toString()
        );
    }

    @Test
    void testEquals() {
        Player player = new Player(xCoordinate, yCoordinate, cellSize);
        assertEquals(player, character);
    }

    @Test
    void testNotEquals() {
        Player player = new Player(xCoordinate + 1, yCoordinate, cellSize);
        assertNotEquals(player, character);
    }

    @Test
    void testHashCodeEquals() {
        Player player = new Player(xCoordinate, yCoordinate, cellSize);
        assertEquals(player.hashCode(), character.hashCode());
    }

    @Test
    void testHashCodeNotEquals() {
        Player player = new Player(xCoordinate, yCoordinate + 1, cellSize);
        assertNotEquals(player.hashCode(), character.hashCode());
    }
}