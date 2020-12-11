package com.monopoly.model.player;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.ConfigAdapter;

import java.util.ArrayList;

public class PlayerFactory extends AbstractPlayerFactory {

    public PlayerFactory() {
    }

    @Override
    public ArrayList<Player> get(BoardConfiguration boardConfiguration, ConfigAdapter configPlaceHolder) {
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
