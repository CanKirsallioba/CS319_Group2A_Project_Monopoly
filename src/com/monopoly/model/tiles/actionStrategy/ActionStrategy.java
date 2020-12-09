package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;

public abstract class ActionStrategy {
    Player currentPlayer;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public abstract void button1Strategy(Player player);

    public abstract void button2Strategy(Player player);

    public abstract void button3Strategy(Player player);

    public abstract void button4Strategy(Player player);
}
