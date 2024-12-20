package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents a House decorator in the game.
 *
 * @author Seogin Hong, Shawn Rim
 * @version 2024
 */
public final class House extends Decorator {
    private static final Image HOUSE = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/House/House.png")));
    private static final Image GROUND = new Image(Objects.requireNonNull(
            House.class.getResourceAsStream("/Ground/middle.png")));
    private static final int OFFSET = 3;

    private final boolean showHouse;

    /**
     * Creates an instance of House.
     *
     * @param showHouse a boolean
     */
    public House(final boolean showHouse) {
        super();

        this.showHouse = showHouse;
    }

    @Override
    public void drawDecorator(final GraphicsContext gc,
                              final int x, final int y, final int cellSize) {
        gc.drawImage(GROUND, x * cellSize, y * cellSize, cellSize, cellSize);
        if (showHouse) {
            gc.drawImage(
                    HOUSE,
                    x * cellSize - cellSize * 2,
                    y * cellSize - cellSize * 2,
                    cellSize * OFFSET,
                    cellSize * OFFSET
            );
        }
    }

    @Override
    public void interact(final Item item) {
        GameManager gameManager = GameManager.getGameManager();
        gameManager.getPlayer().subtractMoney(new BigInteger("200"));
        gameManager.getBoard().growPlants();
        gameManager.saveGame();
    }

    @Override
    public String toString() {
        return "House{" + "showHouse=" + this.showHouse + '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        House house = (House) object;

        return this.showHouse == house.showHouse;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.showHouse);
    }
}
