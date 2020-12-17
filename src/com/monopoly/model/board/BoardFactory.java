package com.monopoly.model.board;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.Tile;
import com.monopoly.model.tiles.TileFactory;
import com.monopoly.model.tiles.property.TitleDeedCard;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class BoardFactory {
    public Board get(BoardConfiguration boardConfiguration, JSONObject config) {
        Board board = new Board();
        TileFactory tileFactory = new TileFactory();

        ArrayList<Tile> tiles = new ArrayList<>();
        JSONArray tileConfigs = (JSONArray) config.get("tiles");
        for (Object tileConfig : tileConfigs) {
            tiles.add(tileFactory.getTile((JSONObject) tileConfig));
        }
        board.setTiles(tiles);

        // Todo associate the color groups.
//        JSONArray colorGroups = (JSONArray) config.get("colorGroups");
//        for (Object colorObject : colorGroups) {
//            String color = (String) ((JSONObject) colorObject).get("color");
//            ArrayList<PropertyTile> propertiesInSameColorGroup = new ArrayList<PropertyTile>();
//            for (Tile tile : tiles) {
//                if( tile instanceof PropertyTile) {
//                    TitleDeedCard card = ((PropertyTile) tile).getTitleDeedCard();
//                    card.getColorGroup();
//                }
//            }
//        }
        // TODO set jail tile index.
//        board.setJailTileIndex((Integer)config.get());
        // TODO set salary
        // TODO set board name.
        return null;
    }
}
