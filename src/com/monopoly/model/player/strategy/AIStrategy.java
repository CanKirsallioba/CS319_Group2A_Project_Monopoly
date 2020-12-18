package com.monopoly.model.player.strategy;

import com.monopoly.model.player.AIPlayer;
import com.monopoly.model.tiles.GameAction;

import java.util.ArrayList;

public abstract class AIStrategy {
        GameStatistics gameStatistics;
        public abstract void makeAndExecutePropertyDecision( AIPlayer player);
        public abstract void makeAndExecuteTradeDecision( AIPlayer player);
        public abstract void makeAndExecuteAuctionDecision( AIPlayer player);
        public abstract void makeAndExecuteIncomeTaxDecision(AIPlayer aiPlayer);
        public GameAction getGameAction(ArrayList<GameAction> gameAction, String gameActionName){
                for(GameAction action: gameAction) {
                        if (action.getName().equals(gameActionName))
                                return action;
                }
                return null;
        }
}
