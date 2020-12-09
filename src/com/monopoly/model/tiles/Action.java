package com.monopoly.model.tiles;

import com.monopoly.model.tiles.actionStrategy.Command;

public class Action {
    String name;
    Command command;
    boolean isMandatory;
    boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    Action(String name, Command command, boolean mandatory) {
    }
}
