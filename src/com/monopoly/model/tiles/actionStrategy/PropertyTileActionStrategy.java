package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;

public class PropertyTileActionStrategy extends ActionStrategy {
    String[] actionNames;

    public PropertyTileActionStrategy(String[] actionNames) {
        this.actionNames = actionNames;
    }

    @Override
    public void button1Strategy(Player player) {
        System.out.println("S1");

    }

    @Override
    public void button2Strategy(Player player) {
        System.out.println("S2");

    }

    @Override
    public void button3Strategy(Player player) {
        System.out.println("S3");

    }

    @Override
    public void button4Strategy(Player player) {
        System.out.println("S4");

    }

    public String[] getActionNames() {
        return actionNames;
    }
}
