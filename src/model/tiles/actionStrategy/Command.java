package model.tiles.actionStrategy;

import model.player.Player;

public interface Command {
    void execute(Player player);
}
