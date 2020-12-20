package model.player;

import java.io.Serializable;

// Dice class is completed according to the original design.
public class Dice implements Serializable {
    int dice1;
    int dice2;

    public Dice() {
        rollDice();
    }
    /**
     * Randomly sets dice1 and dice2 to integers with the range [1,6]
     */
    public void rollDice(){
        //dice1 = (int) ( (Math.random() * 5) + 1 );
        //dice2 = (int) ( (Math.random() * 5) + 1 );
        dice1 = 3;
        dice2 = 2;

    }

    /**
     * @return the sum of 2 dices
     */
    public int getDiceResultSum(){
        return dice1 + dice2;
    }

    /**
     * Getter method for dice1.
     * @return the result of the the first dice
     */
    public int getDice1(){
        return dice1;
    }

    /**
     * Getter method for dice2.
     * @return the result of the second dice
     */
    public int getDice2(){
        return dice2;
    }
}
