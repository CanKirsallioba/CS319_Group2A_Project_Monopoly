package model.tiles.card;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class CardFactory extends AbstractCardFactory {
    /**
     * Default constructor for the card factory
     */
    public CardFactory() {
    }

    /**
     * Overriden create card method
     * @param config is the JSON config object.
     * @return the card that is created.
     */
    @Override
    public Card createCard(JSONObject config) {
        String instruction = (String)config.get("instruction");
        String command = (String) config.get("command");
        int value = ((Long) config.get("parameter")).intValue();
        HashMap<String, Integer> cardDetails = new HashMap<String, Integer>();
        cardDetails.put(command, value);
        return new Card(instruction, "card type is not specified yet!", cardDetails);
    }
}
