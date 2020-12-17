package com.monopoly.model.player;

import com.monopoly.model.player.strategy.AIStrategy;

public class AIPlayer extends AbstractPlayer {
    AIStrategy aiStrategy;

    public AIPlayer(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }



    @Override
    public void playTurn(){
        AIDecision a;

        // roll dice
        // maybe jail
        // move player

        // arrived at a tile
        // get possible actions

        // decision making
        a =     BUY_PROPERTY;


        // decision taken
        if( a == BUY_PROPERTY){
             ArrayList<GameAction> x = currentTile.getPossibleActions(this);

        }

    }



}
