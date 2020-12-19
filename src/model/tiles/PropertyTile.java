package model.tiles;

import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public class PropertyTile extends Tile {
    TitleDeedCard titleDeedCard;

    public PropertyTile() {
    }

    @Override
    protected ArrayList<GameAction> hook(Player player, ArrayList<GameAction> actions) {
        player.setSelectedTitleDeed(titleDeedCard);
        // todo auction?
        if(!(titleDeedCard.isOwned())){
            setActive ( actions, "Buy Property", true );
            setActive ( actions, "Pay Rent", false );
        } else if(titleDeedCard.getOwner() != player){
            setActive ( actions, "Buy Property", false );
            setActive ( actions, "Pay Rent", true );
        } else if(titleDeedCard.getOwner() == player){
            setActive ( actions, "Buy Property", false );
            setActive ( actions, "Pay Rent", false );
            return titleDeedCard.getPropertyActions();
        } else {
            throw new RuntimeException();
        }

        return actions;
    }


    public TitleDeedCard getTitleDeedCard() {
        return titleDeedCard;
    }

    public void setTitleDeedCard(TitleDeedCard titleDeedCard) {
        this.titleDeedCard = titleDeedCard;
    }
}
