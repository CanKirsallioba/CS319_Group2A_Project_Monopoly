package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;

public interface Command {
    void execute(Player player);
}
