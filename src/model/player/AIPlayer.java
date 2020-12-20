package model.player;

import model.TradeModel;
import model.player.strategy.AIStrategy;
import model.tiles.*;
import model.tiles.property.TitleDeedCard;
import org.omg.Messaging.SyncScopeHelper;

import java.sql.SQLOutput;
import java.util.Observable;
import java.util.Observer;
import model.tiles.GameAction;

import static model.tiles.GameActionConstants.DOWNGRADE_PROPERTY_ACTION;
import static model.tiles.GameActionConstants.MORTGAGE_PROPERTY_ACTION;

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
        System.out.println("MODEL 3" + tradeModel);
        aiStrategy.makeAndExecuteTradeDecision( this, tradeModel);
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
        updatePlayerWorth();
        setChanged();
        notifyObservers();
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
                            setSelectedTitleDeed( titleDeedCard);
                            aiStrategy.getGameAction(titleDeedCard.getPropertyActions(), DOWNGRADE_PROPERTY_ACTION).execute();
                            setSelectedTitleDeed(null);
                            getCurrentTile().getPossibleActions(this);
                        }
                    }
                    if( getBalance() < (getPlayerToken().getBoard().getBoardSalary() / 4)){
                        for(TitleDeedCard titleDeedCard: getTitleDeeds()){
                            if( titleDeedCard.isMortgaged() == false && getBalance() < (getPlayerToken().getBoard().getBoardSalary() /4)){

                                setSelectedTitleDeed( titleDeedCard);
                                aiStrategy.getGameAction(titleDeedCard.getPropertyActions(), MORTGAGE_PROPERTY_ACTION).execute();
                                setSelectedTitleDeed(null);
                                getCurrentTile().getPossibleActions(this);
                                // player.setSelectedTitleDeed( currentPropertyTile.getTitleDeedCard());
                            }
                        }
                    }
                    if( getBalance() < (getPlayerToken().getBoard().getBoardSalary() / 4)){
                        setGetOutOfJailChoice(BailOutChoice.DOUBLE_DICE);
                    }
                    else{
                        setGetOutOfJailChoice(BailOutChoice.MONEY);
                    }
                }
            }
            if( isInJail() == false){
                moveToken(playersDice.getDiceResultSum());
            }
        }
        // if player is not in jail, plays turn normally
        else{
            rollDice();
            if( getConsecutiveDoubleCount() == 3){
                goToJail();
                setChanged();
                notifyObservers();
            }

            // if the AI player did not throw 3 double dice
            else {
                moveToken( playersDice.getDiceResultSum());
                setChanged();
                notifyObservers();
                Tile currentlyLandedTile = getCurrentTile();
                if( currentlyLandedTile instanceof PropertyTile){
                    setSelectedTitleDeed(((PropertyTile) currentlyLandedTile).getTitleDeedCard());
                    makeAndExecutePropertyDecision();
                    setCurrentlyDrawnCard(null);
                } else {
                    setSelectedTitleDeed(null);
                }
                setChanged();
                notifyObservers();
                if( currentlyLandedTile instanceof CardTile){
                    makeAndExecuteCardDecision();
                }
                else {
                    setCurrentlyDrawnCard(null);
                }
                setChanged();
                notifyObservers();
                if( currentlyLandedTile instanceof IncomeTaxTile){
                        makeAndExecuteIncomeTaxDecision();
                }
                if( currentlyLandedTile instanceof TeleportTile){
                    getCurrentTile().getPossibleActions(this).get(0).execute();
                    setChanged();
                    notifyObservers();
                }
                if( currentlyLandedTile instanceof GoToJailTile){
                    goToJail();
                }

                // if not on a tile that requires a specific action, do not do anything
            }

        }
        aiStrategy.liftMortgages( this);
        updatePlayerWorth();
        setChanged();
        notifyObservers();
    }

    /**
     * Is used for determining whether this player is an AIPlayer or HumanPlayer. In AIPlayer, always returns true.
     * @return true
     */
    @Override
    public boolean isAIControlled() {
        return true;
    }

    /**
     * Getter method for aiStrategy.
     * @return aiStrategy
     */
    public AIStrategy getAiStrategy() {
        return aiStrategy;
    }

    /**
     * Setter method for aiStrategy
     * @param aiStrategy is the new aiStrategy
     */
    public void setAiStrategy(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }

    /**
     * Updates AIPlayer's tradeModel.
     * @param o is tradeModel
     * @param arg is not used
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TradeModel) {
            TradeModel model = (TradeModel) o;
            if (model.getPlayer2() == this) {
                setTradeModel(model);
                makeAndExecuteTradeDecision();
            }
        }
    }
}
