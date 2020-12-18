package com.monopoly.model.session;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.board.Board;
import com.monopoly.model.board.BoardFactory;
import com.monopoly.model.player.Player;
import com.monopoly.model.player.PlayerFactory;
import com.monopoly.model.player.PlayerToken;
import org.json.simple.JSONObject;

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

        int tokenNumber = 0;
        for (Player player : turnManager.getPlayers()) {
            player.setPlayerToken(new PlayerToken("TOKEN" + tokenNumber, board));
            tokenNumber++;
        }

        GameSession gameSession = new GameSession();
        gameSession.setBoard(board);
        gameSession.setTurnManager(turnManager);

        return gameSession;
    }
}
