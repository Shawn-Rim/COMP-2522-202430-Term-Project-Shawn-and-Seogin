package com.example.comp2522202430termprojectshawnandseogin;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public final class Main extends Application {
    private static final int TOOLBOX_OFFSET = 3;
    private static final int ITEM_OFFSET = 10;
    private static final int TEXT_SIZE = 25;
    private static final int ARC = 25;

    public static GraphicsContext gc;
    private static Scene scene;

    private static final int ROWS = GameManager.ROWS;
    private static final int COLS = GameManager.COLS;
    private static final int CELL_SIZE = GameManager.CELL_SIZE;
    private static GameManager gameManager;
    private static Map board;
    private static Player player;
    private static Inventory playerInventory;

    private void initGame() {
        gameManager.setGraphicsContext(gc);
        board = gameManager.getBoard();
        player = gameManager.getPlayer();
        playerInventory = gameManager.getInventory();
    }

    private void movePlayerOnKeyPress() {
        scene.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(final KeyEvent event) {
                switch(event.getCode()) {
                    case RIGHT -> player.move(Direction.right, board.getBoard());
                    case LEFT -> player.move(Direction.left, board.getBoard());
                    case DOWN -> player.move(Direction.down, board.getBoard());
                    case UP -> player.move(Direction.up, board.getBoard());
                    case SPACE -> player.interact(board.getBoard());
                    case DIGIT1 -> player.changeHand(0);
                    case DIGIT2 -> player.changeHand(1);
                    case DIGIT3 -> player.changeHand(2);
                    case DIGIT4 -> player.changeHand(3);
                    case DIGIT5 -> player.changeHand(4);
                    case DIGIT6 -> player.changeHand(5);
                }

            }
        }));
    }

    private void run() {
        board.drawBoard();

        movePlayerOnKeyPress();

        player.drawCharacter();

        // Tool box
        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(0, COLS * CELL_SIZE, ROWS * CELL_SIZE, CELL_SIZE);

        playerInventory.checkItem();

        for (int i = 0; i < Inventory.MAX_CAPACITY; i++) {
            final int x = i * CELL_SIZE + TOOLBOX_OFFSET;
            final int y = COLS * CELL_SIZE + TOOLBOX_OFFSET;
            final Item item = playerInventory.getItem(i);

            // draw outline
            gc.setFill(Color.DARKGOLDENROD);
            if (item != null && item == player.getHand()) {
                gc.setFill(Color.CRIMSON);
            }
            gc.fillRoundRect(x, y, CELL_SIZE - TOOLBOX_OFFSET,
                    CELL_SIZE - TOOLBOX_OFFSET, ARC, ARC);

            gc.setFill(Color.MOCCASIN);
            gc.fillRoundRect(x + TOOLBOX_OFFSET, y + TOOLBOX_OFFSET,
                    CELL_SIZE - TOOLBOX_OFFSET * TOOLBOX_OFFSET,
                    CELL_SIZE - TOOLBOX_OFFSET * TOOLBOX_OFFSET, ARC, ARC);

            if (item != null) {
                item.drawItem(gc, x + ITEM_OFFSET / 2, y + ITEM_OFFSET / 2, CELL_SIZE - ITEM_OFFSET);
                if (item.getQuantity() > 1) {
                    gc.setFill(Color.BLACK);
                    gc.fillText(String.valueOf(item.getQuantity()),
                            x + TOOLBOX_OFFSET, y + ITEM_OFFSET, TEXT_SIZE);
                }
            }
        }
        gc.setFill(Color.BLACK);
        gc.fillText(player.getMoney(), 25, 25, 100000);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        VBox layout = new VBox();
        Canvas canvas = new Canvas(ROWS * CELL_SIZE, COLS * CELL_SIZE + CELL_SIZE);
        gc = canvas.getGraphicsContext2D();
        layout.getChildren().add(canvas);

        gameManager = GameManager.getGameManager();
        initGame();

        // Main game loop: Invokes run() every frame
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> run()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Load Scene
        scene = new Scene(layout, ROWS * CELL_SIZE, COLS * CELL_SIZE + CELL_SIZE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}
