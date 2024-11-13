package com.example.comp2522202430termprojectshawnandseogin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class Main extends Application {
    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int CELLSIZE = 50;
    public static Map board;
    public static Player player;
    public static GraphicsContext gc;


    public static void initGame() {
        board = new Map(ROWS, COLS, CELLSIZE, gc);
        board.makeBoard();

        player = new Player("Player 1", gc, 0, 0);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        VBox layout = new VBox();
        Canvas canvas = new Canvas(ROWS * CELLSIZE, COLS * CELLSIZE);
        gc = canvas.getGraphicsContext2D();
        layout.getChildren().add(canvas);

        initGame();
        board.drawBoard();

        player.move(Direction.right);
        player.move(Direction.right);
        player.move(Direction.right);
        player.move(Direction.down);
        player.move(Direction.down);
        player.move(Direction.down);

        player.drawCharacter();

        Scene scene = new Scene(layout, ROWS * CELLSIZE, COLS * CELLSIZE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
