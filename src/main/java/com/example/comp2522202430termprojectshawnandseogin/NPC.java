package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * NPC extends Decorator to interact with player.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class NPC extends Decorator {
    private static final Image NPC = new Image(Objects.requireNonNull(
            NPC.class.getResourceAsStream("/NPC/NPC.png")));
    private static final Image GROUND = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/Ground/middle.png")));

    /**
     * Constructs an object of Type NPC.
     */
    public NPC() {
        super();
    }

    /**
     * Adds or subtracts money and item to player's inventory based on player's hand.
     *
     * @param item of Item
     */
    @Override
    public void interact(final Item item) {
        GameManager gameManager = GameManager.getGameManager();

        if (item instanceof Crop) {
            gameManager.getPlayer().addMoney(((Crop) item).getSellPrice());
            gameManager.getInventory().removeItem(item);
        } else {
            Tool eggplant = new EggplantSeed();
            gameManager.getPlayer().subtractMoney(eggplant.getBuyPrice());
            gameManager.getInventory().addItem(new EggplantSeed());
        }
    }

    /**
     * Draws NPC on the map.
     *
     * @param gc of GraphicsContext
     * @param x of x coordinate
     * @param y of y coordinate
     * @param cellSize of int
     */
    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y,
                              final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        gc.drawImage(NPC, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
