package model.tiles;

import model.player.Player;
import model.tiles.actionStrategy.Command;

import java.io.Serializable;

public class GameAction implements Serializable {
    String name;
    Command command;
    boolean isMandatory;
    boolean isActive;
    Player player;

    public void execute() {
        if (isActive) command.execute(player);
        else throw new RuntimeException("An deactivated action is executed. Action name: " + name);
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

    @Override
    public String toString() {
        return "GameAction{" +
                "name='" + name + '\'' +
                ", command=" + command +
                ", isMandatory=" + isMandatory +
                ", isActive=" + isActive +
                ", player on tile=" +
                '}';
    }
}
