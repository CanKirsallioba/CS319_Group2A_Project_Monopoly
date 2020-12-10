package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class IncomeTaxTile extends Tile {

    @Override
    protected ArrayList<Action> hook(Player player) {
        if (player.getTaxOption() != -1) {
            setActive(actions, "TaxOption1", true);
            setActive(actions, "TaxOption2", true);
            setActive(actions, "Pay Tax", false);
        } else {
            setActive(actions, "Pay Tax", true);
            setActive(actions, "TaxOption1", false);
            setActive(actions, "TaxOption2", false);
        }
        return actions;
    }
}
