package model.tiles;

import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;


public class PropertyTile extends Tile {
    TitleDeedCard titleDeedCard;

    public PropertyTile() {
    }

    /**
     * This method adjusts the activity of the property actions based on the state of the property
     * @param player the player who landed on the tile
     * @param actions the actions associated with the tile
     * @return
     */
    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {
        player.setSelectedTitleDeed(titleDeedCard);
        if(!(titleDeedCard.isOwned())){
            // todo remove this if bugs arises in AI Player player.getBalance () >= card.getPropertyValue()
            setActive ( actions, "Buy Property", player.getBalance () >= getTitleDeedCard().getPropertyValue());
            setActive ( actions, "Pay Rent", false );
            setActive ( actions, "Start Auction", true );
        } else if(titleDeedCard.getOwner() != player){
            setActive ( actions, "Buy Property", false );

            if(player.getLiquidTotalWorth() < player.getSelectedTitleDeed().getCurrentRent()) {
                setActive ( actions, "Pay Rent", false );
                setActive(actions, "Declare Bankruptcy", true);
            }
            else{
                setActive ( actions, "Pay Rent", true );
                setActive(actions, "Declare Bankruptcy", false);
            }

            setActive ( actions, "Start Auction", false );
        } else if(titleDeedCard.getOwner() == player){
            setActive ( actions, "Buy Property", false );
            setActive ( actions, "Pay Rent", false );
            setActive ( actions, "Start Auction", false );
            return titleDeedCard.getPropertyActions();
        } else {
            throw new RuntimeException();
        }

        return actions;
    }


    /**
     * @return the title deed card of the property
     */
    public TitleDeedCard getTitleDeedCard() {
        return titleDeedCard;
    }

    /**
     * @param titleDeedCard the title deed card of the property
     */
    public void setTitleDeedCard(TitleDeedCard titleDeedCard) {
        this.titleDeedCard = titleDeedCard;
    }
}
