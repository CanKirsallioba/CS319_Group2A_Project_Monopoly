package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class JailTile extends Tile {

    @Override
    protected ArrayList<Action> hook(Player player) {
        return actions;
    }
}
