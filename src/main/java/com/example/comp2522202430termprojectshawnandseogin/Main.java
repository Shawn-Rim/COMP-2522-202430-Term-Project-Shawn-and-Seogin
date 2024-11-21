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
    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int CELLSIZE = 50;
    public static final int TOOLBOX_OFFSET = 3;
    public static final int TEXT_SIZE = 5;
    public static final int ARC = 25;
    public static Map board;
    public static Player player;
    public static GraphicsContext gc;
    public static Scene scene;


    public static void initGame() {
        board = new Map(ROWS, COLS, CELLSIZE, gc);
        board.makeBoard();

        player = new Player(gc, 3, 3, CELLSIZE);

    }

    public void movePlayerOnKeyPress() {
        scene.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
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

    public void run() {
        board.drawBoard();

        movePlayerOnKeyPress();

        player.drawCharacter();

        // Tool box
        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(0, COLS * CELLSIZE, ROWS * CELLSIZE, CELLSIZE);

        final Inventory inventory = player.getInventory();

        for (int i = 0; i < Inventory.MAX_CAPACITY; i++) {
            final int x = (i + TOOLBOX_OFFSET) * CELLSIZE;
            final int y = COLS * CELLSIZE + TOOLBOX_OFFSET;
            final Item item = inventory.getItem(i);

            // draw outline
            gc.setFill(Color.BISQUE);
            if (item != null) {
                gc.setFill(Color.GOLD);
            }
            gc.fillRoundRect(x, y, CELLSIZE - TOOLBOX_OFFSET * 2,
                    CELLSIZE - TOOLBOX_OFFSET * 2, ARC, ARC);

            gc.setFill(Color.MOCCASIN);
            gc.fillRoundRect(x, y, CELLSIZE - TOOLBOX_OFFSET * TOOLBOX_OFFSET,
                    CELLSIZE - TOOLBOX_OFFSET * TOOLBOX_OFFSET, ARC, ARC);
            if (item != null) {
                item.drawItem(gc, x, y, CELLSIZE);
                if (item.getQuantity() > 1) {
                    gc.setFill(Color.WHITE);
                    gc.fillText(String.valueOf(item.getQuantity()),
                            x + CELLSIZE, y + CELLSIZE, TEXT_SIZE);
                }
            }
        }
    }

    @Override
    public void start(final Stage stage) throws Exception {
        VBox layout = new VBox();
        Canvas canvas = new Canvas(ROWS * CELLSIZE, COLS * CELLSIZE + CELLSIZE);
        gc = canvas.getGraphicsContext2D();
        layout.getChildren().add(canvas);

        initGame();

        // Main game loop: Invokes run() every frame
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> run()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Load Scene
        scene = new Scene(layout, ROWS * CELLSIZE, COLS * CELLSIZE + CELLSIZE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}
