package com.monopoly.model.tiles.card;

import com.monopoly.model.tiles.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable {
    String instruction;
    ArrayList<Action> actions;

    String type;

    public Card(ArrayList<Action> actions, String instruction, String type) {
        this.actions = actions;
        this.instruction = instruction;
        this.type = type;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
