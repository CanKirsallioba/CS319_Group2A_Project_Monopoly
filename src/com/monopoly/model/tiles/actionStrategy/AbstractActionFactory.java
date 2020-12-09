package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.tiles.Action;

public abstract class AbstractActionFactory {
    public abstract Action[] getActionList(String className);
}
