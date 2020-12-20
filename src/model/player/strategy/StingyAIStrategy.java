package model.player.strategy;

import model.player.AIPlayer;
import model.player.TaxOption;
import model.tiles.GameAction;
import model.tiles.PropertyTile;
import model.tiles.card.Card;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

import static model.tiles.GameActionConstants.*;
import static model.tiles.GameActionConstants.BUY_PROPERTY_ACTION;

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
        PropertyTile currentPropertyTile = (PropertyTile) player.getCurrentTile();

        // decision path for owned property
        if (currentPropertyTile.getTitleDeedCard().isOwned()){
            if ( currentPropertyTile.getTitleDeedCard().getOwner() != player ) {

                // if the player cannot pay the rent even if he/she sold everything of value, declare bankruptcy
                if (player.getLiquidTotalWorth() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {

                    player.declareBankruptcy();
                }
                // if player can pay the rent, pay the rent
                else {

                    // if player does not have the balance to pay rent &&
                    // but liquid total worth > rent
                    // mortgage & downgrade to pay rent
                    if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()
                            && player.getLiquidTotalWorth() >= currentPropertyTile.getTitleDeedCard().getCurrentRent()) {

                        for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {

                            if (titleDeedCard.getUpgradeLevel() >= 1 && titleDeedCard.isDowngradeable()
                                    && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {

                                player.setSelectedTitleDeed( titleDeedCard);
                                getGameAction(titleDeedCard.getPropertyActions(), DOWNGRADE_PROPERTY_ACTION).execute();
                                player.setSelectedTitleDeed(null);
                                currentPropertyTile.getPossibleActions(player);
                            }
                        }
                        if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                            for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {


                                if (titleDeedCard.isMortgaged () == false
                                        && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {

                                    player.setSelectedTitleDeed( titleDeedCard);
                                    getGameAction(titleDeedCard.getPropertyActions(), MORTGAGE_PROPERTY_ACTION).execute();
                                    player.setSelectedTitleDeed(null);
                                    currentPropertyTile.getPossibleActions(player);
                                    // player.setSelectedTitleDeed( currentPropertyTile.getTitleDeedCard());
                                }
                            }
                        }
                    }
                    // if after selling everything player cannot pay, declare bankruptcy
                    // which should have not happened in this decision path
                    if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                        player.declareBankruptcy();
                        return;
                    }

                    getGameAction(currentPropertyTile.getPossibleActions( player), PAY_RENT_ACTION).execute();

                }
            }
        }
        // decision path for unowned property
        else {
            boolean notBought = true;

            // if player has more than twice the money required to buy the property
            if (player.getBalance() >= 2.85 * currentPropertyTile.getTitleDeedCard().getPropertyValue()) {

                // if the player can pay the maximum rent and 2 average rents even after buying this property, buy it
                if (player.getBalance() - gameStatistics.getMaximumRent() > gameStatistics.calculateAverageRent() * 2) {
                    getGameAction(currentPropertyTile.getPossibleActions( player), BUY_PROPERTY_ACTION).execute();
                    notBought = false;
                }
            }
            // if does not fit the criteria do not buy
            if( notBought) {

                // do not buy
                // start auction
                ArrayList<TitleDeedCard> titleDeedOfCurrentProperty = new ArrayList<TitleDeedCard>();
                titleDeedOfCurrentProperty.add( currentPropertyTile.getTitleDeedCard());
                //  player.startAuction(titleDeedOfCurrentProperty );
            }
        }
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
        if (aiPlayer.getTaxOption() == null || aiPlayer.getTaxOption() == TaxOption.UNDETERMINED) {
            aiPlayer.setTaxOption(TaxOption.TAX_WITH_RATIO);
        }

        // pay the tax
        getGameAction(aiPlayer.getCurrentTile().getPossibleActions(aiPlayer), PAY_TAX_ACTION).execute();

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

        ArrayList<GameAction> gameActions = aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
        Card currentCard = aiPlayer.getCurrentlyDrawnCard();

        if( currentCard.getCardDetails().containsKey("PAY") ){
            int moneyToPay = currentCard.getCardDetails().get( "PAY");
            if( aiPlayer.getBalance() > moneyToPay){
                getGameAction(gameActions, APPLY_ACTION).execute();
            }
            else if( aiPlayer.getLiquidTotalWorth() >= moneyToPay){

                while( aiPlayer.getBalance() < moneyToPay){

                    for (TitleDeedCard titleDeedCard : aiPlayer.getTitleDeeds()) {
                        if (titleDeedCard.getUpgradeLevel() >= 1 && titleDeedCard.isDowngradeable()
                                && aiPlayer.getBalance() < moneyToPay) {

                            aiPlayer.setSelectedTitleDeed( titleDeedCard);
                            getGameAction(titleDeedCard.getPropertyActions(), DOWNGRADE_PROPERTY_ACTION).execute();
                            aiPlayer.setSelectedTitleDeed(null);
                            aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
                        }
                    }
                    if (aiPlayer.getBalance() < moneyToPay) {
                        for (TitleDeedCard titleDeedCard : aiPlayer.getTitleDeeds()) {

                            if (!titleDeedCard.isMortgaged ()
                                    && aiPlayer.getBalance() < moneyToPay) {

                                aiPlayer.setSelectedTitleDeed( titleDeedCard);
                                getGameAction(titleDeedCard.getPropertyActions(), MORTGAGE_PROPERTY_ACTION).execute();
                                aiPlayer.setSelectedTitleDeed(null);
                                aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
                                // player.setSelectedTitleDeed( currentPropertyTile.getTitleDeedCard());
                            }
                        }
                    }
                }

                // now he has acquired the money
                getGameAction(gameActions, APPLY_ACTION).execute();
            }
            else if( aiPlayer.getLiquidTotalWorth() < moneyToPay){
                aiPlayer.declareBankruptcy();
            }

        }
        else{
            getGameAction(gameActions, APPLY_ACTION).execute();
        }
    }

    /**
     * Is invoked at the end of each turn.
     * Lifts mortgages if they have any mortgaged properties, if they have enough and it is feasible for the AIPlayer
     * to do so.
     * @param player is the player subject to the decision
     */
    @Override
    public void liftMortgages(AIPlayer player){
        for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {

            if (titleDeedCard.isMortgaged () && player.getBalance() > 2.40 * titleDeedCard.mortgageRemovalPenalty() ){
                player.setSelectedTitleDeed( titleDeedCard);
                getGameAction(titleDeedCard.getPropertyActions(), REMOVE_MORTGAGE_ACTION).execute();
                player.setSelectedTitleDeed(null);
                player.getCurrentTile().getPossibleActions(player);
            }
        }
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
}
