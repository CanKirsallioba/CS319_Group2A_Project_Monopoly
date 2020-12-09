package com.monopoly.model.tiles.actionStrategy;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.Tile;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public class PropertyTileActionStrategy extends ActionStrategy {
    String[] actionNames;

    public PropertyTileActionStrategy(String[] actionNames) {
        this.actionNames = actionNames;
    }

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
        PropertyTile tile;
        if (!(player.getCurrentTile () instanceof PropertyTile)) {
            throw new RuntimeException ( "Wrong tile type" );
        }
        tile = (PropertyTile) player.getCurrentTile ();
        TitleDeedCard card = tile.getTitleDeedCard();
        int totalRent = card.getPropertyValue();

        if (player.getBalance() >= totalRent) {
            player.changeBalance(-totalRent);
            Player otherPlayer = card.getOwner();
            otherPlayer.changeBalance(totalRent);
        } else {
            // todo here must change
//            player.startTrade(otherPlayer);
        }
    }

    /**
     * This strategy is related to the starting auction.
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {
        PropertyTile tile;
        if (!(player.getCurrentTile () instanceof PropertyTile)) {
            throw new RuntimeException ( "Wrong tile type" );
        }
        tile = (PropertyTile) player.getCurrentTile ();
        TitleDeedCard card = tile.getTitleDeedCard ();
        ArrayList<TitleDeedCard> titleDeedCards = new ArrayList<>();
        titleDeedCards.add(card);
        player.startAuction(titleDeedCards);
    }

    @Override
    public void button4Strategy(Player player) {
        System.out.println("S4");

    }

    /**
     * This method is the helper method for the button1Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void buyProperty(Player player) {
        PropertyTile tile;
        if (!(player.getCurrentTile () instanceof PropertyTile)) {
            throw new RuntimeException ( "Wrong tile type" );
        }
        tile = (PropertyTile) player.getCurrentTile ();
        TitleDeedCard card = tile.getTitleDeedCard ();
        if ((player.getBalance () >= card.getPropertyValue()) && !card.isOwned ()) {
            player.changeBalance ( -card.getPropertyValue() );
            player.addTitleDeedCard ( card );
        }
    }

    /**
     * This method is the helper method for the button2Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void payRent(Player player) {
        PropertyTile tile;
        if (!(player.getCurrentTile () instanceof PropertyTile)) {
            throw new RuntimeException ( "Wrong tile type" );
        }
        tile = (PropertyTile) player.getCurrentTile ();
        TitleDeedCard card = tile.getTitleDeedCard ();

        int totalRent = card.getPropertyValue ();

        if (player.getBalance () >= totalRent) {
            player.changeBalance ( -totalRent );
            Player otherPlayer = card.getOwner ();
            otherPlayer.changeBalance ( totalRent );
        } else {
//            player.startTrade ( otherPlayer );
            // Todo
        }
    }

    /**
     * This method is the helper method for the button3Strategy.
     * @param player the player that the action is inflicted on.
     */
    private void startAuction(Player player) {
        PropertyTile propertyTile;
        if (!(player.getCurrentTile () instanceof PropertyTile)) {
            throw new RuntimeException ( "Wrong tile type" );
        }
        PropertyTile tile = (PropertyTile) player.getCurrentTile ();
        TitleDeedCard card = tile.getTitleDeedCard ();
        if (!card.isOwned ()) {
            ArrayList<TitleDeedCard> titleDeedCards = new ArrayList<>();
            titleDeedCards.add ( card );
            player.startAuction ( titleDeedCards );
        }
    }

    public String[] getActionNames() {
        return actionNames;
    }
}
