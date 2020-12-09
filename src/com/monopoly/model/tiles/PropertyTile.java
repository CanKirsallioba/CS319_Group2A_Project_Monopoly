package com.monopoly.model.tiles;

import com.monopoly.model.tiles.property.TitleDeedCard;

public class PropertyTile extends Tile {
    TitleDeedCard titleDeedCard;

    public PropertyTile() {

    }

    @Override
    protected Action[] hook() {
        return titleDeedCard.getPossibleActions();
    }

    public TitleDeedCard getTitleDeedCard() {
        return titleDeedCard;
    }
}
