package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * This class defines map using Tile for game.
 *
 * @author Shawn and Seogin
 * @version 2024
 */
public final class Map implements Serializable {
    private static final Random RANDOM = new Random();

    private final int rows;
    private final int cols;
    private final int cellSize;
    private final List<Tile> board;

    /**
     * Constructs an object of type map.
     *
     * @param rows number of tile in row as an int
     * @param cols number of tile in column as an int
     * @param cellSize size of tile as an int
     * @throws IllegalArgumentException when rows and cols are less than or equal to 0
     * @throws IllegalArgumentException when cellSize is less than 0
     */
    public Map(final int rows, final int cols, final int cellSize) throws IllegalArgumentException {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows or columns must be a positive number.");
        } else if (cellSize < 0) {
            throw new IllegalArgumentException("Cell size must be bigger than or equal to zero.");
        }

        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.board = new ArrayList<>();
    }

    /**
     * Returns unmodifiable List of Tile to serializable.
     *
     * @return List of Tile
     */
    public List<Tile> getBoard() {
        return Collections.unmodifiableList(this.board);
    }

    /**
     * Initializes board for game.
     */
    public void makeBoard() {
        final int two = 2;
        final int tree = 3;
        final int four = 4;
        final int seven = 7;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    this.board.add(new Water(i, j, this.cellSize));
                } else if (i == tree && j == tree) {
                    Water water = new Water(i, j, this.cellSize);

                    water.setDecorator(new WaterWell());

                    this.board.add(water);
                } else if (i > four && i <= seven && j > 1 && j <= tree) {
                    Water water = new Water(i, j, this.cellSize);

                    if (i == seven && j == tree) {
                        water.setDecorator(new House(true));
                    } else  {
                        water.setDecorator(new House(false));
                    }

                    this.board.add(water);
                } else if (i == seven && j == seven) {
                    Water water = new Water(i, j, cellSize);

                    water.setDecorator(new NPC());

                    this.board.add(water);
                } else if (j == four && i != 1 && i != rows - two) {
                    this.board.add(new Soil(i, j, this.cellSize));
                } else if (i == 1 && j == 1) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.leftTop));
                } else if (i == rows - two && j == 1) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.rightTop));
                } else if (i == 1 && j == cols - two) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.leftBottom));
                } else if (i == rows - two && j == cols - two) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.rightBottom));
                } else if (j == 1) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.top));
                } else if (i == 1) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.left));
                } else if (i == rows - two) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.right));
                } else if (j == cols - two) {
                    this.board.add(new Ground(i, j, this.cellSize, GroundDirection.bottom));
                } else {
                    Ground ground = new Ground(i, j, this.cellSize);

                    if (RANDOM.nextInt(two) == 0) {
                        ground.setDecorator(new Grass());
                    }

                    this.board.add(ground);
                }
            }
        }
    }

    /**
     * Draws board using GraphicsContext of GameManager.
     */
    public void drawBoard() {
        GraphicsContext gc = GameManager.getGameManager().getGraphicsContext();
        // Draw each tile
        for (Tile tile : this.board) {
            tile.drawTile(gc);
        }
    }

    /**
     * Changes status of plants based on the conditions.
     */
    public void growPlants() {
        for (Tile tile : this.board) {
            if (tile instanceof Soil soil) {
                if (soil.getIsWatered() && soil.getDecorator() instanceof Planted) {
                    ((Planted) soil.getDecorator()).growPlant();
                }

                soil.drySoil();
            }
        }
    }

    /**
     * Returns a String representation of this Map.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        return "Map{" + "rows=" + rows + ", cols=" + cols
                + ", cellSize=" + cellSize + ", board=" + board + '}';
    }

    /**
     * Compares this Map object with another object for equality.
     *
     * @param object of Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Map map = (Map) object;
        return rows == map.rows && cols == map.cols && cellSize == map.cellSize
                && Objects.equals(board, map.board);
    }

    /**
     * Returns the hash code value for this Map object.
     *
     * @return hashcode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, cellSize, board);
    }
}
