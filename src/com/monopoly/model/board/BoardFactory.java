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

        //set tiles from config file
        for (Object tileConfig : tileConfigs) {
            JSONObject tileObj = (JSONObject) ((JSONObject) tileConfig).get("tile");
            tiles.add(tileFactory.getTile(tileObj));
        }
        board.setTiles(tiles);

        // associate the color groups - work in progress to discuss with teammates
        JSONArray colorGroups = (JSONArray) config.get("colorGroups");
        for (Object colorConfig : colorGroups) {
            JSONObject colorObj = (JSONObject) ((JSONObject) colorConfig).get("colorGroup");
            String color = (String) colorObj.get("color");

        }

        //set jail index to board
        JSONObject boardConfig = (JSONObject) config.get("boardConfig");
        if(boardConfig.get("jailTileIndex") != null){
            int jailTileIndex = ((Long) boardConfig.get("jailTileIndex")).intValue();
            board.setJailTileIndex(jailTileIndex);
        }

        // set salary
        if(boardConfig.get("salary") != null){
            int salary = ((Long) boardConfig.get("salary")).intValue();
            board.setSalary(salary);
        }

        // set board name.
        String boardName = (String) boardConfig.get("boardName");
        board.setBoardName(boardName);
        return null;
    }
}
