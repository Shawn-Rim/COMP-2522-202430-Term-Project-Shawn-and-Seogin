package com.example.comp2522202430termprojectshawnandseogin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class Main extends Application {
    public static final int rows = 10;
    public static final int cols = 10;
    public static final int cellSize = 50;

    @Override
    public void start(final Stage stage) throws Exception {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, rows * cellSize, cols * cellSize);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
