package com.monopoly.model.player.strategy;

import com.monopoly.model.player.AIPlayer;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.property.TitleDeedCard;

public class BalancedAIStrategy extends AIStrategy {


    @Override
    public void makeAndExecutePropertyDecision( AIPlayer player){
        PropertyTile currentPropertyTile = (PropertyTile) player.getCurrentTile();

        if(currentPropertyTile.getTitleDeedCard().isOwned()){
            if( player.getLiquidTotalWorth() < currentPropertyTile.getTitleDeedCard().getCurrentRent()){
                player.declareBankruptcy();
            }
            else{

                // if player does not have the balance to pay rent &&
                // but liquid total worth > rent
                // mortgage & downgrade to pay rent
                if( player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent() && player.getLiquidTotalWorth() >= player.getBalance()){
                    for(TitleDeedCard titleDeedCard: player.getTitleDeeds()){
                        if( titleDeedCard.getUpgradeLevel() > 1 && titleDeedCard.isDowngradeable() && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent() ){
                            titleDeedCard.downgrade();
                        }
                    }
                    if( player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()){
                        for( TitleDeedCard titleDeedCard: player.getTitleDeeds() ){
                            if( titleDeedCard.isMortgaged() == false && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent() ){
                                titleDeedCard.mortgage();
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

                // TODO EXECUTE PAY RENT
            }

        }
        else {
            // if player has more than twice the money required to buy the property
            if( player.getBalance() >= 2 * currentPropertyTile.getTitleDeedCard().getPropertyValue() ){

                // if the player can pay the maximum rent even after buying this property, buy it
                if( player.getBalance() - gameStatistics.getMaximumRent() < 0){

                    // TODO EXECUTE BUY PROPERTY
                }
            }
            // id does not fit the criteria do not buy
            else{
                // TODO EXECUTE DO NOT BUY - AUCTION
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

    }

}
