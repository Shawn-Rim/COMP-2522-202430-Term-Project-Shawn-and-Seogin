package com.example.comp2522202430termprojectshawnandseogin;

import javafx.scene.canvas.GraphicsContext;

import java.io.*;


public final class GameManager implements Serializable {
    public static final int ROWS = 10;
    public static final int COLS = 10;
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

    private void readObject(final ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        setGraphicsContext(null);
    }

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

    public Map getBoard() {
        return this.board;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public void setGraphicsContext(final GraphicsContext gc) {
        this.graphicsContext = gc;
    }

    public void saveGame() {
        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream outStream = new ObjectOutputStream(fileOut)) {
            outStream.writeObject(gameManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
