package com.example.comp2522202430termprojectshawnandseogin;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

public final class Player extends Character {
    private BigInteger money;
    private Item hand;
    private Image[] walkFront;
    private Image[] walkBack;
    private Image[] walkLeft;
    private Image[] walkRight;
    private Image currentFrame;
    private GraphicsContext gc;
    private int frameIndex;
    private long lastFrameTime;

    public Player(final String name, final GraphicsContext gc, final int x, final int y) {
        super(name, gc, x, y);

        this.gc = gc;
        this.money = new BigInteger("0");
        this.hand = null;

        // Load animation frames
        this.walkFront = new Image[]{
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front1.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front2.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front3.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front4.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front5.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front6.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front7.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_front/front8.png")))
        };

        this.walkBack = new Image[]{
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back1.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back2.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back3.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back4.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back5.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back6.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back7.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_back/back8.png")))
        };

        this.walkLeft = new Image[]{
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left1.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left2.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left3.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left4.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left5.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left6.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left7.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_left/left8.png")))
        };
//
        this.walkRight = new Image[]{
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right1.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right2.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right3.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right4.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right5.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right6.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right7.png"))),
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Player_right/right8.png")))
        };

        this.currentFrame = walkFront[0];
        this.frameIndex = 0;
        this.lastFrameTime = 0;
    }

    public void draw() {
//        gc.clearRect(this.xCoordinate * Main.CELLSIZE, this.yCoordinate * Main.CELLSIZE, Main.CELLSIZE, Main.CELLSIZE);
        gc.drawImage(currentFrame, this.xCoordinate * Main.CELLSIZE, this.yCoordinate * Main.CELLSIZE, Main.CELLSIZE, Main.CELLSIZE);
    }

    public void move(final Direction dir) {
        switch (dir) {
            case up -> {
                if (this.yCoordinate > 0) {
                    this.yCoordinate--;
                    animate(walkBack);
                }
            }
            case down -> {
                if (this.yCoordinate < Main.COLS - 1) {
                    this.yCoordinate++;
                    animate(walkFront);
                }
            }
            case left -> {
                if (this.xCoordinate > 0) {
                    this.xCoordinate--;
                    animate(walkLeft);
                }
            }
            case right -> {
                if (this.xCoordinate < Main.ROWS - 1) {
                    this.xCoordinate++;
                    animate(walkRight);
                }
            }
            default -> throw new IllegalArgumentException("Invalid Direction.");
        }
    }

    private void animate(Image[] frames) {
        long now = System.nanoTime();
        if (now - lastFrameTime > 0) {
            frameIndex = (frameIndex + 1) % frames.length;
            currentFrame = frames[frameIndex];
            lastFrameTime = now;
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
