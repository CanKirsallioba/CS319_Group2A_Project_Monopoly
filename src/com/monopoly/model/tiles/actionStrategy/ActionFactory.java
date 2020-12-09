package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.tiles.Action;

public class ActionFactory extends AbstractActionFactory {
    public static ActionStrategy createStrategy(String className) {
        return null;
    }

    @Override
    public Action[] getActionList(String className) {
        return new Action[0];
    }
}
