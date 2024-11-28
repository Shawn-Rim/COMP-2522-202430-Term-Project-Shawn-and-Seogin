package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Represents a game character with movement, animations, and interactions.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
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
    private transient Image currentFrame = FRONT_IMAGES[0];

    private BigInteger money;
    private Direction view;
    private Item hand;
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
                    Player.class.getResourceAsStream(
                            "/Player/Player_front_hoe/frontHoe" + i + ".png")));
            BACK_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_back_hoe/backHoe" + i + ".png")));
            RIGHT_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_right_hoe/rightHoe" + i + ".png")));
            LEFT_HOE[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_left_hoe/leftHoe" + i + ".png")));
            FRONT_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_front_watercan/frontWatercan" + i + ".png")));
            BACK_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_back_watercan/backWatercan" + i + ".png")));
            RIGHT_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_right_watercan/rightWatercan" + i + ".png")));
            LEFT_WATER_CAN[i - 1] = new Image(Objects.requireNonNull(
                    Player.class.getResourceAsStream(
                            "/Player/Player_left_watercan/leftWatercan" + i + ".png")));
        }
    }

    /**
     * Constructs an object Type of Player.
     *
     * @param x of x coordinate
     * @param y of y coordinate
     * @param cellSize of int
     */
    public Player(final int x, final int y, final int cellSize) {
        super(x, y, cellSize);

        this.money = new BigInteger("-10000");
        this.view = Direction.down;
        this.hand = inventory.getItem(0);

        this.frameIndex = 0;
        this.lastFrameTime = 0;
    }

    /**
     * Returns the currently selected item.
     *
     * @return the hand of player as an Item
     */
    public Item getHand() {
        return this.hand;
    }

    /**
     * Draws Character.
     */
    @Override
    public void drawCharacter() {
        GameManager.getGameManager().getGraphicsContext()
                .drawImage(currentFrame, this.xCoordinate * this.cellSize,
                        this.yCoordinate * this.cellSize, this.cellSize, this.cellSize);
    }

    /**
     * Updates the current frame for animation based on time and cycles through the provided frames.
     *
     * @param frames Array of Image
     */
    private void animate(final Image[] frames) {
        long now = System.nanoTime();
        if (now - lastFrameTime > 0) {
            frameIndex = (frameIndex + 1) % frames.length;
            currentFrame = frames[frameIndex];
            lastFrameTime = now;
        }
    }

    /**
     * Checks if the target coordinates on the board are valid for movement.
     *
     * @param board List of Tile
     * @param xCoordinate of int
     * @param yCoordinate of int
     * @return true if the move is valid, false otherwise
     */
    private boolean validMove(final List<Tile> board,
                              final int xCoordinate, final int yCoordinate) {
        for (Tile tile : board) {
            if (tile.xCoordinate == xCoordinate && tile.yCoordinate == yCoordinate) {
                return !(tile instanceof BlockTile);
            }
        }

        return false;
    }

    /**
     * Moves character based on user's input.
     *
     * @param dir Direction as an enum
     * @param board List of Tile
     * @throws IllegalArgumentException if the input is not in the direction
     */
    public void move(final Direction dir, final List<Tile> board)
            throws IllegalArgumentException {
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

    /**
     * Plays a full animation sequence using the provided frames.
     *
     * @param frames Array of Image
     * @throws IllegalStateException if the next tile is not in the view
     */
    private void playFullSetAnimation(final Image[] frames) throws IllegalStateException {
        Timeline timeline = new Timeline();
        final int changeToMillis = 100;

        for (int i = 0; i < IMAGE_SIZE; i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(changeToMillis * (i + 1)), e -> {
                currentFrame = frames[index];
                drawCharacter();
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> {
            switch (this.view) {
                case down -> currentFrame = FRONT_IMAGES[0];
                case up -> currentFrame = BACK_IMAGES[0];
                case right -> currentFrame = RIGHT_IMAGES[0];
                case left -> currentFrame = LEFT_IMAGES[0];
                default -> throw new IllegalStateException("Invalid view.");
            }

            drawCharacter();
        });

        timeline.setCycleCount(1);
        timeline.play();
    }

    /**
     * Interacts with Tiles in board.
     *
     * @param board List of Tile
     * @throws IllegalStateException if the view is not in the view
     */
    public void interact(final List<Tile> board) throws IllegalStateException {
        Tile interactingTile = null;
        int x = 0;
        int y = 0;

        switch (this.view) {
            case up -> y = -1;
            case down -> y = 1;
            case left -> x = -1;
            case right -> x = 1;
            default -> throw new IllegalStateException("Invalid view.");
        }

        // Find the tile that the player is looking at
        for (Tile tile : board) {
            if (tile.xCoordinate == this.xCoordinate + x
                    && tile.yCoordinate == this.yCoordinate + y) {
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
                switch (this.view) {
                    case down -> playFullSetAnimation(FRONT_HOE);
                    case up -> playFullSetAnimation(BACK_HOE);
                    case right -> playFullSetAnimation(RIGHT_HOE);
                    case left -> playFullSetAnimation(LEFT_HOE);
                    default -> throw new IllegalStateException("Invalid view.");
                }
            } else if (this.hand instanceof WateringCan) {
                switch (this.view) {
                    case down -> playFullSetAnimation(FRONT_WATER_CAN);
                    case up -> playFullSetAnimation(BACK_WATER_CAN);
                    case right -> playFullSetAnimation(RIGHT_WATER_CAN);
                    case left -> playFullSetAnimation(LEFT_WATER_CAN);
                    default -> throw new IllegalStateException("Invalid view.");
                }
            }
        }

        if (interactingTile.getDecorator() != null) {
            interactingTile.getDecorator().interact(this.hand);
        }
    }

    /**
     * Adds money to player's instance variable.
     *
     * @param value of BigInteger
     */
    public void addMoney(final BigInteger value) {
        this.money = this.money.add(value.abs());
    }

    /**
     * Subtracts money to player's instance variable.
     *
     * @param value of BigInteger
     */
    public void subtractMoney(final BigInteger value) {
        this.money = this.money.subtract(value.abs());
    }

    /**
     * Returns the money of player.
     *
     * @return money as a String
     */
    public String getMoney() {
        return this.money.toString();
    }

    /**
     * Changes the selected item.
     *
     * @param index as an int
     */
    public void changeHand(final int index) {
        this.hand = this.inventory.getItem(index);
    }

    /**
     * Returns a String representation of this Player.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        return "Player{" + "currentFrame=" + currentFrame + ", money="
                + money + ", view=" + view + ", hand=" + hand + ", frameIndex="
                + frameIndex + ", lastFrameTime=" + lastFrameTime + '}';
    }

    /**
     * Compares this Player object with another object for equality.
     *
     * @param object of Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Player player = (Player) object;
        return frameIndex == player.frameIndex && lastFrameTime == player.lastFrameTime
                && Objects.equals(currentFrame, player.currentFrame) && Objects.equals(money, player.money)
                && view == player.view && Objects.equals(hand, player.hand);
    }

    /**
     * Returns the hash code value for this Player object.
     *
     * @return hashcode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentFrame, money, view, hand, frameIndex, lastFrameTime);
    }
}
