package com.monopoly.model.tiles;

import org.json.simple.JSONObject;

public class TileFactory extends AbstractTileFactory {

    public Tile getTile(JSONObject config) {
        String tileType;
        int tileIndex;
        if (tileType.equals("PropertyTile")) {
            String propertyName;
            String colorGroup;
            int price, upgradeCost, rentLevel0, rentLevel1, rentLevel2, rentLevel3, rentLevel4, rentLevel5, mortgageValue;

        } else if (tileType.equals("CardTile")) {
            String associatedDeck="";
            if (associatedDeck.equals("ChanceCardDeck")) {

            } else if ("CommunityChestCardDeck") {

            } else {
                throw new RuntimeException("Wrong card deck type in configuration file!!");
            }
        } else if (tileType.equals("IncomeTaxTile")) {

        } else if (tileType.equals("TeleportTile")) {
            int counterpartIndex;

        } else if (tileType.equals("GoTile")) {

        } else if (tileType.equals("JailTile")) {

        } else {
            throw new RuntimeException("Wrong Tile");
        }
        return null;
    }

}
