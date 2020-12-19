package model.tiles;

import model.player.Player;
import model.player.TaxOption;

import java.util.ArrayList;

public class IncomeTaxTile extends Tile {

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
