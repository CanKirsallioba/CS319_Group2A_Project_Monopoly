package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;

public class IncomeTaxTileActionStrategy extends ActionStrategy {
    /**
     * This method allows the player to set the tax option to money-wise payment.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        // TODO implement payTax() method in Player class
        player.setTaxOption ( 0 );
    }

    /**
     * This method allows the player to set the tax option to percentage-wise payment.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {
        player.setTaxOption ( 1 );
    }

    /**
     * This method allows the player to pay the tax.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {

    }

    @Override
    public void button4Strategy(Player player) {

    }
}
