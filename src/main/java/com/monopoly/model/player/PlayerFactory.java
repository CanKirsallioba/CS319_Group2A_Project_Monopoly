package com.monopoly.model.player;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.player.strategy.AIStrategy;
import com.monopoly.model.player.strategy.AdventurousAIStrategy;
import com.monopoly.model.player.strategy.BalancedAIStrategy;
import com.monopoly.model.player.strategy.StingyAIStrategy;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class PlayerFactory extends AbstractPlayerFactory {
    // todo
    public PlayerFactory() {

    }

    @Override
    public ArrayList<Player> get(BoardConfiguration boardConfiguration, JSONObject config) {
        ArrayList<Player> players = new ArrayList<>();
        int humanPlayerCount = boardConfiguration.getHumanPlayerCount();
        JSONObject boardConfig = (JSONObject) config.get("boardConfig");

        for (int i =0 ; i< humanPlayerCount; i++) {
            HumanPlayer player = new HumanPlayer();
            player.setBalance((Integer) boardConfig.get("salary"));
            players.add(player);
        }
        for (int i = humanPlayerCount; i < boardConfiguration.getMaxPlayerCount(); i++) {
            AIStrategy aiStrategy;
            if (AICharacteristic.STINGY == boardConfiguration.getAiCharacteristic()) {
                aiStrategy = new StingyAIStrategy();

            } else if (AICharacteristic.ADVENTUROUS == boardConfiguration.getAiCharacteristic()){
                aiStrategy = new AdventurousAIStrategy();
            } else if (AICharacteristic.BALANCED == boardConfiguration.getAiCharacteristic()){
                aiStrategy = new BalancedAIStrategy();
            } else {
                throw new RuntimeException("AIChracteristics are not updated.");
            }
            AIPlayer player = new AIPlayer(aiStrategy);
            player.setBalance((Integer) boardConfig.get("salary"));
            players.add(player);
        }

        return players;
    }

    @Override
    public Player createAIPLayer(int balance, AICharacteristic aiCharacteristic, String playerTokenType) {
        return null;
    }

    @Override
    public Player createHumanPLayer(int balance, String playerTokenType) {
        return null;
    }
}
