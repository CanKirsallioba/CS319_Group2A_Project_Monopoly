package model;

import model.player.Player;
import model.tiles.property.TitleDeedCard;

import java.util.ArrayList;
import java.util.Observable;

public class AuctionModel extends Observable {

    boolean active;
    Player highestBiddingPlayer;
    int highestBid;
    int remainingTime;
    ArrayList<TitleDeedCard> auctionedTitleDeeds;

    AuctionModel() {
        active = true;
        highestBid = 0;
        remainingTime = 60;
        highestBiddingPlayer = null;
        auctionedTitleDeeds = null;
    }

    public void startAuction(ArrayList<TitleDeedCard> titleDeedCards) {
        auctionedTitleDeeds = titleDeedCards;
        active = true;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Player getHighestBiddingPlayer() {
        return highestBiddingPlayer;
    }

    public void setHighestBiddingPlayer(Player highestBiddingPlayer) {
        this.highestBiddingPlayer = highestBiddingPlayer;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(int highestBid) {
        this.highestBid = highestBid;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void bid(Player player) {
        // todo check if has enough money.

        setChanged();
        notifyObservers();
    }

    public void endAuction() {
        active = false;
        if (highestBiddingPlayer == null) {

        } else {

        }
        setChanged();
        notifyObservers();
    }

    public ArrayList<TitleDeedCard> getAuctionedTitleDeeds() {
        return auctionedTitleDeeds;
    }

    public void setAuctionedTitleDeeds(ArrayList<TitleDeedCard> auctionedTitleDeeds) {
        this.auctionedTitleDeeds = auctionedTitleDeeds;
        setChanged();
        notifyObservers();
    }
}
