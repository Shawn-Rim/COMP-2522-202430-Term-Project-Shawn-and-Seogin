package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class NPC extends Decorator {
    private static final Image NPC = new Image(Objects.requireNonNull(
            NPC.class.getResourceAsStream("/NPC/NPC.png")));
    private static final Image GROUND = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/Ground/middle.png")));

    private boolean visited;

    public NPC() {
        super();

        this.visited = false;
    }

    public String talk() {
        return "Hello!";
    }

    public void visit() {
        this.visited = true;
    }

    @Override
    public void interact(final Item item) {
        if (item instanceof Crop) {
            Main.player.addMoney(((Crop) item).sellPrice);
            Main.player.getInventory().removeItem(item);
        } else {
            Main.player.subtractMoney(EggplantSeed.BUY_PRICE);
            Main.player.getInventory().addItem(new EggplantSeed());
        }
    }

    @Override
    public void drawDecorator(final GraphicsContext gc, final int x, final int y, final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        gc.drawImage(NPC, x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
