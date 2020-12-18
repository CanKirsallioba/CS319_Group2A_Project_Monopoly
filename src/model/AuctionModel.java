package model;

import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;
import java.util.Observable;

public class AuctionModel extends Observable {
    boolean active;
    Player player;
    int highestBid;

    AuctionModel() {
        active = false;
    }

    public void startAuction(ArrayList<TitleDeedCard> titleDeedCards) {
        active = true;
    }

    public void bid(Player player) {
        // todo check if has enough money.

        setChanged();
        notifyObservers();
    }

    public void endAuction() {
        active = false;
        if (player == null) {

        } else {

        }
        setChanged();
        notifyObservers();
    }
}
