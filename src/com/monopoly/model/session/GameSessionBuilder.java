package com.monopoly.model.session;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.ConfigPlaceHolder;

public class GameSessionBuilder {
    BoardConfiguration boardConfiguration;
    ConfigPlaceHolder configPlaceHolder;

    public BoardConfiguration getBoardConfiguration() {
        return boardConfiguration;
    }

    public void setBoardConfiguration(BoardConfiguration boardConfiguration) {
        this.boardConfiguration = boardConfiguration;
    }

    public ConfigPlaceHolder getConfigPlaceHolder() {
        return configPlaceHolder;
    }

    public void setConfigPlaceHolder(ConfigPlaceHolder configPlaceHolder) {
        this.configPlaceHolder = configPlaceHolder;
    }

    GameSessionBuilder(BoardConfiguration boardConfiguration, ConfigPlaceHolder configPlaceHolder) {

    }
    public void build() {

    }
}
