package com.monopoly.model.player.strategy;

import com.monopoly.model.player.AIPlayer;
import com.monopoly.model.tiles.PropertyTile;

public class BalancedAIStrategy extends AIStrategy {


    @Override
    public void makeAndExecutePropertyDecision( AIPlayer player){
        PropertyTile currentPropertyTile = (PropertyTile) player.getCurrentTile();

        if(currentPropertyTile.getTitleDeedCard().isOwned() == false){
            if( player.getBalance() < currentPropertyTile.getTitleDeedCard().get)


            // TODO EXECUTE PAY RENT
        }
        else {
            if( currentPropertyTile.getTitleDeedCard().get)

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
