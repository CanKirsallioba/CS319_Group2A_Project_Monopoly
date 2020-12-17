package com.monopoly.model.player;

import com.monopoly.model.player.strategy.AIStrategy;

public class AIPlayer extends AbstractPlayer {
    AIStrategy aiStrategy;

    public AIPlayer(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }

    void makeAndExecutePropertyDecision(){
        aiStrategy.makeAndExecutePropertyDecision( this);
    }

    void makeAndExecuteTradeDecision(){
        aiStrategy.makeAndExecuteTradeDecision( this);
    }

    void makeAndExecuteAuctionDecision(){
        aiStrategy.makeAndExecuteAuctionDecision( this);
    }



    @Override
    public void playTurn(){

        // roll dice
        // maybe jail
        // move player

        // arrived at a tile
        // get possible actions

        // decision making


        // decision taken

    }



}
