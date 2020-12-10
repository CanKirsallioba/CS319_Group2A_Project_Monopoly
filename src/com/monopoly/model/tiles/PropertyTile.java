package com.monopoly.model.tiles;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.property.TitleDeedCard;
import java.util.ArrayList;

public class PropertyTile extends Tile {
    TitleDeedCard titleDeedCard;

    public PropertyTile() {
    }

    @Override
    protected ArrayList<Action> hook(Player player) {
        player.setSelectedTitleDeedCard(getTitleDeedCard());
        return getTitleDeedCard().getPropertyActions();
    }


    public TitleDeedCard getTitleDeedCard() {
        return titleDeedCard;
    }

    public void setTitleDeedCard(TitleDeedCard titleDeedCard) {
        this.titleDeedCard = titleDeedCard;
    }
}
