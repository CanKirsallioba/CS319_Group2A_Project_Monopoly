package model.tiles;

import model.player.Player;
import model.tiles.actionStrategy.Command;

import java.io.Serializable;

public class GameAction implements Serializable {
    String name;
    Command command;
    boolean isMandatory;
    boolean isActive;
    boolean executed;
    Player player;

    /**
     * Constructor for the GameAction object
     * @param name is the name of the action
     * @param command is the command attribute for the GameAction object
     * @param isMandatory is the mandatory information of the GameAction object.
     * @param isActive is the active information of the GameAction object.
     */
    public GameAction(String name, Command command, boolean isMandatory, boolean isActive) {
        this.name = name;
        this.command = command;
        this.isMandatory = isMandatory;
        this.isActive = isActive;
    }

    /**
     * This method returns a boolean to check the executed condition.
     * @return a boolean, executed.
     */
    public boolean isExecuted() {
        return executed;
    }

    /**
     * Setter method for the executed variable.
     * @param executed is set by the executed in the arguments of the function.
     */
    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    /**
     * This method checks if the action is active and makes the command
     * execute by the player. Also sets the executed information to true.
     */
    public void execute() {
        if (isActive) {
            setExecuted(true);
            command.execute(player);
        } else throw new RuntimeException("An deactivated action is executed. Action name: " + name);
    }

    /**
     * Getter method for the player.
     * @return the player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter method for the player, also sets the executed information to false
     * @param player is the argument that will be set to the class' player.
     */
    public void setPlayer(Player player) {
        setExecuted(false);
        this.player = player;
    }

    /**
     * Getter method for the name attribute.
     * @return the name attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name attribute.
     * @param name is the name attribute to be set to the class' name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the command attribute.
     * @return the command attribute.
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Setter method for the command attribute.
     * @param command is the command attribute.
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * This method returns the mandatory information.
     * @return mandatory information.
     */
    public boolean isMandatory() {
        return isMandatory;
    }

    /**
     * Setter for the mandatory information.
     * @param mandatory is the mandatory information to be set to the class' mandatory attribute.
     */
    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    /**
     * This method returns the isActive attribute.
     * @return the active information.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Setter function for the active information.
     * @param active is the active information to be set to the class' active attribute.
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * toString method for the actions, displaying its attributes.
     * @return the string for the GameAction object.
     */
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
