package model.tiles.property;

import model.player.Player;
import model.tiles.PropertyTile;
import model.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;

public class ColorGroup implements Serializable {
    ArrayList<Tile> group;
    Color color;

    /**
     * Constructor for the color group
     * @param group is the list of the group with the same color of tiles.
     */
    public ColorGroup(ArrayList<Tile> group) {
        this.group = group;
    }

    /**
     * Getter method for the list of the tiles.
     * @return a list of the group of tiles.
     */
    public ArrayList<Tile> getGroup() {
        return group;
    }

    /**
     * Setter method for the group of tiles.
     * @param group is the list of the group with the same color of tiles.
     */
    public void setGroup(ArrayList<Tile> group) {
        this.group = group;
    }

    /**
     * This method checks whether the specified player owns all properties in this color group
     * @param player is the player that the inquiry will be done on.
     * @return a boolean value that is if the player owns all the tiles in that color group
     */
    public boolean allOwnedByPlayer(Player player){

        //group is empty - bug
        for(Tile tile: group)
        {
            if(((PropertyTile) tile).getTitleDeedCard().getOwner() != player){
                return false;
            }
        }

        return true;
    }

    /**
     * Getter method for the color attribute.
     * @return color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Setter method for the color attribute
     * @param color is the color of the tiles.
     */
    public void setColor( Color color){
        this.color = color;
    }
}
