package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class IncomeTaxTile extends Tile {

    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions){
        if (player.getTaxOption() != null) {
            setActive(actions, "Tax Option 1", true);
            setActive(actions, "Tax Option 2", true);
            setActive(actions, "Pay Tax", false);
        } else {
            setActive(actions, "Pay Tax", true);
            setActive(actions, "Tax Option 1", false);
            setActive(actions, "Tax Option 2", false);
        }
        return actions;
    }
}
