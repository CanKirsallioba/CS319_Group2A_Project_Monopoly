package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.tiles.GameAction;

import java.util.ArrayList;

public class ActionFactory extends AbstractActionFactory {
    public static ActionStrategy createStrategy(String className) {
        return null;
    }

    @Override
    public ArrayList<GameAction> getActionList(String className) {
        return null;
    }
}
