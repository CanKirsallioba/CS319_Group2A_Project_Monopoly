package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class JailTile extends Tile {

    @Override
    public ArrayList<GameAction> hook(Player player) {
        setActive(actions, "BAIL_OUT_OF_JAIL", true); //we might have to check the existence of the card later
        setActive(actions, "WAIT", true);
        setActive(actions, "THROW_DOUBLE_DICE", true);
        setActive(actions, "PAY_BAIL_BOND", true);
        return actions;
    }
}
