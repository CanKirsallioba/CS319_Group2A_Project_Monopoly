package com.monopoly.model.player;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.ConfigPlaceHolder;

import java.util.ArrayList;

public class PlayerFactory extends AbstractPlayerFactory {

    public PlayerFactory() {
    }

    @Override
    public ArrayList<Player> get(BoardConfiguration boardConfiguration, ConfigPlaceHolder configPlaceHolder) {
        return null;
    }

    @Override
    public Player createAIPLayer(int balance, AICharacteristic aiCharacteristic, String playerTokenType) {
        return null;
    }

    @Override
    public Player createHumanPLayer(int balance, String playerTokenType) {
        return null;
    }
}
