package model.tiles.actionStrategy;

import model.player.Player;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(Player player);
}
