package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.tiles.*;

import java.util.ArrayList;

public abstract class AbstractActionFactory {
    public abstract ArrayList<Action> getActionList(String className);
}
