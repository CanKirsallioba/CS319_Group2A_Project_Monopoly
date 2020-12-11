package com.monopoly.model.session;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.ConfigAdapter;
import jdk.nashorn.internal.parser.JSONParser;

public class GameSessionBuilder {
    BoardConfiguration boardConfiguration;
    ConfigAdapter configPlaceHolder;

    public BoardConfiguration getBoardConfiguration() {
        return boardConfiguration;
    }

    public void setBoardConfiguration(BoardConfiguration boardConfiguration) {
        this.boardConfiguration = boardConfiguration;
    }

    public ConfigAdapter getConfigPlaceHolder() {
        return configPlaceHolder;
    }

    public void setConfigPlaceHolder(ConfigAdapter configPlaceHolder) {
        this.configPlaceHolder = configPlaceHolder;
    }

    GameSessionBuilder(BoardConfiguration boardConfiguration, ConfigAdapter configPlaceHolder) {

    }
    public void build() {

    }
}
