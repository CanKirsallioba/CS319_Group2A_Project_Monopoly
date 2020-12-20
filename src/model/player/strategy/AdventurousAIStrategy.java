package model.player.strategy;

import model.player.AIPlayer;

/**
 * Strategy for the adventurous AI.
 * Tries to accumulate as much property as possible.
 * Tries to avoid situations that it would be in EXTREME DANGER of bankruptcy, otherwise
 * buys properties.
 * Wins big or loses big.
 */
public class AdventurousAIStrategy extends AIStrategy{

    /**
     *  Is invoked when the player lands on a PropertyTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing adventurous, so the AI player buys property if it is not in an immediate danger of bankruptcy.
     *  If it fits the AI's conditions it buys the property.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecutePropertyDecision( AIPlayer player){

    }

    /**
     *  Is invoked when the player is made a trade offer.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing adventurous, i.e. collecting many properties.
     *  If both players are giving the same amount and subject player is getting more properties,
     *  or the subject player is receiving significantly more in monetary value, the trade offer is accepted.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecuteTradeDecision( AIPlayer player){

    }

    /**
     *  Is invoked when the player is involved in an auction.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing adventurous,
     *  so the AI player tries to buy if it does not create extreme dagner of bankruptcy.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecuteAuctionDecision( AIPlayer player){

    }

    /**
     *  Is invoked when the player lands on an IncomeTaxTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Because AdventurousAI thinks he will earn much money, if he can, he chooses to pay fixed amount.
     * @param aiPlayer is the player subject to the decision
     */
    @Override
    public void makeAndExecuteIncomeTaxDecision(AIPlayer aiPlayer){

    }

    /**
     *  Is invoked when the player lands on a CardTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  If the drawn card involves paying money, and the player cannot afford it, player either sells property or
     *  downgrades property to pay, or declares bankruptcy.
     * @param aiPlayer is the player subject to the decision
     */
    @Override
    public void makeAndExecuteCardDecision(AIPlayer aiPlayer){

    }

    /**
     * Is invoked at the end of each turn.
     * Lifts mortgages if they have any mortgaged properties, if they have enough and it is feasible for the AIPlayer
     * to do so.
     * @param player is the player subject to the decision
     */
    @Override
    public void liftMortgages(AIPlayer player){

    }

}
