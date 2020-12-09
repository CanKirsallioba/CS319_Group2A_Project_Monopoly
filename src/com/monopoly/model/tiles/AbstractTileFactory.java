package com.monopoly.model.tiles;

import com.monopoly.model.ConfigPlaceHolder;

public abstract class AbstractTileFactory {

    ConfigPlaceHolder configPlaceHolder;

    public abstract Tile getTile(String tileName);
}
