package com.monopoly;

import com.monopoly.model.board.Dice;
import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.Tile;
import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.property.TitleDeedCard;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Start");
	// write your code here
        Player player = new Player() {
            @Override
            public Dice rollDice() {
                return null;
            }

            @Override
            public boolean waitInJail() {
                return false; // placeholder
            }

            @Override
            public void checkBailOut() {

            }

            @Override
            public void addBailOutFromJailCard(Card card) {

            }

            @Override
            public void removeBailOutFromJailCard() {

            }

            @Override
            public void moveToken(int amount) {

            }

            @Override
            public void goToJail() {

            }

            @Override
            public void addTitleDeedCard(TitleDeedCard card) {

            }

            @Override
            public void removeTitleDeedCard(TitleDeedCard card) {

            }

            @Override
            public void changeBalance(int amount) {

            }

            @Override
            public void declareBankruptcy() {

            }

            @Override
            public int getCurrentTileIndex() {
                return 0;
            }

            @Override
            public int getTaxOption() {
                return 0;
            }

            @Override
            public void setTaxOption( int i) {

            }

            @Override
            public int getBalance() {
                return 0;
            }

            @Override
            public int getConsecutiveDoubleCount() {
                return 0;
            }

            @Override
            public String getTokenType() {
                return null;
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        Tile tile = createTile();
        System.out.println(tile.name);
//        Command[] c = tile.getPossibleActions(player);
//        System.out.println(c[0]);

    }
    public static PropertyTile createTile() {
        return new PropertyTile();
    }
}
