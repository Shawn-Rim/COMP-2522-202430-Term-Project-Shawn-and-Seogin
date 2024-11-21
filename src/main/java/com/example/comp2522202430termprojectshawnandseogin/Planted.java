package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class Planted extends Decorator {
    private final static int IMAGE_SIZE = 4;
    private final static Image[] CARROTS = new Image[IMAGE_SIZE];
    private final static Image[] EGGPLANTS = new Image[IMAGE_SIZE];

    private final double progress;
    private final Seed seed;

    static {
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            CARROTS[i - 1] = new Image(Objects.requireNonNull(
                    Planted.class.getResourceAsStream("/FarmingPlants/carrot" + i + ".png")));
            EGGPLANTS[i - 1] = new Image(Objects.requireNonNull(
                    Planted.class.getResourceAsStream("/FarmingPlants/EggPlant" + i + ".png")));
        }
    }

    public Planted(final Seed seed) {
        super();

        this.seed = seed;
        this.progress = 0.0;
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        int imageIndex = (int) Math.floor(this.progress * IMAGE_SIZE);
        Image[] images;

        switch(this.seed.getName()) {
            case "Carrot Seed" -> images = CARROTS;
            case "Eggplant Seed" -> images = EGGPLANTS;
            default -> images = CARROTS;
        }

        gc.drawImage(images[imageIndex], x * cellSize, y * cellSize, cellSize, cellSize);

    }

    @Override
    public void interact(final Item item) {

    }
}
