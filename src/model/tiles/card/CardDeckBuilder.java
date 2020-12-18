package model.tiles.card;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class CardDeckBuilder {
    public CardDeck build(JSONObject config) {
        String associatedDeck = (String) config.get("associatedDeck");
        AbstractCardFactory cardFactory = new CardFactory();
        Card createdCard;
        CardDeck cardDeck;
        ArrayList<Card> cardArrayList = new ArrayList<>();
        JSONArray cards = (JSONArray) (config.get(associatedDeck));
        for (Object card : cards) {
            JSONObject c = (JSONObject) ((JSONObject) card).get("card");
            createdCard = cardFactory.createCard(c);
//                createdCard.setType(associatedDeck);
            // todo card typelar
            createdCard.setType(associatedDeck);
            cardArrayList.add(createdCard);
        }
        if (associatedDeck.equals("ChanceCardDeck")) {
            cardDeck = new ChanceCardDeck(cardArrayList);

        } else if (associatedDeck.equals("CommunityChestCardDeck")) {
            cardDeck = new CommunityChestCardDeck(cardArrayList);
        } else {
            throw new RuntimeException("Wrong Card Deck type!");
        }

        return cardDeck;
    }

}
