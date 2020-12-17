package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class IncomeTaxTile extends Tile {

    @Override
    public ArrayList<GameAction> hook(Player player) {
        if (player.getTaxOption() != -1) {
            setActive(actions, "TAX_OPTION1", true);
            setActive(actions, "TAX_OPTION2", true);
            setActive(actions, "PAY_TAX", false);
        } else {
            setActive(actions, "PAY_TAX", true);
            setActive(actions, "TAX_OPTION1", false);
            setActive(actions, "TAX_OPTION2", false);
        }
        return actions;
    }
}
