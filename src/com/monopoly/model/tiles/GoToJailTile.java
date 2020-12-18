package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class GoToJailTile extends Tile {


    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions){
        setActive(actions, "Go To Jail", true);
        return actions;
    }
}
