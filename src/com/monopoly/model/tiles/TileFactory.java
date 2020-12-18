package com.monopoly.model.tiles;

import org.json.simple.JSONObject;

public class TileFactory extends AbstractTileFactory {

    public Tile getTile(JSONObject config) {
        String tileType = (String) config.get("tileType");
        int tileIndex = ((Long) config.get("tileIndex")).intValue();
        if (tileType.equals("PropertyTile")) {
            String propertyName = (String) config.get("tileName");
            String colorGroup = (String) config.get("associatedColorGroup");
            int price, upgradeCost, rentLevel0, rentLevel1, rentLevel2, rentLevel3, rentLevel4, rentLevel5, mortgageValue;

            if(config.get("price") != null){
                price = ((Long) config.get("price")).intValue();
            }
            if( config.get("upgradeCost") != null){
                upgradeCost = ((Long) config.get("upgradeCost")).intValue();
            }
            if( config.get("rentLevel0") != null){
                rentLevel0 = ((Long) config.get("rentLevel0")).intValue();
            }
            if( config.get("rentLevel1") != null){
                rentLevel1 = ((Long) config.get("rentLevel1")).intValue();
            }
            if( config.get("rentLevel2") != null){
                rentLevel2 = ((Long) config.get("rentLevel2")).intValue();
            }
            if( config.get("rentLevel3") != null){
                rentLevel3 = ((Long) config.get("rentLevel3")).intValue();
            }
            if( config.get("rentLevel4") != null){
                rentLevel4 = ((Long) config.get("rentLevel4")).intValue();
            }
            if( config.get("rentLevel5") != null){
                rentLevel5 = ((Long) config.get("rentLevel5")).intValue();
            }
            if( config.get("mortgageValue") != null) {
                mortgageValue = ((Long) config.get("mortgageValue")).intValue();
            }
        } else if (tileType.equals("CardTile")) {
            String associatedDeck = (String) config.get("associatedDeck");
            if (associatedDeck.equals("ChanceCardDeck")) {

            } else if (associatedDeck.equals("CommunityChestCardDeck")) {

            } else {
                throw new RuntimeException("Wrong card deck type in configuration file!!");
            }
        } else if (tileType.equals("IncomeTaxTile")) {
            //?? unsure about redundancy
            int fixedTax, percentageTax;
            if( config.get("fixedTax") != null) {
                fixedTax = ((Long) config.get("fixedTax")).intValue();
            }
            if(config.get("percentageTax") != null) {
                percentageTax = ((Long) config.get("percentageTax")).intValue();
            }
        } else if (tileType.equals("TeleportTile")) {
            int counterTile;
            if(config.get("counterTile") != null) {
                counterTile = ((Long) config.get("counterTile")).intValue();
            }
        } else if (tileType.equals("GoTile")) {

        } else if (tileType.equals("JailTile")) {

        }else if (tileType.equals("GoToJailTile")) {

        } else {
            throw new RuntimeException("Wrong Tile");
        }
        // TODO how will tile be created here to return so
        return null;
    }
}
