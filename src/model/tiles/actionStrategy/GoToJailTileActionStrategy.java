package model.tiles.actionStrategy;

import model.player.Player;

public class GoToJailTileActionStrategy extends ActionStrategy {
    /**
     * This strategy is related to sending the player to the jail.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        player.goToJail();
    }

    @Override
    public void button2Strategy(Player player) {

    }

    @Override
    public void button3Strategy(Player player) {

    }

    @Override
    public void button4Strategy(Player player) {

    }
}
