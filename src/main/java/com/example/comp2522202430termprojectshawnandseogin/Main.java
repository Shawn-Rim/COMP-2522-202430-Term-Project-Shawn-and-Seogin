package com.example.comp2522202430termprojectshawnandseogin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * Represents an Item in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class Main extends Application {
    private static final int OFFSET_3 = 3;
    private static final int OFFSET_10 = 10;
    private static final int OFFSET_25 = 25;
    private static final int MONEY_TEXT_SIZE = 20;
    private static final int ARC = 25;

    private static GraphicsContext graphicsContext;
    private static Scene scene;

    private static final int ROWS = GameManager.ROWS;
    private static final int COLS = GameManager.COLS;
    private static final int CELL_SIZE = GameManager.CELL_SIZE;
    private static GameManager gameManager;
    private static Map board;
    private static Player player;
    private static Inventory playerInventory;

    private void initGame() {
        gameManager.setGraphicsContext(graphicsContext);
        board = gameManager.getBoard();
        player = gameManager.getPlayer();
        playerInventory = gameManager.getInventory();
    }

    private void movePlayerOnKeyPress() {
        final int digit0 = 0;
        final int digit1 = 1;
        final int digit2 = 2;
        final int digit3 = 3;
        final int digit4 = 4;
        final int digit5 = 5;
        scene.setOnKeyPressed((event -> {
            switch (event.getCode()) {
                case RIGHT -> player.move(Direction.right, board.getBoard());
                case LEFT -> player.move(Direction.left, board.getBoard());
                case DOWN -> player.move(Direction.down, board.getBoard());
                case UP -> player.move(Direction.up, board.getBoard());
                case SPACE -> player.interact(board.getBoard());
                case DIGIT1 -> player.changeHand(digit0);
                case DIGIT2 -> player.changeHand(digit1);
                case DIGIT3 -> player.changeHand(digit2);
                case DIGIT4 -> player.changeHand(digit3);
                case DIGIT5 -> player.changeHand(digit4);
                case DIGIT6 -> player.changeHand(digit5);
                default -> { }
            }
        }));
    }

    private void drawToolBox() {
        graphicsContext.setFill(Color.BURLYWOOD);
        graphicsContext.fillRect(0, COLS * CELL_SIZE, ROWS * CELL_SIZE, CELL_SIZE);

        playerInventory.checkItem();

        for (int i = 0; i < Inventory.MAX_CAPACITY; i++) {
            final int x = i * CELL_SIZE + OFFSET_3;
            final int y = COLS * CELL_SIZE + OFFSET_3;
            final Item item = playerInventory.getItem(i);

            // draw outline
            graphicsContext.setFill(Color.DARKGOLDENROD);
            if (item != null && item == player.getHand()) {
                graphicsContext.setFill(Color.CRIMSON);
            }
            graphicsContext.fillRoundRect(x, y, CELL_SIZE - OFFSET_3,
                    CELL_SIZE - OFFSET_3, ARC, ARC);

            graphicsContext.setFill(Color.MOCCASIN);
            graphicsContext.fillRoundRect(x + OFFSET_3, y + OFFSET_3,
                    CELL_SIZE - OFFSET_3 * OFFSET_3,
                    CELL_SIZE - OFFSET_3 * OFFSET_3, ARC, ARC);

            if (item != null) {
                item.drawItem(graphicsContext,
                        x + OFFSET_10 / 2, y + OFFSET_10 / 2, CELL_SIZE - OFFSET_10);
                if (item.getQuantity() > 1) {
                    graphicsContext.setFill(Color.BLACK);
                    graphicsContext.fillText(String.valueOf(item.getQuantity()),
                            x + OFFSET_3, y + OFFSET_10);
                }
            }
        }
    }

    private void run() {
        board.drawBoard();

        movePlayerOnKeyPress();

        player.drawCharacter();

        // Tool box
        drawToolBox();

        // Display money
        graphicsContext.setFill(Color.FORESTGREEN);
        graphicsContext.setFont(new Font(MONEY_TEXT_SIZE));
        graphicsContext.fillText(player.getMoney(), ROWS * CELL_SIZE - CELL_SIZE * 2,
                COLS * CELL_SIZE + OFFSET_25 + OFFSET_3 * 2);
    }

    @Override
    public void start(final Stage stage) {
        VBox layout = new VBox();
        Canvas canvas = new Canvas(ROWS * CELL_SIZE, COLS * CELL_SIZE + CELL_SIZE);
        graphicsContext = canvas.getGraphicsContext2D();
        layout.getChildren().add(canvas);

        gameManager = GameManager.getGameManager();
        initGame();

        // Main game loop: Invokes run() every frame
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> run()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Load Scene
        scene = new Scene(layout, ROWS * CELL_SIZE, COLS * CELL_SIZE + CELL_SIZE);
        stage.setTitle("Cash Crop");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        launch();
    }
}
