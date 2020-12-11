package com.monopoly.model.tiles;

import com.monopoly.model.ConfigAdapter;


public abstract class AbstractTileFactory {

    ConfigAdapter configPlaceHolder;

    public abstract Tile getTile(String tileName);
}
