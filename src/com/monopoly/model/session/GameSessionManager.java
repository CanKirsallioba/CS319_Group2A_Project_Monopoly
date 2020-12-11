package com.monopoly.model.session;

import com.monopoly.model.BoardConfiguration;

import java.nio.file.Path;
import java.util.ArrayList;

public class GameSessionManager {
    private GameSession game;
    private Path fileLocation;
    private String fileName;

    public GameSessionManager(GameSession game, Path fileLocation, String fileName) {
        this.game = game;
        this.fileLocation = fileLocation;
        this.fileName = fileName;
    }

    private String selectedGameSessionName;

    public GameSession getGame() {
        return game;
    }

    public void setGame(GameSession game) {
        this.game = game;
    }

    public Path getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(Path fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    void loadGame() {

    }

    void saveGame(GameSession gameSession) {

    }

    public String getSelectedGameSessionName() {
        return selectedGameSessionName;
    }

    public void setSelectedGameSessionName(String selectedGameSessionName) {
        this.selectedGameSessionName = selectedGameSessionName;
    }

    ArrayList<String> getSavedGameSession() {
        return null;
    }

    void newGame(BoardConfiguration config) {

    }
}