package model.player.strategy;

import model.player.AIPlayer;

/**
 * Strategy for the stingy AI.
 * For the most part, tries to avoid the danger of bankruptcy as much as possible.
 * Tries to avoid situations that it he would decrease his "liquid" assets,
 * and does try too much to buy properties.
 */
public class StingyAIStrategy extends AIStrategy {

    /**
     *  Is invoked when the player lands on a PropertyTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing stingy.
     *  If the subject player has excess money, buys the property.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecutePropertyDecision( AIPlayer player){

    }

    /**
     *  Is invoked when the player is made a trade offer.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing stingy.
     *  Accepts trade offers only if it is heavily in favor of the subject.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecuteTradeDecision( AIPlayer player){

    }

    /**
     *  Is invoked when the player is involved in an auction.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing stingy.
     *  Stingy AI in general prefers to not bid in auctions, unless it is extermely profitable.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecuteAuctionDecision( AIPlayer player){

    }

    /**
     *  Is invoked when the player lands on an IncomeTaxTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is avoiding bankruptcy, so stingy AI always chooses percentage tax,
     *  because he cannot go bankrupt paying percentage tax.
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

}
