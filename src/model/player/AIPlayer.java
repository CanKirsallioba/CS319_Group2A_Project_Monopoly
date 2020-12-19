package model.player;

import model.player.strategy.AIStrategy;
import model.tiles.*;
import model.tiles.property.TitleDeedCard;
import org.omg.Messaging.SyncScopeHelper;

import java.sql.SQLOutput;
import java.util.Observable;
import java.util.Observer;

public class AIPlayer extends AbstractPlayer implements Observer {
    AIStrategy aiStrategy;

    /**
     * Default constructor for AIPlayer
     * @param aiStrategy used for decisionmaking in certain situations
     */
    public AIPlayer(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }

    /**
     * Makes a decision and executes it according to its strategy. Is invoked when player lands on a PropertyTile.
     */
    void makeAndExecutePropertyDecision(){
        aiStrategy.makeAndExecutePropertyDecision( this);
    }

    /**
     * Makes a decision and executes it according to its strategy. Is invoked when player lands on a IncomeTaxTile.
     */
    void makeAndExecuteIncomeTaxDecision(){
        aiStrategy.makeAndExecuteIncomeTaxDecision(this);
    }

    /**
     * Makes a decision and executes it according to its strategy. Is invoked when player lands on a CardTile.
     */
    void makeAndExecuteCardDecision(){
        aiStrategy.makeAndExecuteCardDecision( this);
    }

    /**
     * Makes a decision  to accept or reject a trade offer and executes that decision according to its strategy.
     * Is invoked when player is made a trade offer.
     */
    void makeAndExecuteTradeDecision(){
        aiStrategy.makeAndExecuteTradeDecision( this);
    }

    /**
     * Makes and executes a decision  to bid or not bid to an auction at its given state according to its strategy.
     * Is invoked when player is involved in an auction.
     */
    void makeAndExecuteAuctionDecision(){
        aiStrategy.makeAndExecuteAuctionDecision( this);
    }

    /**
     * Plays the turn for an AI Player.
     */
    @Override
    public void playTurn(){
        System.out.println("debug: AIPlayer: playTurn chkpt--1\n" + this.toString() );
        updatePlayerWorth();
        // if player is in jail, tries to bail out of jail
        if( isInJail()){
            if( getBailOutOfJailCards().size() > 0){
                setGetOutOfJailChoice(BailOutChoice.BAIL_OUT_CARD);
            }
            else if( liquidTotalWorth < getPlayerToken().getBoard().getBoardSalary() / 4){
                setGetOutOfJailChoice(BailOutChoice.DOUBLE_DICE);
            }
            else{
                if( getBalance() >= (getPlayerToken().getBoard().getBoardSalary() / 4) ){
                    setGetOutOfJailChoice(BailOutChoice.MONEY);
                }
                else{
                    for(TitleDeedCard titleDeedCard: getTitleDeeds()){
                        if( titleDeedCard.getUpgradeLevel() > 1 && titleDeedCard.isDowngradeable() && getBalance() < (getPlayerToken().getBoard().getBoardSalary() / 4)){
                            titleDeedCard.downgrade();
                        }
                    }
                    if( getBalance() < (getPlayerToken().getBoard().getBoardSalary() / 4)){
                        for(TitleDeedCard titleDeedCard: getTitleDeeds()){
                            if( titleDeedCard.isMortgaged() == false && getBalance() < (getPlayerToken().getBoard().getBoardSalary() /4)){
                                titleDeedCard.mortgage();
                            }
                        }
                    }
                    if( getBalance() < (getPlayerToken().getBoard().getBoardSalary() / 4)){
                        System.out.println( "ERROR: Calculations incorrect!");
                        setGetOutOfJailChoice(BailOutChoice.DOUBLE_DICE);
                    }
                    else{
                        setGetOutOfJailChoice(BailOutChoice.MONEY);
                    }
                }
            }
        }
        // if player is not in jail, plays turn normally
        else{
            rollDice();
            if( getConsecutiveDoubleCount() == 3){
                goToJail();
            }
            // if the AI player did not throw 3 double dice
            else {
                moveToken( playersDice.getDiceResultSum());
                Tile currentlyLandedTile = getCurrentTile();
                if( currentlyLandedTile instanceof PropertyTile){
//                    setSelectedTitleDeed(((ile) currentlyLandedTile).getTitleDeedCard());
                    makeAndExecutePropertyDecision();
                }
                else if( currentlyLandedTile instanceof CardTile){
                    makeAndExecuteCardDecision();
                }
                else if( currentlyLandedTile instanceof IncomeTaxTile){
                    makeAndExecuteIncomeTaxDecision();
                }
                // if not on a tile that requires a specific action, do not do anything
            }
        }
        updatePlayerWorth();

        System.out.println("debug: AIPlayer: playTurn chkpt--2 \n" + this.toString() );

    }

    public AIStrategy getAiStrategy() {
        return aiStrategy;
    }

    public void setAiStrategy(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }


    @Override
    public void update(Observable o, Object arg) {
        // todo AuctionModel and trade...
    }
}
