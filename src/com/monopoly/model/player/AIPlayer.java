package com.monopoly.model.player;

import com.monopoly.model.board.Dice;
import com.monopoly.model.player.strategy.AIStrategy;

public class AIPlayer extends AbstractPlayer {

    public AIPlayer(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }

    Player[] possiblePlayerStates;

    AIStrategy aiStrategy;
    @Override
    public Dice rollDice() {
        return null;
    }


}
