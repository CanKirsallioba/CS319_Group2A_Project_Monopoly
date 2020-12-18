package model.session;

import data.ConfigHandler;
import data.FileManager;
import data.SerializationHandler;
import model.BoardConfiguration;

import java.nio.file.Path;
import java.util.ArrayList;

public class GameSessionManager {
    private GameSession game;
    private Path fileLocation;
    private String fileName;
    private ArrayList<String> boardNames;
    private SerializationHandler serializationHandler;
    private ConfigHandler configHandler;
    private String selectedGameSessionName;



    void loadGame() {
        GameSession session = serializationHandler.load(getSelectedGameSessionName());
        setGame(session);
        setFileName(getSelectedGameSessionName());
    }

    void saveGame(GameSession gameSession) {
        serializationHandler.save(gameSession, getFileName());
    }


    public static ArrayList<String> getSavedGameSession() {
        return FileManager.getSavedSessionNames();
    }

    void newGame(BoardConfiguration config) {
        GameSessionBuilder gameSessionBuilder = new GameSessionBuilder(config, configHandler.getConfig(getFileName()));
        game = gameSessionBuilder.build();
    }
    public String getSelectedGameSessionName() {
        return selectedGameSessionName;
    }

    public void setSelectedGameSessionName(String selectedGameSessionName) {
        this.selectedGameSessionName = selectedGameSessionName;
    }
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



}