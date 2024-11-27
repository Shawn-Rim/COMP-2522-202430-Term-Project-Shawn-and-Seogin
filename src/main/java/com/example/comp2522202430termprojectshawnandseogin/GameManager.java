package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.*;
import java.util.Objects;


public final class GameManager implements Serializable {
    /**
     * Stores the number of rows in a map.
     */
    public static final int ROWS = 10;
    /**
     * Stores the number of columns in a map.
     */
    public static final int COLS = 10;
    /**
     * Stores the cell size of a map.
     */
    public static final int CELL_SIZE = 50;
    private static final String FILENAME = "SaveData.ser";
    private static final int STARTING_X = 3;
    private static final int STARTING_Y = 3;
    private static GameManager gameManager;

    private transient GraphicsContext graphicsContext;
    private final Map board;
    private final Player player;
    private final Inventory inventory;

    private GameManager() {
        this.board = new Map(ROWS, COLS, CELL_SIZE);
        this.player = new Player(STARTING_X, STARTING_Y, CELL_SIZE);
        this.inventory = player.getInventory();

        this.board.makeBoard();
    }

    @Serial
    private void readObject(final ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        setGraphicsContext(null);
    }

    /**
     * Returns the GameManager object.
     *
     * @return gameManager as GameManager
     */
    public static GameManager getGameManager() {
        if (gameManager == null) {
            try (FileInputStream fileIn = new FileInputStream(FILENAME);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                gameManager = (GameManager) in.readObject();
            } catch (FileNotFoundException e) {
                gameManager = new GameManager();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return gameManager;
    }

    /**
     * Returns the map of this game manager.
     *
     * @return board as Map
     */
    public Map getBoard() {
        return this.board;
    }

    /**
     * Returns the player of this game manager.
     *
     * @return player as Player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the inventory of this game manager.
     *
     * @return inventory as Inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Returns the graphics context of this game manager.
     *
     * @return graphicsContext as GraphicsContext
     */
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    /**
     * Sets the graphics context of this game manager as the given graphicsContext.
     *
     * @param graphicsContext a GraphicsContext
     */
    public void setGraphicsContext(final GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    /**
     * Writes this game manager object to the FILENAME.
     */
    public void saveGame() {
        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream outStream = new ObjectOutputStream(fileOut)) {
            outStream.writeObject(gameManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "GameManager{" +
                "graphicsContext=" + this.graphicsContext +
                ", board=" + this.board +
                ", player=" + this.player +
                ", inventory=" + this.inventory +
                '}';
    }

    @Override
    public boolean equals(final Object object) {
        // There can only be one instance of GameManager
        return this == object;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.graphicsContext, this.board, this.player, this.inventory);
    }
}
