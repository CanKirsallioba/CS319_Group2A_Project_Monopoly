package com.monopoly.model.player;

import com.monopoly.model.tiles.card.Card;
import com.monopoly.model.tiles.property.TitleDeedCard;

import java.util.ArrayList;

public abstract class AbstractPlayer implements Player {
    private int taxOption;
    private ArrayList<TitleDeedCard> titleDeeds;
    private ArrayList<Card> cards;
    private int balance;
    private boolean bankrupt;
    private int consecutiveDoubleCount;

    AbstractPlayer( ) {

    }
    public void setTaxOption(int taxOption) {
        this.taxOption = taxOption;
    }

    public ArrayList<TitleDeedCard> getTitleDeeds() {
        return titleDeeds;
    }

    public void setTitleDeeds(ArrayList<TitleDeedCard> titleDeeds) {
        this.titleDeeds = titleDeeds;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public void setConsecutiveDoubleCount(int consecutiveDoubleCount) {
        this.consecutiveDoubleCount = consecutiveDoubleCount;
    }


    @Override
    public void waitInJail() {

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
    public int setTaxOption() {
        return 0;
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
}
