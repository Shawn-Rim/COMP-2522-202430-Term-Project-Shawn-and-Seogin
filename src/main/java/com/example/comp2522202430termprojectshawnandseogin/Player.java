package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

public final class Player extends Character {
    private static final int IMAGE_SIZE = 8;
    private static final Image[] FRONT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] BACK_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] RIGHT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] LEFT_IMAGES = new Image[IMAGE_SIZE];

    private BigInteger money;
    private Item hand;
    private Image currentFrame;
    private GraphicsContext gc;
    private int frameIndex;
    private long lastFrameTime;

    static {
        // Initialize images
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            FRONT_IMAGES[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_front/front" + i + ".png")));
            BACK_IMAGES[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_back/back" + i + ".png")));
            RIGHT_IMAGES[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_right/right" + i + ".png")));
            LEFT_IMAGES[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_left/left" + i + ".png")));
        }
    }

    public Player(final String name, final GraphicsContext gc, final int x, final int y) {
        super(name, gc, x, y);

        this.gc = gc;
        this.money = new BigInteger("0");
        this.hand = null;

        this.currentFrame = FRONT_IMAGES[0];
        this.frameIndex = 0;
        this.lastFrameTime = 0;
    }

    @Override
    public void drawCharacter() {
        gc.drawImage(currentFrame, this.xCoordinate * Main.CELLSIZE, this.yCoordinate * Main.CELLSIZE, Main.CELLSIZE, Main.CELLSIZE);
    }

    private void animate(Image[] frames) {
        long now = System.nanoTime();
        if (now - lastFrameTime > 0) {
            frameIndex = (frameIndex + 1) % frames.length;
            currentFrame = frames[frameIndex];
            lastFrameTime = now;
        }
    }

    public void move(final Direction dir) {
        switch (dir) {
            case up -> {
                if (this.yCoordinate > 0) {
                    this.yCoordinate--;
                }
                animate(BACK_IMAGES);
            }
            case down -> {
                if (this.yCoordinate < Main.COLS - 1) {
                    this.yCoordinate++;
                }
                animate(FRONT_IMAGES);
            }
            case left -> {
                if (this.xCoordinate > 0) {
                    this.xCoordinate--;
                }
                animate(LEFT_IMAGES);
            }
            case right -> {
                if (this.xCoordinate < Main.ROWS - 1) {
                    this.xCoordinate++;
                }
                animate(RIGHT_IMAGES);
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
