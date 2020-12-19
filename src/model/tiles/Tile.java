package model.tiles;

import model.player.Player;
import model.tiles.actionStrategy.AbstractActionFactory;
import model.tiles.actionStrategy.ActionFactory;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Tile implements Serializable {
    
    public String tileName;
    public String name = this.getClass().getSimpleName();
    protected transient AbstractActionFactory actionFactory;
    boolean hasCustomizedFunctionality;
    ArrayList<GameAction> actions;

    // newly added
    int index;
    
    
    Tile() {
        actionFactory = new ActionFactory();
        actions = actionFactory.getActionList(name);
        hasCustomizedFunctionality = false;
    }

    
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractActionFactory getActionFactory() {
        return actionFactory;
    }

    public void setActionFactory(AbstractActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    public boolean isHasCustomizedFunctionality() {
        return hasCustomizedFunctionality;
    }

    public void setHasCustomizedFunctionality(boolean hasCustomizedFunctionality) {
        this.hasCustomizedFunctionality = hasCustomizedFunctionality;
    }

    public ArrayList<GameAction> getActions() {
        return actions;
    }

    public void setActions(ArrayList<GameAction> actions) {
        this.actions = actions;
    }

    public ArrayList<GameAction> getPossibleActions(Player player) {
        ArrayList<GameAction> actionsToBeReturned = hook(player, getActions());


        ArrayList<GameAction> activeActions = new ArrayList<>();

        for(GameAction action : actionsToBeReturned) {
            action.setPlayer(player);
            if(action.isActive()) {
                activeActions.add(action);
            }
        }

        return activeActions;
    }

    public void setIndex( int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public void setActive(ArrayList<GameAction> actionList, String actionName, boolean active) {
        for(GameAction action: actionList) {
            if (action.getName().equals(actionName)) {
                action.setActive(active);
            }
        }
    }
    protected abstract ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions);
}
