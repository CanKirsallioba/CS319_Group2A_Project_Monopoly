package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;

public class IncomeTaxTileActionStrategy extends ActionStrategy {
    @Override
    public void button1Strategy(Player player) { // pay tax
        player.getTaxOption();
    }

    @Override
    public void button2Strategy(Player player) {

    }

    @Override
    public void button3Strategy(Player player) {

    }

    @Override
    public void button4Strategy(Player player) {

    }
}
