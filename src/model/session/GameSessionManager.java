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

    /**
     * Constructor for the game session manager,
     * initializes configHandler, serializationHandler, boardNames.
     */
    public GameSessionManager() {
        configHandler = new ConfigHandler();
        serializationHandler = new SerializationHandler();
        boardNames = new ArrayList<>();
    }

    /**
     * This method loads the game by taking the gameSessionName as an attribute
     * @param gameSessionName is the name of the gameSession.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadGame( String gameSessionName) throws IOException, ClassNotFoundException {
        setSelectedGameSessionName( gameSessionName);
        GameSession session = serializationHandler.load(getSelectedGameSessionName());
        setGame(session);
        setConfigFileName(getSelectedGameSessionName());
    }

    /**
     * This method saves the game by taking the gameSession object as an argument.
     * @param gameSession is the current gameSession.
     * @throws IOException
     */
    public void saveGame(GameSession gameSession) throws IOException {
        String fileName = serializationHandler.save(gameSession);
        FileManager.addGameSaveFile( fileName);
    }


    /**
     * Getter method for the saved game session.
     * @return the saved game session.
     */
    public static ArrayList<String> getSavedGameSession() {
        return FileManager.getSavedSessionNames();
    }

    /**
     * This method creates a new game by taking the board config.
     * @param config is the config file that the new game will be initialized with.
     */
    public void newGame(BoardConfiguration config) {
        GameSessionBuilder gameSessionBuilder = new GameSessionBuilder(config, configHandler.getConfig(getConfigFileName()));
        game = gameSessionBuilder.build();
        setSelectedGameSessionName(game.getGameSessionName());
    }

    /**
     * Getter method for the selected game session name.
     * @return the selected game session name.
     */
    public String getSelectedGameSessionName() {
        return selectedGameSessionName;
    }

    /**
     * Setter method for the selected game session name.
     * @param selectedGameSessionName is the game session name to set to the class' selected game session name.
     */
    public void setSelectedGameSessionName(String selectedGameSessionName) {
        this.selectedGameSessionName = selectedGameSessionName;
    }

    /**
     * Getter method for the game.
     * @return the game session
     */
    public GameSession getGame() {
        return game;
    }

    /**
     * Setter method for the game session
     * @param game is the game session to set to the class' game session
     */
    public void setGame(GameSession game) {
        this.game = game;
    }

    /**
     * Getter method for the file location
     * @return the file location.
     */
    public Path getFileLocation() {
        return fileLocation;
    }

    /**
     * Setter method for the file location.
     * @param fileLocation is the file location to set to the class' file location.
     */
    public void setFileLocation(Path fileLocation) {
        this.fileLocation = fileLocation;
    }

    /**
     * Getter method for the config file name.
     * @return the config file name.
     */
    public String getConfigFileName() {
        return configFileName;
    }

    /**
     * Setter method for the config file name.
     * @param configFileName is the config file name to set to the class' config file name.
     */
    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }


}