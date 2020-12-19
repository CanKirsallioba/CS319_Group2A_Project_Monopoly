package model.tiles.card;


import java.io.Serializable;
import java.util.HashMap;

public class Card implements Serializable {
    String instruction;
    HashMap<String, Integer> cardDetails;

    String type;

    /**
     * Constructor for Card class
     * @param instruction is the instruction of the card.
     * @param type is either chance card or community chest card.
     * @param cardDetails is a hash map that holds the string value of the action that the card will take and the int that holds the number of that action.
     */
    public Card(String instruction, String type, HashMap<String, Integer> cardDetails) {
        this.instruction = instruction;
        this.type = type;
        this.cardDetails = cardDetails;
    }

    /**
     * Getter method for the instruction attribute.
     * @return instruction.
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * Setter method for the instruction attribute.
     * @param instruction is the instruction of the card.
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * Getter method for the type attribute.
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for the type attribute.
     * @param type is either a chance card or community chest card
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter method for the card details.
     * @return card details.
     */
    public HashMap<String, Integer> getCardDetails() {
        return cardDetails;
    }

    /**
     * Setter function for the card details.
     * @param cardDetails is a hash map that holds the string value of the action that the card will take and the int that holds the number of that action.
     */
    public void setCardDetails(HashMap<String, Integer> cardDetails) {
        this.cardDetails = cardDetails;
    }
}
