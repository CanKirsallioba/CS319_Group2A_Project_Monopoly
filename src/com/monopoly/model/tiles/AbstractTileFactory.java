package com.monopoly.model.tiles;

import com.monopoly.model.ConfigAdapter;
import org.json.simple.JSONObject;


public abstract class AbstractTileFactory {
    public abstract Tile getTile(JSONObject config);
}
