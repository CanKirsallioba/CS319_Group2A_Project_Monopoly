package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.actionStrategy.AbstractActionFactory;
import com.monopoly.model.tiles.actionStrategy.ActionFactory;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class Tile implements Serializable {
    public String name = this.getClass().getSimpleName();
    protected AbstractActionFactory actionFactory;
    boolean hasCustomizedFunctionality;
    ArrayList<Action> actions;

    // newly added
    int index;

    Tile() {
        actionFactory = new ActionFactory();
        actions = actionFactory.getActionList(name);
        hasCustomizedFunctionality = false;
    }

    public ArrayList<Action> getPossibleActions(Player player) {
        ArrayList<Action> actionsToBeReturned = hook(player);
        for(Action action : actionsToBeReturned) {
            action.setPlayer(player);
            action.setActive(true);
        }
        return actionsToBeReturned;
    }

    public void setIndex( int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public void setActive(ArrayList<Action> actionList, String actionName, boolean active) {
        for(Action action: actionList) {
            if (action.getName().equals(actionName)) {
                action.setActive(active);
            }
        }
    }
    protected abstract ArrayList<Action> hook(Player player);
}
