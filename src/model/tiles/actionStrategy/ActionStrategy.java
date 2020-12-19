package model.tiles.actionStrategy;

import model.player.Player;

import java.io.Serializable;

public abstract class ActionStrategy implements Serializable {

    public abstract void button1Strategy(Player player);

    public abstract void button2Strategy(Player player);

    public abstract void button3Strategy(Player player);

    public abstract void button4Strategy(Player player);
}
