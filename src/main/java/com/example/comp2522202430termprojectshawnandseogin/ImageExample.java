package com.example.comp2522202430termprojectshawnandseogin;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Objects;

public class ImageExample extends Application {
    @Override
    public void start(Stage stage) {
        // Load image from the resources folder
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Users/seoginhong/IdeaProjects/COMP-2522-202430-Term-Project-Shawn-and-Seogin/src/main/resources/Player/Player_front/front1.png")));

        // Setting the image view
        ImageView imageView = new ImageView(image);

        // Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        // Setting the fit height and width of the image view
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        // Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        // Creating a Group object
        Group root = new Group(imageView);

        // Creating a scene object
        Scene scene = new Scene(root, 600, 500);

        // Setting title to the Stage
        stage.setTitle("Loading an image");

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
