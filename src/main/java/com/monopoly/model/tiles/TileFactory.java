package com.monopoly.model.tiles;

import com.monopoly.model.tiles.card.*;
import com.monopoly.model.tiles.property.Color;
import com.monopoly.model.tiles.property.ColorGroup;
import com.monopoly.model.tiles.property.TitleDeedCard;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class TileFactory extends AbstractTileFactory {

    public Tile getTile(JSONObject config) {
        String tileType = (String) config.get("tileType");

        int tileIndex = ((Long) config.get("tileIndex")).intValue();
        if (tileType.equals("PropertyTile")) {
            PropertyTile propertyTile = new PropertyTile();
            propertyTile.setTileName( tileType);
            propertyTile.setIndex( tileIndex);
            ArrayList<Tile> group = new ArrayList<>();
            TitleDeedCard deedCard = new TitleDeedCard();
            ColorGroup colorGroup = new ColorGroup( group);

            String propertyName = (String) config.get("tileName");
            deedCard.setPropertyName( propertyName);

            String colorGroupName = (String) config.get("associatedColorGroup");
            colorGroupName = colorGroupName.toUpperCase();
            colorGroup.setColor( Color.valueOf(colorGroupName));
            deedCard.setColorGroup( colorGroup);

            int price, upgradeCost, rentLevel0, rentLevel1, rentLevel2, rentLevel3, rentLevel4, rentLevel5, mortgageValue;

            if(config.get("price") != null){
                price = ((Long) config.get("price")).intValue();
                deedCard.setPropertyValue( price);
            }
            if( config.get("upgradeCost") != null){
                upgradeCost = ((Long) config.get("upgradeCost")).intValue();
                deedCard.setUpgradeCost( upgradeCost);
            }
            if( config.get("rentLevel0") != null){
                rentLevel0 = ((Long) config.get("rentLevel0")).intValue();
                deedCard.setLevelZeroRent( rentLevel0);
            }
            if( config.get("rentLevel1") != null){
                rentLevel1 = ((Long) config.get("rentLevel1")).intValue();
                deedCard.setLevelOneRent( rentLevel1);
            }
            if( config.get("rentLevel2") != null){
                rentLevel2 = ((Long) config.get("rentLevel2")).intValue();
                deedCard.setLevelTwoRent( rentLevel2);
            }
            if( config.get("rentLevel3") != null){
                rentLevel3 = ((Long) config.get("rentLevel3")).intValue();
                deedCard.setLevelThreeRent( rentLevel3);
            }
            if( config.get("rentLevel4") != null){
                rentLevel4 = ((Long) config.get("rentLevel4")).intValue();
                deedCard.setLevelFourRent( rentLevel4);
            }
            if( config.get("rentLevel5") != null){
                rentLevel5 = ((Long) config.get("rentLevel5")).intValue();
                deedCard.setLevelFiveRent( rentLevel5);
            }
            if( config.get("mortgageValue") != null) {
                mortgageValue = ((Long) config.get("mortgageValue")).intValue();
                deedCard.setMortgageValue( mortgageValue);
            }

            propertyTile.setTitleDeedCard( deedCard);
            return propertyTile;

        } else if (tileType.equals("CardTile")) {
            String associatedDeck = (String) config.get("associatedDeck");
            CardTile cardTile = new CardTile();
            cardTile.setTileName( tileType);
            cardTile.setIndex( tileIndex);
            CardDeckBuilder deckBuilder = new CardDeckBuilder();
            if (associatedDeck.equals("ChanceCardDeck")) {
                ChanceCardDeck chance = (ChanceCardDeck) deckBuilder.build(config);
                cardTile.setCardDeck( chance);
                return cardTile;
            } else if (associatedDeck.equals("CommunityChestCardDeck")) {
                CommunityChestCardDeck communityChestCardDeck = (CommunityChestCardDeck) deckBuilder.build(config);
                cardTile.setCardDeck( communityChestCardDeck);
                return cardTile;
            } else {
                throw new RuntimeException("Wrong card deck type in configuration file!!");
            }
        } else if (tileType.equals("IncomeTaxTile")) {
            //?? unsure about redundancy
            int fixedTax, percentageTax;
            IncomeTaxTile taxTile = new IncomeTaxTile();
            taxTile.setTileName( tileType);
            taxTile.setIndex( tileIndex);
            if( config.get("fixedTax") != null) {
                fixedTax = ((Long) config.get("fixedTax")).intValue();
            }
            if(config.get("percentageTax") != null) {
                percentageTax = ((Long) config.get("percentageTax")).intValue();
            }
            return taxTile;
        } else if (tileType.equals("TeleportTile")) {
            int counterTile;
            TeleportTile teleportTile = new TeleportTile();
            teleportTile.setTileName( tileType);
            teleportTile.setIndex( tileIndex);
            if(config.get("counterTile") != null) {
                counterTile = ((Long) config.get("counterTile")).intValue();
                teleportTile.setCounterpartIndex( counterTile);
            }
            return teleportTile;
        } else if (tileType.equals("GoTile")) {
            GoTile goTile = new GoTile();
            goTile.setTileName( tileType);
            goTile.setIndex( tileIndex);

            return goTile;

        } else if (tileType.equals("JailTile")) {
            JailTile jailTile = new JailTile();
            jailTile.setTileName( tileType);
            jailTile.setIndex( tileIndex);

            return jailTile;

        }else if (tileType.equals("GoToJailTile")) {
            GoToJailTile goToJailTile = new GoToJailTile();
            goToJailTile.setTileName( tileType);
            goToJailTile.setIndex( tileIndex);
            return goToJailTile;

        } else {
            throw new RuntimeException("Wrong Tile");
        }
    }
}
