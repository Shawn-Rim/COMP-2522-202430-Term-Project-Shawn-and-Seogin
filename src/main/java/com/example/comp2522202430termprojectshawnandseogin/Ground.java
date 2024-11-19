package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

public final class Ground extends Tile {
    private static final Image TOP_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/top.png")));
    private static final Image BOTTOM_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/bottom.png")));
    private static final Image LEFT_IMAGE =new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/leftMiddle.png")));
    private static final Image RIGHT_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/rightMiddle.png")));
    private static final Image LEFT_TOP_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/leftTop.png")));
    private static final Image LEFT_BOTTOM_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/leftBottom.png")));
    private static final Image RIGHT_TOP_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/rightTop.png")));
    private static final Image RIGHT_BOTTOM_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/rightBottom.png")));
    private static final Image MIDDLE_IMAGE = new Image(Objects.requireNonNull(Ground.class.getResourceAsStream("/Ground/middle.png")));

    private GroundDirection dir;

    public Ground(final int xCoordinate, final int yCoordinate, final int cellSize) {
        this(xCoordinate, yCoordinate, cellSize, GroundDirection.middle);
    }

    public Ground(final int xCoordinate, final int yCoordinate, final int cellSize, final GroundDirection dir) {
        super(xCoordinate, yCoordinate, cellSize);
        this.dir = dir;
    }

    @Override
    public void drawTile(final GraphicsContext gc) {
        Image image = null;

        switch(this.dir) {
            case top -> image = TOP_IMAGE;
            case bottom -> image = BOTTOM_IMAGE;
            case left -> image = LEFT_IMAGE;
            case right -> image = RIGHT_IMAGE;
            case leftTop -> image = LEFT_TOP_IMAGE;
            case leftBottom -> image = LEFT_BOTTOM_IMAGE;
            case rightTop -> image = RIGHT_TOP_IMAGE;
            case rightBottom -> image = RIGHT_BOTTOM_IMAGE;
            case middle -> image = MIDDLE_IMAGE;
        }

        Water.drawWater(gc, this.xCoordinate, this.yCoordinate, this.cellSize);
        gc.drawImage(image, this.xCoordinate * this.cellSize, this.yCoordinate * this.cellSize, this.cellSize, this.cellSize);
        super.drawTile(gc);
    }
}
