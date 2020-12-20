package model.player;

import model.BoardConfiguration;
import model.player.strategy.AIStrategy;
import model.player.strategy.AdventurousAIStrategy;
import model.player.strategy.BalancedAIStrategy;
import model.player.strategy.StingyAIStrategy;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Class implementing the abstract factory design pattern. It builds players.
 */
public class PlayerFactory extends AbstractPlayerFactory {
    /**
     * Default constructor.
     */
    // todo
    public PlayerFactory() {

    }

    /**
     * Creates an array of players and returns them.
     * Used for creating and initializing the Players used in the game.
     * @param boardConfiguration is the board configuration used for getting/holding values such as player count, etc. (User customised values)
     * @param config comes from the JSON file that holds the relevant data for other properties related to initialization of the Players.
     * @return the newly created players ArrayList.
     */
    @Override
    public ArrayList<Player> get(BoardConfiguration boardConfiguration, JSONObject config) {
        ArrayList<Player> players = new ArrayList<>();
        int humanPlayerCount = boardConfiguration.getHumanPlayerCount();
        JSONObject boardConfig = (JSONObject) config.get("boardConfig");

        for (int i =0 ; i< humanPlayerCount; i++) {
            HumanPlayer player = new HumanPlayer();
            player.setBalance(((Long) boardConfig.get("salary")).intValue());
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
            player.setBalance(((Long) boardConfig.get("salary")).intValue() * 2);
            players.add(player);
        }

        return players;
    }

}
