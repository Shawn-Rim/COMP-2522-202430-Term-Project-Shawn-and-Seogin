package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Draws progress of crops based on growth rate and interact with player to harvest.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class Planted extends Decorator {
    private static final int IMAGE_SIZE = 4;
    private static final Image[] CARROTS = new Image[IMAGE_SIZE];
    private static final Image[] EGGPLANTS = new Image[IMAGE_SIZE];

    private double progress;
    private final Seed seed;
    private final Soil soil;

    static {
        for (int i = 1; i <= IMAGE_SIZE; i++) {
            CARROTS[i - 1] = new Image(Objects.requireNonNull(
                    Planted.class.getResourceAsStream("/FarmingPlants/carrot" + i + ".png")));
            EGGPLANTS[i - 1] = new Image(Objects.requireNonNull(
                    Planted.class.getResourceAsStream("/FarmingPlants/EggPlant" + i + ".png")));
        }
    }

    /**
     * Constructs an object Type of Planted.
     *
     * @param seed of Seed
     * @param soil of Soil
     */
    public Planted(final Seed seed, final Soil soil) {
        super();

        this.seed = seed;
        this.progress = 0.0;
        this.soil = soil;
    }

    /**
     * Draws crop based on the progress.
     *
     * @param gc of GraphicsContext
     * @param x of x coordinate
     * @param y of y coordinate
     * @param cellSize of int
     */
    @Override
    public void drawDecorator(final GraphicsContext gc,
                              final int x, final int y, final int cellSize) {
        int imageIndex = Math.min((int) Math.floor(this.progress * IMAGE_SIZE), IMAGE_SIZE - 1);
        Image[] images;

        switch (this.seed.getName()) {
            case "Carrot Seed" -> images = CARROTS;
            case "Eggplant Seed" -> images = EGGPLANTS;
            default -> images = CARROTS;
        }

        gc.drawImage(images[imageIndex], x * cellSize, y * cellSize, cellSize, cellSize);
    }

    /**
     * Adds growth rate to progress.
     */
    public void growPlant() {
        this.progress = Math.min(this.progress + this.seed.getGrowthRate(), 1);
    }

    /**
     * Harvests crops when player interact with any item.
     * @param item of Item
     */
    @Override
    public void interact(final Item item) {
        if (this.progress >= 1) {
            soil.setDecorator(null);
            GameManager.getGameManager().getInventory().addItem(new Eggplant());
        }
    }
}
