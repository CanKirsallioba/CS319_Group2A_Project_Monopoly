package model.tiles;

import model.player.BailOutChoice;
import model.player.Player;

import java.util.ArrayList;

public class JailTile extends Tile {

    /**
     * TThis method activates and deactivates bail out actions based on the choice of the player
     * @param player the player who landed on the tile
     * @param actions the actions associated with the tile
     * @return
     */
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {

//        System.out.println("jail tile hook called");
        if (player.isInJail()) {
            if (player.getGetOutOfJailChoice() == BailOutChoice.WAIT) {
                if (player.getBailOutOfJailCards().size() == 0) {
                    setActive(actions, "Use Bail Out Of Jail Card", false);
                } else {
                    setActive(actions, "Use Bail Out Of Jail Card", true);
                }
                if (player.getLiquidTotalWorth() > player.getPlayerToken().getBoard().getBoardSalary() / 4) {
                    setActive(actions, "Pay Bail Bond", true);
                } else {
                    setActive(actions, "Pay Bail Bond", false);
                }
                setActive(actions, "Roll Dice", true);
            } else {
                setActive(actions, "Use Bail Out Of Jail Card", false);
                setActive(actions, "Pay Bail Bond", false);
                setActive(actions, "Roll Dice", false);

            }
        } else {
            setActive(actions, "Use Bail Out Of Jail Card", false);
            setActive(actions, "Pay Bail Bond", false);
            setActive(actions, "Roll Dice", false);

        }


        return actions;
    }
}
