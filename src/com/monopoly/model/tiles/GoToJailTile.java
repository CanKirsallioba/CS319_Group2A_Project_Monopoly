package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class GoToJailTile extends Tile {


    @Override
    public ArrayList<GameAction> hook(Player player) {
        return actions;
    }
}
