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

    /**
     * @return the name of the tile
     */
    public String getTileName() {
        return tileName;
    }

    /**
     * @param tileName the name of the tile
     */
    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    /**
     * @return the name of the tile
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name of the tile
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the action factors that constructs the actions associated with the tile
     */
    public AbstractActionFactory getActionFactory() {
        return actionFactory;
    }

    /**
     * @param actionFactory the action factory that constructs the actions associated with the tile
     */
    public void setActionFactory(AbstractActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    /**
     * @return true if the property has customized functionality
     */
    public boolean isHasCustomizedFunctionality() {
        return hasCustomizedFunctionality;
    }

    /**
     * @param hasCustomizedFunctionality the attribute indicating if the property has customized functionality
     */
    public void setHasCustomizedFunctionality(boolean hasCustomizedFunctionality) {
        this.hasCustomizedFunctionality = hasCustomizedFunctionality;
    }

    /**
     * @return property actions
     */
    public ArrayList<GameAction> getActions() {
        return actions;
    }

    /**
     * @param actions property actions
     */
    public void setActions(ArrayList<GameAction> actions) {
        this.actions = actions;
    }

    /**
     * This method returns all possible actions that can be executed after landing on the tile
     * @param player
     * @return
     */
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

    /**
     * @param index index of the tile on the board
     */
    public void setIndex( int index){
        this.index = index;
    }

    /**
     * @return index of the tile on the board
     */
    public int getIndex(){
        return index;
    }

    /**
     * This method changes the activeness of property actions
     * @param actionList
     * @param actionName
     * @param active
     */
    public void setActive(ArrayList<GameAction> actionList, String actionName, boolean active) {
        for(GameAction action: actionList) {
            if (action.getName().equals(actionName)) {
                action.setActive(active);
            }
        }
    }

    /**
     * This method is implemented in each subclass according to the functionality of the tile
     * @param player
     * @param actions
     * @return
     */
    protected abstract ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions);
}
