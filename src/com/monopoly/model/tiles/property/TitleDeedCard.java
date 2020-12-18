package com.monopoly.model.tiles.property;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.GameAction;
import com.monopoly.model.tiles.PropertyTile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class TitleDeedCard implements Serializable {
    // TODO state si olacak
    // TODO Her state icin farkli action arraylistleri olacak
    // TODO Kendi state ini handle edecek hem owned hem de levellari icin state i olacak.
    // TODO reset methodu
    final double mortgageRemovalMultiplier = 1.1;
    ArrayList<GameAction> propertyActions;
    String propertyName;
    int levelZeroRent, levelOneRent, levelTwoRent, levelThreeRent, levelFourRent, levelFiveRent;
    boolean isOwned;
    boolean isMortgaged;
    int upgradeLevel;
    int propertyValue;
    int mortgageValue;
    int upgradeCost;
    int mortgagedTurnNumber;
    ColorGroup colorGroup;
    Player owner;


    public ArrayList<GameAction> getPropertyActions() {
        return propertyActions;
    }

    public void setPropertyActions(ArrayList<GameAction> propertyActions) {
        this.propertyActions = propertyActions;
    }

    /**
     * Finds the action with the specified name and activates it
     * @param actionName the name of action
     * @return true if deactivation is successful
     */
    public boolean deactivateAction(String actionName){
        for(GameAction action: propertyActions){
            if(action.getName().equals(actionName)) {
                action.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the action with the specified name and deactivates it
     * @param actionName the name of action
     * @return true if activation is successful
     */
    public boolean activateAction(String actionName){
        for(GameAction action: propertyActions){
            if(action.getName().equals(actionName)) {
                action.setActive(true);
                return true;
            }
        }
        return false;
    }


    /**
     * Updates the property's actions based according to the state of property (owned, mortgaged and upgradeLevel)
     */
    public void updateActions() {
        /*
        UNOWNED
            all deactivated
        - level 0:
        upgrade active:
        unmortgaged & mortgage active:
        downgrade deactive:


        */

        if (upgradeLevel > 0)
            activateAction("Downgrade Property");
        else
            deactivateAction("Downgrade Property");
        // todo check if tiles are even.
        if (upgradeLevel < 5)
            activateAction("Upgrade Property");
        else
            deactivateAction("Upgrade Property");


        if (!isMortgaged) {
            activateAction("Mortgage Property");
            deactivateAction("Remove Mortgage");
        } else {
            deactivateAction("Mortgage Property");
            activateAction("Remove Mortgage");
        }
    }

    /**
     * @return level four rent of the property
     */
    public int getLevelFourRent() {
        return levelFourRent;
    }

    /**
     * @param levelFourRent level four rent of the property
     */
    public void setLevelFourRent(int levelFourRent) {
        this.levelFourRent = levelFourRent;
    }

    /**
     * @return level five rent of the property
     */
    public int getLevelFiveRent() {
        return levelFiveRent;
    }

    /**
     * @param levelFiveRent level five rent of the property
     */
    public void setLevelFiveRent(int levelFiveRent) {
        this.levelFiveRent = levelFiveRent;
    }

    /**
     * @return whether the property is mortgaged
     */
    public boolean isMortgaged() {
        return isMortgaged;
    }

    /**
     * @return whether the property is owned
     */
    public boolean isOwned() {
        return isOwned;
    }

    /**
     * @return the owner of the property
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * @param mortgaged whether the property is mortgaged
     */
    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

    /**
     * @return upgrade level of the property
     */
    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    /**
     * @param upgradeLevel the upgrade level of the property
     */
    public void setUpgradeLevel(int upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }

    /**
     * @return value of the property
     */
    public int getPropertyValue() {
        return propertyValue;
    }

    /**
     * @param propertyValue value of the property
     */
    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }

    /**
     * @return mortgage value of the property
     */
    public int getMortgageValue() {
        return mortgageValue;
    }

    /**
     * @param mortgageValue mortgage value of the property
     */
    public void setMortgageValue(int mortgageValue) {
        this.mortgageValue = mortgageValue;
    }

    /**
     * @return the cost of upgrading the property
     */
    public int getUpgradeCost() {
        return upgradeCost;
    }

    /**
     * @param upgradeCost upgrade cost of the property
     */
    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    /**
     * @return the number of turns passed while the property is mortgaged
     */
    public int getMortgagedTurnNumber() {
        return mortgagedTurnNumber;
    }

    /**
     * @param mortgagedTurnNumber the number of turns passed while the property is mortgaged
     */
    public void setMortgagedTurnNumber(int mortgagedTurnNumber) {
        this.mortgagedTurnNumber = mortgagedTurnNumber;
    }

    /**
     * @return the color group of the property
     */
    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    /**
     * @param colorGroup color group of the property
     */
    public void setColorGroup(ColorGroup colorGroup) {
        this.colorGroup = colorGroup;
    }

    /**
     * @return mortgage removal multiplier for the property
     */
    public double getMortgageRemovalMultiplier() {
        return mortgageRemovalMultiplier;
    }

    /**
     * @return the penalty of removing the mortgage of the property
     */
    public int mortgageRemovalPenalty() {
        return 0; //TODO penalty or multiplier?
    }

    public String getPropertyName() {
        return propertyName;

    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * @return level zero rent of the property
     */
    public int getLevelZeroRent() {
        return levelZeroRent;

    }

    public void setLevelZeroRent(int levelZeroRent) {
        this.levelZeroRent = levelZeroRent;
    }

    /**
     * @return level one rent of the property
     */
    public int getLevelOneRent() {
        return levelOneRent;

    }

    public void setLevelOneRent(int levelOneRent) {
        this.levelOneRent = levelOneRent;
    }

    /**
     * @return level two rent of the property
     */
    public int getLevelTwoRent() {
        return levelTwoRent;

    }

    /**
     * @param levelTwoRent level two rent of the property
     */
    public void setLevelTwoRent(int levelTwoRent) {
        this.levelTwoRent = levelTwoRent;
    }

    /**
     * @return level three rent of the property
     */
    public int getLevelThreeRent() {
        return levelThreeRent;
    }

    /**
     * @param levelThreeRent level three rent of the property
     */
    public void setLevelThreeRent(int levelThreeRent) {
        this.levelThreeRent = levelThreeRent;
    }

    /**
     * @return the possible actions associated with the property
     */
    public ArrayList<GameAction> getPossibleActions() {
        return null;
    }

    /**
     * Checks whether the property is upgradable. If yes, upgrades the property.
     * @return upgrade cost if the property is upgraded and 0 otherwise.
     */
    public int upgrade(){
        if(!colorGroup.allOwnedByPlayer(owner)) //if the player
            return 0;

        upgradeLevel++;
        updateActions();
        return upgradeCost;
    }

    /**
     * Checks whether the property is downgradable. If yes, downgrades the property.
     * @return the gain after downgrading the property.
     */
    public int downgrade() {
        if(upgradeLevel == 0)
            return 0;
        upgradeLevel--;
        updateActions();
        return upgradeCost/2;
    }

    /**
     * Downgrades the property until its upgrade value becomes zero
     */
    public void resetProperty(){
        while(upgradeLevel > 0)
            downgrade();
    }


    /**
     * This method mortgages the property and returns the player's gain after mortgaging the proeprty
     */
    public int mortgage() {
        isMortgaged = true;
        return mortgageValue;
    }

    /**
     * This method removes the mortgage of the property and returns the mortgage removal fee
     */
    public int removeMortgage() {
        isMortgaged = false;
        return (int)(mortgageValue * mortgageRemovalMultiplier);
    }


    /**
     *
     * @return the current rent based on upgrade level
     */
    public int getCurrentRent(){
        int upgradeLevel = 0;
        int rent = 0;

        upgradeLevel = getUpgradeLevel();

        if( upgradeLevel == 0){
            rent = getLevelZeroRent();
        }
        else if( upgradeLevel == 1){
            rent = getLevelOneRent();

        }
        else if( upgradeLevel == 2){
            rent = getLevelTwoRent();
        }
        else if( upgradeLevel == 3){
            rent = getLevelThreeRent();
        }
        else if( upgradeLevel == 4){
            rent = getLevelFourRent();
        }
        else if( upgradeLevel == 5){
            rent = getLevelFiveRent();
        }
        return rent;
    }
}
