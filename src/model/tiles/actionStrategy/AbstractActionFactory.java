package model.tiles.actionStrategy;

import model.tiles.GameAction;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractActionFactory {
    public abstract ArrayList<GameAction> getActionList(String className);
}
