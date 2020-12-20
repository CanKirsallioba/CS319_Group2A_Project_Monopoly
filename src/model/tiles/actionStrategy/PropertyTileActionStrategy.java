package model.tiles.actionStrategy;

import model.player.Player;
import model.tiles.PropertyTile;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public class PropertyTileActionStrategy extends ActionStrategy {

    /**
     * This strategy is related to the buy operation.
     *
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {
        buyProperty ( player );
    }

    /**
     * This strategy is related to the pay rent operation, also has the possibility to initiate trade.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {
        payRent(player);
    }

    /**
     * This strategy is related to the starting auction.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {
        TitleDeedCard card = player.getSelectedTitleDeed();
        ArrayList<TitleDeedCard> titleDeedCards = new ArrayList<>();
        titleDeedCards.add(card);
        player.startAuction(titleDeedCards);
    }

    /**
     * This strategy is related to declaring bankruptcy when the player has insufficient money
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button4Strategy(Player player) {
        player.declareBankruptcy();

    }

    /**
     * This method is the helper method for the button1Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void buyProperty(Player player) {
        TitleDeedCard card = player.getSelectedTitleDeed();
//        System.out.println("Property Value: " + card.getPropertyValue());
        if ((player.getBalance () >= card.getPropertyValue()) && !card.isOwned ()) {
            card.setOwner(player);
            card.setOwned(true);
            player.changeBalance ( -card.getPropertyValue() );
            player.addTitleDeedCard ( card );
            card.updateActions();
        }
//        for (TitleDeedCard titleDeed : player.getTitleDeeds()) {
//            System.out.println("TitleDeedName: " + titleDeed.getPropertyName());
//        }
    }

    /**
     * This method is the helper method for the button2Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void payRent(Player player) {
        TitleDeedCard card = player.getSelectedTitleDeed();
        int totalRent = card.getCurrentRent();

        if (player.getBalance() >= totalRent) {
            player.changeBalance(-totalRent);
            Player otherPlayer = card.getOwner();
            otherPlayer.changeBalance(totalRent);
        } else {
            // todo here must change
//            player.startTrade(otherPlayer);
        }
        card.updateActions();
    }

    /**
     * This method is the helper method for the button3Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void startAuction(Player player) {
        TitleDeedCard card = player.getSelectedTitleDeed();
        if (!card.isOwned ()) {
            ArrayList<TitleDeedCard> titleDeedCards = new ArrayList<>();
            titleDeedCards.add ( card );
            player.startAuction ( titleDeedCards );
        }
    }
}
