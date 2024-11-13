package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public final class Map {
    private final int rows;
    private final int cols;
    private final int cellSize;
    private final List<Tile> board;
    private final GraphicsContext graphicsContext;

    public Map(final int rows, final int cols, final int cellSize, final GraphicsContext gc) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows or columns must be a positive number.");
        } else if (cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be bigger than or equal to zero.");
        } else if (gc == null) {
            throw new IllegalArgumentException("GraphicsContext is null.");
        }

        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.board = new ArrayList<Tile>();
        this.graphicsContext = gc;
    }

    public void makeBoard() {
        // TODO: Implement actual board later. This is for testing purpose.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    this.board.add(new Water(i, j));
                } else if (j == 4 && i != 1 && i != rows - 2) {
                    this.board.add(new Soil(i, j));
                } else {
                    this.board.add(new Ground(i, j));
                }
            }
        }
    }

    public void drawBoard() {
        for (Tile tile : this.board) {
            Color color;

            if (tile instanceof Ground) {
                color = Color.GREEN;
            } else if (tile instanceof Water) {
                color = Color.BLUE;
            } else {
                color = Color.SANDYBROWN;
            }

            this.graphicsContext.setFill(color);
            this.graphicsContext.fillRect(
                    tile.getXCoordinate() * cellSize, tile.getYCoordinate() * cellSize, cellSize, cellSize);
        }
    }
}
