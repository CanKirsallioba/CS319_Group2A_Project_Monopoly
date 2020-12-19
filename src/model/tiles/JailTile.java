package model.tiles;

import model.player.AbstractPlayer;
import model.player.BailOutChoice;
import model.player.Player;

import java.util.ArrayList;

public class JailTile extends Tile {

    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {

        System.out.println("jail tile hook called");
        if(player.getCurrentTile() instanceof JailTile){

           if(player.isInJail()) {
               if (player.getGetOutOfJailChoice() != BailOutChoice.WAIT) {
                   setActive(actions, "Use Bail Out of Jail Card", false);
                   setActive(actions, "Pay Bail Bond", false);
                   setActive(actions, "Roll Dice", false);
               } else {
                   if (player.getBailOutOfJailCards().size() != 0) {
                       setActive(actions, "Use Bail Out Of Jail Card", true);
                   }
                   if (player.getLiquidTotalWorth() > player.getPlayerToken().getBoard().getBoardSalary() / 4) {
                       setActive(actions, "Pay Bail Bond", true);
                   }
                   setActive(actions, "Roll Dice", true);
               }
           }
        }
        else{
            throw new RuntimeException();
        }

        return actions;
    }
}
