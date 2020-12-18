package model.tiles.card;


import java.io.Serializable;
import java.util.HashMap;

public class Card implements Serializable {
    String instruction;
    HashMap<String, Integer> cardDetails;

    String type;

    public Card(String instruction, String type, HashMap<String, Integer> cardDetails) {
        this.instruction = instruction;
        this.type = type;
        this.cardDetails = cardDetails;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Integer> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(HashMap<String, Integer> cardDetails) {
        this.cardDetails = cardDetails;
    }
}
