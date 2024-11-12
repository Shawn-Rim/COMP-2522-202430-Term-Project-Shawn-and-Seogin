package com.example.comp2522202430termprojectshawnandseogin;

import java.math.BigInteger;

public final class Player extends Character {
    private BigInteger money;
    private Item hand;

    public Player(final String name) {
        super(name);

        this.money = new BigInteger("0");
        this.hand = null;
    }

    public void move(final int xCoordinate, final int yCoordinate) {}

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
