package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.image.Image;

import java.util.Objects;

public final class Ground extends Tile {
    private static final Image MIDDLE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/middle.png")));
    private static final Image BOTTOM = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/bottom.png")));
    private static final Image TOP = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/top.png")));



    public static Image getMiddle() {
        return MIDDLE;
    }
    public static Image getBottom() {
        return BOTTOM;
    }
    public static Image getTop() {
        return TOP;
    }
    public Ground(final int xCoordinate, final int yCoordinate) {
        super(xCoordinate, yCoordinate);
    }
}
