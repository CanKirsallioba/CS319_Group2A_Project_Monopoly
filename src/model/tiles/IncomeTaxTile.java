package model.tiles;

import model.player.AbstractPlayer;
import model.player.Player;
import model.player.TaxOption;

import java.util.ArrayList;

public class IncomeTaxTile extends Tile {

    /**
     * This method activates the actions related to tax type choice and paying tax
     * @param player the player who landed on the tile
     * @param actions the actions associated with the tile
     * @return
     */
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions){

        if (player.getTaxOption() == TaxOption.UNDETERMINED) {
            setActive(actions, "Pay Fixed Amount", true);
            setActive(actions, "Pay With Ratio", true);
            setActive(actions, "Pay Tax", false);
        } else {
            setActive(actions, "Pay Tax", true);
            setActive(actions, "Pay Fixed Amount", false);
            setActive(actions, "Pay With Ratio", false);
        }
        return actions;
    }
}
