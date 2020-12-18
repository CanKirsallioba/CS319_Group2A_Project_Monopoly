package com.monopoly.model.tiles.property;

import com.monopoly.model.player.Player;
import com.monopoly.model.tiles.PropertyTile;
import com.monopoly.model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;

public class ColorGroup implements Serializable {
    ArrayList<Tile> group;
    Color color;

    public ColorGroup(ArrayList<Tile> group) {
        this.group = group;
    }

    public ArrayList<Player> getGroup() {
        return null;
    }

    public void setGroup(ArrayList<Tile> group) {
        this.group = group;
    }

    //this method checks whether the specified player owns all properties in this color group
    public boolean allOwnedByPlayer(Player player){
        for(int i = 0; i < group.size(); i++)
        {
            if(((PropertyTile)group.get(i)).getTitleDeedCard().getOwner() != player){
                return false;
            }
        }
        return true;
    }

    public Color getColor(){
        return color;
    }

    public void setColor( Color color){
        this.color = color;
    }
}
