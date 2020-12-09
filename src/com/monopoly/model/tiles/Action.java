package com.monopoly.model.tiles;

import com.monopoly.model.tiles.actionStrategy.Command;

public class Action {
    String name;
    Command command;
    boolean mandatory;

    Action(String name, Command command, boolean mandatory) {
    }
}
