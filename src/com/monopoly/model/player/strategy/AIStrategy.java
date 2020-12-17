package com.monopoly.model.player.strategy;

import com.monopoly.model.player.AIPlayer;

public abstract class AIStrategy {
        GameStatistics gameStatistics;
        public abstract void makeAndExecutePropertyDecision( AIPlayer player);
        public abstract void makeAndExecuteTradeDecision( AIPlayer player);
        public abstract void makeAndExecuteAuctionDecision( AIPlayer player);
        public abstract void makeAndExecuteIncomeTaxDecision(AIPlayer aiPlayer);
}
