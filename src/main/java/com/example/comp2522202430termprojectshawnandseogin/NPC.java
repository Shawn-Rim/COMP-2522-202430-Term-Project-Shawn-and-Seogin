package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class NPC extends Decorator {
    private static final Image NPC = new Image(Objects.requireNonNull(
            NPC.class.getResourceAsStream("/NPC/NPC.png")));
    private static final Image GROUND = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/Ground/middle.png")));

    public NPC() {
        super();
    }

    public String talk() {
        return "Hello!";
    }

    @Override
    public void interact(final Item item) {
        GameManager gameManager = GameManager.getGameManager();

        if (item instanceof Crop) {
            gameManager.getPlayer().addMoney(((Crop) item).sellPrice);
            gameManager.getInventory().removeItem(item);
        } else {
            gameManager.getPlayer().subtractMoney(EggplantSeed.BUY_PRICE);
            gameManager.getInventory().addItem(new EggplantSeed());
        }
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        gc.drawImage(NPC, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
