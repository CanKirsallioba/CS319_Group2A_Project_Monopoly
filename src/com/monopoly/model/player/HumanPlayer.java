package com.monopoly.model.player;


public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(){ }

    /**
     * playTurn method for the human player, which does the standard and mandorty things each player must do
     * if they are not in jail
     */
    @Override
    public void playTurn(){
        if( isInJail() == false){
            rollDice();
            if( getConsecutiveDoubleCount() == 3){
                goToJail();
            }
            moveToken( playersDice.getDiceResultSum());
        }
    }
}
