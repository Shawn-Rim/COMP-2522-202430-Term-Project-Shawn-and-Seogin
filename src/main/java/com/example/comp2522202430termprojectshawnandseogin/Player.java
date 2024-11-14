package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public final class Player extends Character {
    private static final int IMAGE_SIZE = 8;
    private static final Image[] FRONT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] BACK_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] RIGHT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] LEFT_IMAGES = new Image[IMAGE_SIZE];

    private BigInteger money;
    private Direction view;
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
        this.view = Direction.down;
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

    private boolean validMove(final List<Tile> board, final int xCoordinate, final int yCoordinate) {
        for (Tile tile : board) {
            if (tile.xCoordinate == xCoordinate && tile.yCoordinate == yCoordinate) {
                return !(tile instanceof Water);
            }
        }

        return false;
    }

    public void move(final Direction dir, final List<Tile> board) {
        switch (dir) {
            case up -> {
                if (validMove(board, this.xCoordinate, this.yCoordinate - 1)) {
                    this.yCoordinate--;
                }
                this.view = Direction.up;
                animate(BACK_IMAGES);
            }
            case down -> {
                if (validMove(board, this.xCoordinate, this.yCoordinate + 1)) {
                    this.yCoordinate++;
                }
                this.view = Direction.down;
                animate(FRONT_IMAGES);
            }
            case left -> {
                if (validMove(board, this.xCoordinate - 1, this.yCoordinate)) {
                    this.xCoordinate--;
                }
                this.view = Direction.left;
                animate(LEFT_IMAGES);
            }
            case right -> {
                if (validMove(board, this.xCoordinate + 1, this.yCoordinate)) {
                    this.xCoordinate++;
                }
                this.view = Direction.right;
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
