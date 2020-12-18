package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.actionStrategy.Command;

import java.io.Serializable;

public class GameAction implements Serializable {
    String name;
    Command command;
    boolean isMandatory;
    boolean isActive;
    Player player;

    public void execute() {
        command.execute(player);
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
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

    public GameAction(String name, Command command, boolean isMandatory, boolean isActive) {
        this.name = name;
        this.command = command;
        this.isMandatory = isMandatory;
        this.isActive = isActive;
    }
}
