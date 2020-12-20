package model.board;

import model.BoardConfiguration;
import model.tiles.PropertyTile;
import model.tiles.Tile;
import model.tiles.TileFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Board factory responsible for creating and initializing boards.
 */
public class BoardFactory {

    /**
     * Creates and initializes a board according to the user input and configuration file.
     * @param boardConfiguration is the user input for initializing the board.
     * @param config is the configuration file.
     * @return the initialized board.
     */
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

        // associate the color groups
        ArrayList<Tile> colorGroupOfTile = new ArrayList<>();
        for( Tile tileCheck : tiles ) {
            if (tileCheck instanceof PropertyTile) {
                for (Tile tileInstance : tiles) {
                    if (tileInstance instanceof PropertyTile) {
                        if (((PropertyTile) tileCheck).getTitleDeedCard().getColorGroup().getColor() == ((PropertyTile) tileInstance).getTitleDeedCard().getColorGroup().getColor()
                            && tileCheck.getIndex() != tileInstance.getIndex()){
                            colorGroupOfTile.add(tileInstance);
                        }
                    }
                }
                ((PropertyTile) tileCheck).getTitleDeedCard().getColorGroup().setGroup( colorGroupOfTile);
                colorGroupOfTile = new ArrayList<>();


            }
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
            board.setBoardSalary(salary);
        }

        // set board name.
        String boardName = (String) boardConfig.get("boardName");
        board.setBoardName(boardName);

        return board;
    }
}
