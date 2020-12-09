package com.monopoly.model.tiles.card;

import com.monopoly.model.tiles.actionStrategy.ActionStrategy;

import java.io.Serializable;

public class Card implements Serializable {
    ActionStrategy strategy;
    String instruction;
    String type;

    public Card(ActionStrategy strategy, String instruction, String type) {
        this.strategy = strategy;
        this.instruction = instruction;
        this.type = type;
    }

    public ActionStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ActionStrategy strategy) {
        this.strategy = strategy;
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
