package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.tiles.GameAction;

import java.util.ArrayList;

public abstract class AbstractActionFactory {
    public abstract ArrayList<GameAction> getActionList(String className);
}
