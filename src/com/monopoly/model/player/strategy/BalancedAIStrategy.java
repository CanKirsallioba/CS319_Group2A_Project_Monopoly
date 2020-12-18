package com.monopoly.model.player.strategy;

import com.monopoly.model.player.AIPlayer;
import com.monopoly.model.player.TaxOption;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.property.TitleDeedCard;

public class BalancedAIStrategy extends AIStrategy {

    @Override
    public void makeAndExecutePropertyDecision( AIPlayer player){
        PropertyTile currentPropertyTile = (PropertyTile) player.getCurrentTile();

        // decision path for owned property
        if(currentPropertyTile.getTitleDeedCard().isOwned()){

            // if the player cannot pay the rent even if he/she sold everything of value, declare bankruptcy
            if( player.getLiquidTotalWorth() < currentPropertyTile.getTitleDeedCard().getCurrentRent()){
                player.declareBankruptcy();
            }
            // if player can pay the rent, pay the rent
            else{

                // if player does not have the balance to pay rent &&
                // but liquid total worth > rent
                // mortgage & downgrade to pay rent
                if( player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent() && player.getLiquidTotalWorth() >= currentPropertyTile.getTitleDeedCard().getCurrentRent()){
                    for(TitleDeedCard titleDeedCard: player.getTitleDeeds()){
                        if( titleDeedCard.getUpgradeLevel() >= 1 && titleDeedCard.isDowngradeable() && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent() ){
                            getGameAction( titleDeedCard.getPossibleActions(), "Downgrade").execute();
                        }
                    }
                    if( player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()){
                        for( TitleDeedCard titleDeedCard: player.getTitleDeeds() ){
                            if( titleDeedCard.isMortgaged() == false && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent() ){
                                getGameAction( titleDeedCard.getPossibleActions(), "Mortgage").execute();
                            }
                        }
                    }
                }
                // if after selling everything player cannot pay, declare bankruptcy
                // which should have not happened in this decision path
                if( player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()){
                    System.out.println( "Error: Liquid total worth calculations wrong.");
                    player.declareBankruptcy();
                    return;
                }

                // pay the rent
                getGameAction( currentPropertyTile.getTitleDeedCard().getPossibleActions(), "Pay Rent").execute();
            }
        }
        // decision path for unowned property
        else {
            // if player has more than twice the money required to buy the property
            if( player.getBalance() >= 2 * currentPropertyTile.getTitleDeedCard().getPropertyValue() ){

                // if the player can pay the maximum rent even after buying this property, buy it
                if( player.getBalance() - gameStatistics.getMaximumRent() < 0){
                    getGameAction( currentPropertyTile.getTitleDeedCard().getPossibleActions(), "Buy Property").execute();
                }
            }
            // if does not fit the criteria do not buy
            else{
                getGameAction( currentPropertyTile.getTitleDeedCard().getPossibleActions(), "Dont Buy Property").execute();
            }
        }
    }

    @Override
    public void makeAndExecuteTradeDecision( AIPlayer player){

    }

    @Override
    public void makeAndExecuteAuctionDecision( AIPlayer player){

    }

    @Override
    public void makeAndExecuteIncomeTaxDecision(AIPlayer aiPlayer){
        if( aiPlayer.getTaxOption() == null){
            aiPlayer.setTaxOption( TaxOption.TAX_WITH_RATIO);
        }

        // pay the tax
        //TODO
        aiPlayer.setBalance( (int) (aiPlayer.getBalance() * (1 - 0.2)) );
    }

    @Override
    public void makeAndExecuteCardDecision(AIPlayer aiPlayer){

    }
}
