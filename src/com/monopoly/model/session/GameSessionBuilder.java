package com.monopoly.model.session;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.board.Board;
import com.monopoly.model.board.BoardFactory;
import com.monopoly.model.player.Player;
import com.monopoly.model.player.PlayerFactory;
import com.monopoly.model.player.PlayerToken;
import org.json.simple.JSONObject;

import java.util.ArrayList;

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

        Board board = boardFactory.get(boardConfiguration, getConfig());

        TurnManager turnManager = new TurnManager();
        turnManager.setPlayers(playerFactory.get(boardConfiguration, getConfig()));
        ArrayList<String> tokenTypes = null;
        int tokenNumber = 0;
        for (Player player : turnManager.getPlayers()) {
            player.setPlayerToken(new PlayerToken(tokenTypes.get(tokenNumber), board));
            tokenNumber++;
        }

        GameSession gameSession = new GameSession();
        gameSession.setBoard(board);
        gameSession.setTurnManager(turnManager);

        return gameSession;
    }
}
