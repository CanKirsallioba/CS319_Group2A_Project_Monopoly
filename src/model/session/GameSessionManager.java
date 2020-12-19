package model.session;

import data.ConfigHandler;
import data.FileManager;
import data.SerializationHandler;
import model.BoardConfiguration;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class GameSessionManager {
    private GameSession game;
    private Path fileLocation;
    private String configFileName;
    private ArrayList<String> boardNames;
    private SerializationHandler serializationHandler;
    private ConfigHandler configHandler;
    private String selectedGameSessionName;

    public GameSessionManager() {
        configHandler = new ConfigHandler();
        serializationHandler = new SerializationHandler();
        boardNames = new ArrayList<>();
    }


    public void loadGame( String gameSessionName) throws IOException, ClassNotFoundException {
        setSelectedGameSessionName( gameSessionName);
        GameSession session = serializationHandler.load(getSelectedGameSessionName());
        setGame(session);
        setConfigFileName(getSelectedGameSessionName());
    }

    public void saveGame(GameSession gameSession) throws IOException {
        String fileName = serializationHandler.save(gameSession);
        FileManager.addGameSaveFile( fileName);
    }


    public static ArrayList<String> getSavedGameSession() {
        return FileManager.getSavedSessionNames();
    }

    public void newGame(BoardConfiguration config) {
        GameSessionBuilder gameSessionBuilder = new GameSessionBuilder(config, configHandler.getConfig(getConfigFileName()));
        game = gameSessionBuilder.build();
        setSelectedGameSessionName(game.getGameSessionName());
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

    public String getConfigFileName() {
        return configFileName;
    }

    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }


}