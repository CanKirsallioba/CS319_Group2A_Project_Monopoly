package model.player;


public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(){
        setChanged();
        notifyObservers();
        System.out.println("IN players ");
    }

    /**
     * playTurn method for the human player, which does the standard and mandorty things each player must do
     * if they are not in jail
     */
    @Override
    public void playTurn(){
        this.getOutOfJailChoice = BailOutChoice.WAIT;

        if(!isInJail()){
            rollDice();
            if( getConsecutiveDoubleCount() == 3){
                goToJail();
            }
            moveToken( playersDice.getDiceResultSum());
        }
        updatePlayerWorth();
        setChanged();
        notifyObservers();
        System.out.println(toString());
    }
}
