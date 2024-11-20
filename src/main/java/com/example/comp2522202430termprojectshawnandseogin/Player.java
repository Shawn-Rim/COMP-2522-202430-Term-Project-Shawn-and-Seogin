package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public final class Player extends Character {
    private static final int IMAGE_SIZE = 8;
    private static final Image[] FRONT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] BACK_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] RIGHT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] LEFT_IMAGES = new Image[IMAGE_SIZE];
    private static final Image[] FRONT_HOE = new Image[IMAGE_SIZE];
    private static final Image[] BACK_HOE = new Image[IMAGE_SIZE];
    private static final Image[] RIGHT_HOE = new Image[IMAGE_SIZE];
    private static final Image[] LEFT_HOE = new Image[IMAGE_SIZE];
    private static final Image[] FRONT_WATER_CAN = new Image[IMAGE_SIZE];
    private static final Image[] BACK_WATER_CAN = new Image[IMAGE_SIZE];
    private static final Image[] RIGHT_WATER_CAN = new Image[IMAGE_SIZE];
    private static final Image[] LEFT_WATER_CAN = new Image[IMAGE_SIZE];

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
            FRONT_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_front_hoe/frontHoe" + i + ".png")));
            BACK_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_back_hoe/backHoe" + i + ".png")));
            RIGHT_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_right_hoe/rightHoe" + i + ".png")));
            LEFT_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_left_hoe/leftHoe" + i + ".png")));
            FRONT_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_front_watercan/frontWatercan" + i + ".png")));
            BACK_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_back_watercan/backWatercan" + i + ".png")));
            RIGHT_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_right_watercan/rightWatercan" + i + ".png")));
            LEFT_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream("/Player/Player_left_watercan/leftWatercan" + i + ".png")));
        }
    }

    public Player(final String name, final GraphicsContext gc, final int x, final int y, final int cellSize) {
        super(name, gc, x, y, cellSize);

        this.gc = gc;
        this.money = new BigInteger("0");
        this.view = Direction.down;
        this.hand = new WateringCan();

        this.currentFrame = FRONT_IMAGES[0];
        this.frameIndex = 0;
        this.lastFrameTime = 0;
    }

    @Override
    public void drawCharacter() {
        gc.drawImage(currentFrame, this.xCoordinate * this.cellSize, this.yCoordinate * this.cellSize,
                this.cellSize, this.cellSize);
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
                return !(tile instanceof BlockTile);
            }
        }

        return false;
    }

    public void move(final Direction dir, final List<Tile> board) {
        switch (dir) {
            case up -> {
                if (this.view == dir && validMove(board, this.xCoordinate, this.yCoordinate - 1)) {
                    this.yCoordinate--;
                }
                this.view = Direction.up;
                animate(BACK_IMAGES);
            }
            case down -> {
                if (this.view == dir && validMove(board, this.xCoordinate, this.yCoordinate + 1)) {
                    this.yCoordinate++;
                }
                this.view = Direction.down;
                animate(FRONT_IMAGES);
            }
            case left -> {
                if (this.view == dir && validMove(board, this.xCoordinate - 1, this.yCoordinate)) {
                    this.xCoordinate--;
                }
                this.view = Direction.left;
                animate(LEFT_IMAGES);
            }
            case right -> {
                if (this.view == dir && validMove(board, this.xCoordinate + 1, this.yCoordinate)) {
                    this.xCoordinate++;
                }
                this.view = Direction.right;
                animate(RIGHT_IMAGES);
            }
            default -> throw new IllegalArgumentException("Invalid Direction.");
        }
    }

    private void playFullSetAnimation(Image[] frames) {
        Timeline timeline = new Timeline();

        for (int i = 0; i < IMAGE_SIZE; i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100 * (i + 1)), e -> {
                currentFrame = frames[index];
                drawCharacter();
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> {
            switch(this.view){
                case down -> currentFrame = FRONT_IMAGES[0];
                case up -> currentFrame = BACK_IMAGES[0];
                case right -> currentFrame = RIGHT_IMAGES[0];
                case left -> currentFrame = LEFT_IMAGES[0];
            }

            drawCharacter();
        });

        timeline.setCycleCount(1);
        timeline.play();
    }


    public void interact(final List<Tile> board) {
        Tile interactingTile = null;
        int x = 0;
        int y = 0;

        switch (this.view) {
            case up -> y = -1;
            case down -> y = 1;
            case left -> x = -1;
            case right -> x = 1;
        }

        // Find the tile that the player is looking at
        for (Tile tile : board) {
            if (tile.xCoordinate == this.xCoordinate + x && tile.yCoordinate == this.yCoordinate + y) {
                interactingTile = tile;
                break;
            }
        }

        if (interactingTile == null) {
            return;
        }

        // Use tool if interacting tile is Soil and current item in hand is Tool
        if (interactingTile instanceof Soil && this.hand instanceof Tool) {
            ((Tool) this.hand).useTool((Soil) interactingTile);
            if (this.hand instanceof Hoe) {
                switch (this.view){
                    case down -> playFullSetAnimation(FRONT_HOE);
                    case up -> playFullSetAnimation(BACK_HOE);
                    case right -> playFullSetAnimation(RIGHT_HOE);
                    case left -> playFullSetAnimation(LEFT_HOE);
                }
            } else {
                switch (this.view) {
                    case down -> playFullSetAnimation(FRONT_WATER_CAN);
                    case up -> playFullSetAnimation(BACK_WATER_CAN);
                    case right -> playFullSetAnimation(RIGHT_WATER_CAN);
                    case left -> playFullSetAnimation(LEFT_WATER_CAN);
                }
            }
        } else if (interactingTile.getDecorator() != null && this.hand instanceof Tool) {
            interactingTile.getDecorator().interact((Tool) this.hand);
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
