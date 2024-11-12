package com.example.comp2522202430termprojectshawnandseogin;

import java.util.ArrayList;
import java.util.List;

public final class Map {
    private int rows;
    private int cols;
    private int cellSize;
    private List<Tile> board;

    public Map(final int rows, final int cols, final int cellSize) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows or columns must be a positive number.");
        } else if (cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be bigger than or equal to zero.");
        }

        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.board = new ArrayList<Tile>();
    }

    public void makeBoard() {}
}
