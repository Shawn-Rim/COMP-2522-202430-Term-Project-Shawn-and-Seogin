package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.image.Image;

import java.util.Objects;

public final class Water extends Tile implements BlockTile{
    private static final Image WATER = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Water/Water1.png")));

    public Water(final int xCoordinate, final int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }

    public static Image getWater() {
        return WATER;
    }
}
