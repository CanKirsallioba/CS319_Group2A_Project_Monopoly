package model.tiles;

import model.player.BailOutChoice;
import model.player.Player;

import java.util.ArrayList;

public class JailTile extends Tile {

    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {

        if(player.getGetOutOfJailChoice() != BailOutChoice.WAIT) {
            if (player.getBailOutOfJailCards().size() != 0) {
                setActive(actions, "Use Bail Out Of Jail Card", true);
            }
            if (player.getLiquidTotalWorth() > 0) { // TODO: Fix the bail out price
                setActive(actions, "Pay Bail Bond", true);
            }
            setActive(actions, "Roll Dice", true);
        }else {
            setActive(actions, "Wait", true);
        }

        return actions;
    }
}