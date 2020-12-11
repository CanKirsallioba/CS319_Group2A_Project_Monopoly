package com.monopoly.model;

import com.monopoly.model.player.AICharacteristic;

import java.util.Observable;

public class BoardConfiguration extends Observable {
    GamePace gamePace;
    int maxPlayerCount;
    int humanPlayerCount;

    AICharacteristic aiCharacteristic;


    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public void setMaxPlayerCount(int maxPlayerCount) {
        this.maxPlayerCount = maxPlayerCount;
    }

    public int getHumanPlayerCount() {
        return humanPlayerCount;
    }

    public void setHumanPlayerCount(int humanPlayerCount) {
        this.humanPlayerCount = humanPlayerCount;
    }

    public AICharacteristic getAiCharacteristic() {
        return aiCharacteristic;
    }

    public void setAiCharacteristic(AICharacteristic aiCharacteristic) {
        this.aiCharacteristic = aiCharacteristic;
    }

    public GamePace getGamePace() {
        return gamePace;
    }

    public void setGamePace(GamePace gamePace) {
        this.gamePace = gamePace;
    }
}
