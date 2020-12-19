package model.session;

import model.BoardConfiguration;
import model.board.Board;
import model.board.BoardFactory;
import model.player.*;
import model.player.strategy.GameStatistics;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameSessionBuilder {
    BoardConfiguration boardConfiguration;
    JSONObject config;

    GameSessionBuilder(BoardConfiguration boardConfiguration, JSONObject config) {
        this.boardConfiguration = boardConfiguration;
        this.config = config;
    }

    public BoardConfiguration getBoardConfiguration() {
        return boardConfiguration;
    }

    public void setBoardConfiguration(BoardConfiguration boardConfiguration) {
        this.boardConfiguration = boardConfiguration;
    }

    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }


    public GameSession build() {
        BoardFactory boardFactory = new BoardFactory();
        PlayerFactory playerFactory = new PlayerFactory();
// todo game pace eklenecek.
//        Board board = boardFactory.get(getBoardConfiguration(), (JSONObject) getConfig().get(boardConfiguration.getGamePace().name()));
        Board board = boardFactory.get(getBoardConfiguration(), getConfig());

        TurnManager turnManager = new TurnManager();
        turnManager.setPlayers(playerFactory.get(getBoardConfiguration(), getConfig()));
        Dice dice = new Dice();
        int tokenNumber = 0;
        for (Player player : turnManager.getPlayers()) {
            player.setPlayerToken(new PlayerToken("TOKEN" + tokenNumber, board));
            player.setPlayersDice(dice);
            tokenNumber++;
        }

        GameSession gameSession = new GameSession();
        String gameSessionName = "saveFile_" + new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        gameSession.setGameSessionName( gameSessionName);
        gameSession.setDice(dice);
        gameSession.setBoard(board);
        gameSession.setTurnManager(turnManager);

        // set the game statistics for AIPlayers
        GameStatistics gameStatistics = new GameStatistics( board, turnManager.players);
        for (Player player : turnManager.getPlayers()) {
            if( player instanceof AIPlayer){
                ((AIPlayer) player).getAiStrategy().setGameStatistics(gameStatistics);
            }
        }

        return gameSession;
    }
}
