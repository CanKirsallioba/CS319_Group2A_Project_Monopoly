package com.monopoly.model.board;

import com.monopoly.model.BoardConfiguration;
import com.monopoly.model.ConfigAdapter;
import com.monopoly.model.tiles.AbstractTileFactory;

public abstract class AbstractBoardFactory {
    AbstractTileFactory abstractTileFactory;
    public abstract Board get(BoardConfiguration boardConfiguration, ConfigAdapter configPlaceHolder);
}
