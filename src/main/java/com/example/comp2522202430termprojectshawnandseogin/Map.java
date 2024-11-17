package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public List<Tile> getBoard() {
        return Collections.unmodifiableList(this.board);
    }

    public void makeBoard() {
        // TODO: Implement actual board later. This is for testing purpose.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    this.board.add(new Water(i, j, this.cellSize));
                } else if (j == 4 && i != 1 && i != rows - 2) {
                    this.board.add(new Soil(i, j, this.cellSize));
                } else {
                    this.board.add(new Ground(i, j, this.cellSize));
                }
            }
        }
    }

    public void drawBoard() {

        // Draw each tile
        for (Tile tile : this.board) {
            tile.drawTile(this.graphicsContext);
        }
    }
}
