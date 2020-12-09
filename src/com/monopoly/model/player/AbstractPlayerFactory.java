package com.monopoly.model.player;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.ConfigPlaceHolder;

import java.util.ArrayList;

public abstract class AbstractPlayerFactory {
    public abstract ArrayList<Player> get(BoardConfiguration boardConfiguration, ConfigPlaceHolder configPlaceHolder);
    public abstract Player createAIPLayer(int balance, AICharacteristic aiCharacteristic, String playerTokenType);
    public abstract Player createHumanPLayer(int balance, String playerTokenType);
}
