package model.player.strategy;

import model.player.AIPlayer;
import model.player.TaxOption;
import model.tiles.IncomeTaxTile;
import model.tiles.PropertyTile;
import model.tiles.card.Card;
import model.tiles.property.TitleDeedCard;
import model.tiles.GameAction;

import java.util.ArrayList;

public class BalancedAIStrategy extends AIStrategy {

    @Override
    public void makeAndExecutePropertyDecision(AIPlayer player) {
        PropertyTile currentPropertyTile = (PropertyTile) player.getCurrentTile();

        // decision path for owned property
        if (currentPropertyTile.getTitleDeedCard().isOwned()) {

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

                            getGameAction(titleDeedCard.getPossibleActions(), "Downgrade").execute();
                        }
                    }
                    if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                        for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {
                            if (titleDeedCard.isMortgaged() == false
                                    && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {

                                getGameAction(titleDeedCard.getPossibleActions(), "Mortgage").execute();
                            }
                        }
                    }
                }
                // if after selling everything player cannot pay, declare bankruptcy
                // which should have not happened in this decision path
                if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                    System.out.println("Error: Liquid total worth calculations wrong.");
                    player.declareBankruptcy();
                    return;
                }

                // pay the rent
                getGameAction(currentPropertyTile.getTitleDeedCard().getPossibleActions(), "Pay Rent").execute();
            }
        }
        // decision path for unowned property
        else {
            // if player has more than twice the money required to buy the property
            if (player.getBalance() >= 2 * currentPropertyTile.getTitleDeedCard().getPropertyValue()) {

                // if the player can pay the maximum rent even after buying this property, buy it
                if (player.getBalance() - gameStatistics.getMaximumRent() < 0) {
                    getGameAction(currentPropertyTile.getTitleDeedCard().getPossibleActions(), "Buy Property").execute();
                }
            }
            // if does not fit the criteria do not buy
            else {
                getGameAction(currentPropertyTile.getTitleDeedCard().getPossibleActions(), "Dont Buy Property").execute();
            }
        }
    }

    @Override
    public void makeAndExecuteTradeDecision(AIPlayer player) {

    }

    @Override
    public void makeAndExecuteAuctionDecision(AIPlayer player) {

    }

    @Override
    public void makeAndExecuteIncomeTaxDecision(AIPlayer aiPlayer) {
        if (aiPlayer.getTaxOption() == null) {
            aiPlayer.setTaxOption(TaxOption.TAX_WITH_RATIO);
        }

        // pay the tax
        getGameAction(((IncomeTaxTile) aiPlayer.getCurrentTile()).getPossibleActions(aiPlayer), "Pay Tax").execute();
    }

    @Override
    public void makeAndExecuteCardDecision(AIPlayer aiPlayer) {
        ArrayList<GameAction> gameActions = aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
        Card currentCard = aiPlayer.getCurrentlyDrawnCard();

        if( currentCard.getCardDetails().containsKey("PAY") ){
            int moneyToPay = currentCard.getCardDetails().get( "PAY");
            if( aiPlayer.getBalance() > moneyToPay){
                getGameAction(gameActions, "Apply").execute();
            }
            else if( aiPlayer.getLiquidTotalWorth() >= moneyToPay){

                while( aiPlayer.getBalance() < moneyToPay){ //

                    for (TitleDeedCard titleDeedCard : aiPlayer.getTitleDeeds()) {
                        if (titleDeedCard.getUpgradeLevel() >= 1 && titleDeedCard.isDowngradeable()
                                && aiPlayer.getBalance() < moneyToPay) {

                           getGameAction(titleDeedCard.getPossibleActions(), "Downgrade").execute();
                        }
                    }
                    if (aiPlayer.getBalance() < moneyToPay) {
                        for (TitleDeedCard titleDeedCard : aiPlayer.getTitleDeeds()) {
                            if (titleDeedCard.isMortgaged() == false
                                    && aiPlayer.getBalance() < moneyToPay) {

                             getGameAction(titleDeedCard.getPossibleActions(), "Mortgage").execute();
                            }
                        }
                    }
                }

                // now he has acquired the money
                getGameAction(gameActions, "Apply").execute();
            }
            else if( aiPlayer.getLiquidTotalWorth() < moneyToPay){
                aiPlayer.declareBankruptcy();
            }

        }
        else{
            getGameAction(gameActions, "Apply").execute();
        }
    }
}
