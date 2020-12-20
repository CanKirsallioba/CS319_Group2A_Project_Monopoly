package model;

import model.player.AICharacteristic;

import java.io.Serializable;
import java.util.Observable;

/**
 *
 */
public class BoardConfiguration extends Observable implements Serializable {
    GamePace gamePace;
    int maxPlayerCount;
    int humanPlayerCount;

    AICharacteristic aiCharacteristic;

    /**
     *
     * @return player count
     */
    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    /**
     *
     * @param maxPlayerCount max player count
     */
    public void setMaxPlayerCount(int maxPlayerCount) {
        this.maxPlayerCount = maxPlayerCount;
    }

    /**
     *
     * @return human player count
     */
    public int getHumanPlayerCount() {
        return humanPlayerCount;
    }

    /**
     *
     * @param humanPlayerCount human player count
     */
    public void setHumanPlayerCount(int humanPlayerCount) {
        this.humanPlayerCount = humanPlayerCount;
    }

    /**
     *
     * @return
     */
    public AICharacteristic getAiCharacteristic() {
        return aiCharacteristic;
    }

    /**
     *
     * @param aiCharacteristic
     */
    public void setAiCharacteristic(AICharacteristic aiCharacteristic) {
        this.aiCharacteristic = aiCharacteristic;
    }

    /**
     *
     * @return game's pace
     */
    public GamePace getGamePace() {
        return gamePace;
    }

    /**
     *
     * @param gamePace game pace
     */
    public void setGamePace(GamePace gamePace) {
        this.gamePace = gamePace;
    }
}
