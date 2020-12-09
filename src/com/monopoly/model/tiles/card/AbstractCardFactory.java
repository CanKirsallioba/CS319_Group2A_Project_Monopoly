package com.monopoly.model.tiles.card;

public abstract class AbstractCardFactory {
    public AbstractCardFactory() {
    }

    public abstract Card createCard(String cardType);
}
