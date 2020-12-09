package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;

public class JailTileActionStrategy extends ActionStrategy {
    /**
     * This strategy is related to getting the player out of jail when he waits for three turns.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        player.waitInJail();
    }

    /**
     * This strategy is related to getting the player out of jail when the player pays the fee.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {
         player.payBailOutMoney();
    }

    /**
     * This strategy is related to getting the player out of jail when the player throws double dice in three tries.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {
        player.throwDoubleDice();
    }

    /**
     * This strategy is related to getting the player out of jail when the player uses a get out of jail card.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button4Strategy(Player player) {
        player.useBailOutOfJailCard();
    }
}
