package com.monopoly.model.tiles;

import org.json.simple.JSONObject;


public abstract class AbstractTileFactory {
    public abstract Tile getTile(JSONObject config);
}
