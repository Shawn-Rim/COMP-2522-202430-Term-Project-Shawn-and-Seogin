package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Map implements Serializable {
    private final int rows;
    private final int cols;
    private final int cellSize;
    private final List<Tile> board;

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

    public List<Tile> getBoard() {
        return Collections.unmodifiableList(this.board);
    }

    public void makeBoard() {
        // TODO: Implement actual board later. This is for testing purpose.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    this.board.add(new Water(i, j, this.cellSize));
                } else if (i == 3 && j == 3) {
                    Water water = new Water(i, j, this.cellSize);
                    water.setDecorator(new WaterWell());
                    this.board.add(water);
                } else if (i > 4 && i <= 7 && j > 1 && j <= 3) {
                    Water water = new Water(i, j, this.cellSize);

                    if (i == 7 && j == 3) {
                        water.setDecorator(new House(true));
                    } else  {
                        water.setDecorator(new House(false));
                    }

                    this.board.add(water);
                } else if (i ==7 && j == 7) {
                    Water water = new Water(i, j, cellSize);
                    water.setDecorator(new NPC());
                    this.board.add(water);
                } else if (j == 4 && i != 1 && i != rows - 2) {
                    this.board.add(new Soil(i, j, this.cellSize));
                } else if (i == 1 && j == 1) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.leftTop));
                } else if (i == rows-2 && j == 1) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.rightTop));
                } else if (i == 1 && j == cols - 2) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.leftBottom));
                } else if (i == rows-2 && j == cols - 2) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.rightBottom));
                } else if (j == 1) {
                    this.board.add(new Ground(i, j , this.cellSize, GroundDirection.top));
                } else if (i == 1) {
                    this.board.add(new Ground(i, j , this.cellSize, GroundDirection.left));
                } else if (i == rows-2) {
                    this.board.add(new Ground(i, j , this.cellSize, GroundDirection.right));
                } else if (j == cols-2) {
                    this.board.add(new Ground(i, j , this.cellSize, GroundDirection.bottom));
                } else {
                    this.board.add(new Ground(i, j, this.cellSize));
                }
            }
        }
    }

    public void drawBoard() {
        GraphicsContext gc = GameManager.getGameManager().getGraphicsContext();
        // Draw each tile
        for (Tile tile : this.board) {
            tile.drawTile(gc);
        }
    }
}
