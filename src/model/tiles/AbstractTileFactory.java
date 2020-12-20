package model.tiles;
import org.json.simple.JSONObject;

public abstract class AbstractTileFactory {
    /**
     * Abstract getter function for the tiles, it takes a JSON config object as its argument.
     * @param config is the config object
     * @return the tile that is returned with the config data
     */
    public abstract Tile getTile(JSONObject config, int gamePace);
}
