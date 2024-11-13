package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.math.BigInteger;

public final class Player extends Character {
    private BigInteger money;
    private Item hand;

    public Player(final String name, final GraphicsContext gc, final int x, final int y) {
        super(name, gc, x, y);

        this.money = new BigInteger("0");
        this.hand = null;
    }

    public void move(final Direction dir) {
        switch(dir) {
            case up -> {
                if (this.yCoordinate > 0) {
                    this.yCoordinate--;
                }
            }
            case down -> {
                if (this.yCoordinate < Main.COLS - 1) {
                    this.yCoordinate++;
                }
            }
            case left -> {
                if (this.xCoordinate > 0) {
                    this.xCoordinate--;
                }
            }
            case right -> {
                if (this.xCoordinate < Main.ROWS - 1) {
                    this.xCoordinate++;
                }
            }
            default -> throw new IllegalArgumentException("Invalid Direction.");
        }
    }

    public void addMoney(BigInteger value) {
        this.money = this.money.add(value.abs());
    }

    public void subtractMoney(BigInteger value) {
        this.money = this.money.subtract(value.abs());
    }

    public void changeHand(final int index) {
        this.hand = this.inventory.getItem(index);
    }
}
