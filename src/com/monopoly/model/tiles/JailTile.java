package com.monopoly.model.tiles;

import com.monopoly.model.player.BailOutChoice;
import com.monopoly.model.player.Player;

import java.util.ArrayList;

public class JailTile extends Tile {

    @Override
    public ArrayList<GameAction> hook(Player player) {

        if(player.getGetOutOfJailChoice() != BailOutChoice.WAIT) {
            if (player.getCards().size() != 0) {
                setActive(actions, "Bail Out Of Jail", true); //we might have to check the existence of the card later
            }
            if (player.getLiquidTotalWorth() > 0) { // TODO: Fix the bail out price
                setActive(actions, "Pay Bail Bond", true);
            }
            setActive(actions, "Throw Double Dice", true);
        }else {
            setActive(actions, "Wait", true);
        }

        return actions;
    }
}
