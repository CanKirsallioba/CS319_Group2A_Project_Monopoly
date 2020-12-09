package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.actionStrategy.AbstractActionFactory;
import com.monopoly.model.tiles.actionStrategy.ActionFactory;

import java.io.Serializable;

public abstract class Tile implements Serializable {
    public String name = this.getClass().getSimpleName();
    protected AbstractActionFactory actionFactory;
    boolean hasAdditionalFunctionality;
    Action[] actions;

    // newly added
    int index;

    Tile() {
        actionFactory = new ActionFactory();
        actions = actionFactory.getActionList(name);
        hasAdditionalFunctionality = false;
    }

    public Action[] getPossibleActions(Player player) {
        if (hasAdditionalFunctionality) {
            return hook();
        } else {
            return actions;

        }
    }

    public void setIndex( int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    protected abstract Action[] hook();
}
