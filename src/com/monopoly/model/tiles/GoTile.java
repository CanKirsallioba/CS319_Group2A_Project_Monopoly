package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class GoTile extends Tile {
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {
        return actions;
    }
}
