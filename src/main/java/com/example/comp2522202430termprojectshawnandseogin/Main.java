package com.example.comp2522202430termprojectshawnandseogin;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.security.cert.Certificate;

public final class Main extends Application {
    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int CELLSIZE = 50;
    public static Map board;
    public static Player player;
    public static GraphicsContext gc;
    public static Scene scene;


    public static void initGame() {
        board = new Map(ROWS, COLS, CELLSIZE, gc);
        board.makeBoard();

        player = new Player("Player", gc, 3, 3, CELLSIZE);
    }

    public void movePlayerOnKeyPress() {
        scene.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case RIGHT -> {
                        player.move(Direction.right, board.getBoard());
                    }
                    case LEFT -> {
                        player.move(Direction.left, board.getBoard());
                    }
                    case DOWN -> {
                        player.move(Direction.down, board.getBoard());
                    }
                    case UP -> {
                        player.move(Direction.up, board.getBoard());
                    }
                }

            }
        }));
    }

    public void run() {
        board.drawBoard();

        movePlayerOnKeyPress();

        player.drawCharacter();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        VBox layout = new VBox();
        Canvas canvas = new Canvas(ROWS * CELLSIZE, COLS * CELLSIZE);
        gc = canvas.getGraphicsContext2D();
        layout.getChildren().add(canvas);

        initGame();

        // Main game loop: Invokes run() every frame
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> run()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

        // Load Scene
        scene = new Scene(layout, ROWS * CELLSIZE, COLS * CELLSIZE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
