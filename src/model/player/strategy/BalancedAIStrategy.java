package model.player.strategy;

import model.AuctionModel;
import model.TradeModel;
import model.player.AIPlayer;
import model.player.TaxOption;
import model.tiles.IncomeTaxTile;
import model.tiles.PropertyTile;
import model.tiles.card.Card;
import model.tiles.property.TitleDeedCard;
import model.tiles.GameAction;

import java.util.ArrayList;

import static model.tiles.GameActionConstants.*;

/**
 * Strategy for the balanced AI.
 * For the most part, behaves like what a rational person would behave.
 * Tries to avoid situations that it would be in danger of bankruptcy, and tries to accumulate properties when it makes sense.
 */
public class BalancedAIStrategy extends AIStrategy {

    /**
     *  Is invoked when the player lands on a PropertyTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing balanced, so the AI player makes rational decisions.
     *  If it fits the AI's conditions, i.e. does not leave him in danger of bankruptcy, he buys the property.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecutePropertyDecision(AIPlayer player) {
        System.out.println( "Balanced AI Strategy: Property Decision");
        PropertyTile currentPropertyTile = (PropertyTile) player.getCurrentTile();

        // decision path for owned property
        if (currentPropertyTile.getTitleDeedCard().isOwned()){
            if ( currentPropertyTile.getTitleDeedCard().getOwner() != player ) {
                System.out.println( "Balanced AI Strategy: Paying Rent");

                // if the player cannot pay the rent even if he/she sold everything of value, declare bankruptcy
                if (player.getLiquidTotalWorth() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                    // todo remove debug println
                    System.out.println( "Balanced AI Strategy: No money to pay, no property to mortgage");
                    System.out.println( "No woman no cry -- Bankruptcy");

                    player.declareBankruptcy();
                }
                // if player can pay the rent, pay the rent
                else {
                    System.out.println( "Balanced AI Owned Property: Owner Some1 else");

                    // if player does not have the balance to pay rent &&
                    // but liquid total worth > rent
                    // mortgage & downgrade to pay rent
                    if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()
                            && player.getLiquidTotalWorth() >= currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                        System.out.println( "Player cannot payRent, but has liquid assets");
                        System.out.println( "AXBBC191-P1");
                        for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {
                            System.out.println( "Attempting to downgrade 2 pay");

                            if (titleDeedCard.getUpgradeLevel() >= 1 && titleDeedCard.isDowngradeable()
                                    && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {

                                player.setSelectedTitleDeed( titleDeedCard);
                                getGameAction(titleDeedCard.getPropertyActions(), DOWNGRADE_PROPERTY_ACTION).execute();
                                player.setSelectedTitleDeed(null);
                                currentPropertyTile.getPossibleActions(player);
                            }
                        }
                        if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                            for (TitleDeedCard titleDeedCard : player.getTitleDeeds()) {
                                System.out.println( "Attempting 2 mortgage pay");


                                if (titleDeedCard.isMortgaged () == false
                                        && player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                                    System.out.println( "Mortgaging property");
                                    System.out.println( "Balance b4 mortgage:" + player.getBalance());
                                    System.out.println( "Property & Mortgaged: " + titleDeedCard.getPropertyName() + " & " + titleDeedCard.isMortgaged());
                                    player.setSelectedTitleDeed( titleDeedCard);
                                    getGameAction(titleDeedCard.getPropertyActions(), MORTGAGE_PROPERTY_ACTION).execute();
                                    player.setSelectedTitleDeed(null);
                                    currentPropertyTile.getPossibleActions(player);
                                    // player.setSelectedTitleDeed( currentPropertyTile.getTitleDeedCard());
                                    System.out.println( "Property & Mortgaged: " + titleDeedCard.getPropertyName() + " & " + titleDeedCard.isMortgaged());
                                    System.out.println( "Balance after mortgage:" + player.getBalance());
                                }
                            }
                        }
                    }
                    // if after selling everything player cannot pay, declare bankruptcy
                    // which should have not happened in this decision path
                    if (player.getBalance() < currentPropertyTile.getTitleDeedCard().getCurrentRent()) {
                        // todo bir kere buraya geldi execution, don't know why
                        System.out.println("Error: Liquid total worth calculations wrong.");
                        player.declareBankruptcy();
                        return;
                    }
                    // error
                    System.out.println("Paying rent statistics");
                    System.out.println( "Current tile:" + currentPropertyTile.getTileName());
                    System.out.println("Rent that should be paid: " + currentPropertyTile.getTitleDeedCard().getCurrentRent());
                    System.out.println("Player balance b4 rent: " + player.getBalance());
                    getGameAction(currentPropertyTile.getPossibleActions( player), PAY_RENT_ACTION).execute();
                    System.out.println("Player balance after rent: " + player.getBalance());

                }
            }
        }
        // decision path for unowned property
        else {
            boolean notBought = true;
            System.out.println( "Balanced AI Strategy: Unowned Prop");
            // if player has more than twice the money required to buy the property
            if (player.getBalance() >= 1.05 * currentPropertyTile.getTitleDeedCard().getPropertyValue()) {

                // if the player can pay the maximum rent even after buying this property, buy it
                if (player.getBalance() - gameStatistics.getMaximumRent() > 0) {
                    System.out.println( "Decided to buy property balance:" + player.getBalance());
                    getGameAction(currentPropertyTile.getPossibleActions( player), BUY_PROPERTY_ACTION).execute();
                    notBought = false;
                    System.out.println( "Bought property balance:" + player.getBalance());
                }
            }
            // if does not fit the criteria do not buy
            if( notBought) {
                System.out.println( "Debug: AiStrategy: Decided to not buy the property. Starting auction...");

                // do not buy
                // start auction
                ArrayList<TitleDeedCard> titleDeedOfCurrentProperty = new ArrayList<TitleDeedCard>();
                titleDeedOfCurrentProperty.add( currentPropertyTile.getTitleDeedCard());
                System.out.println( "Auction starting...");
              //  player.startAuction(titleDeedOfCurrentProperty );
            }
        }
    }

    /**
     *  Is invoked when the player is made a trade offer.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing balanced, so the AI player makes rational decisions.
     *  If both players are giving the same amount, or the subject player is receiving more, the trade offer is accepted.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecuteTradeDecision(AIPlayer player) {
        TradeModel tradeModel = player.getTradeModel();
        int thisPlayerOfferings = 0;
        int otherPlayerOfferings = 0;

        int thisPlayer;
        if( tradeModel.getPlayer1() == player){
            thisPlayer = 1;
        }
        else{
            thisPlayer = 2;
        }

        // determine how much this player is putting
        // and how much the other player is putting
        if( thisPlayer == 1){
            thisPlayerOfferings += tradeModel.getMoneyPlayer1();
            for( TitleDeedCard currentTitleDeed : tradeModel.getTitleDeedCardsPlayer1()){
                thisPlayerOfferings  += currentTitleDeed.getPropertyValue();
            }

            otherPlayerOfferings += tradeModel.getMoneyPlayer2();
            for( TitleDeedCard currentTitleDeed : tradeModel.getTitleDeedCardsPlayer2()){
                otherPlayerOfferings  += currentTitleDeed.getPropertyValue();
            }
        }
        else{
            thisPlayerOfferings += tradeModel.getMoneyPlayer2();
            for( TitleDeedCard currentTitleDeed : tradeModel.getTitleDeedCardsPlayer2()){
                thisPlayerOfferings  += currentTitleDeed.getPropertyValue();
            }

            otherPlayerOfferings += tradeModel.getMoneyPlayer1();
            for( TitleDeedCard currentTitleDeed : tradeModel.getTitleDeedCardsPlayer1()){
                otherPlayerOfferings  += currentTitleDeed.getPropertyValue();
            }
        }

        // evaluate the offer
        if( thisPlayerOfferings >= otherPlayerOfferings){
            // TODO ACCEPT OFFER
        }
        else{
            // TODO REJECT OFFER
        }
    }

    /**
     *  Is invoked when the player is involved in an auction.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing balanced, so the AI player makes rational decisions.
     * @param player is the player subject to the decision
     */
    @Override
    public void makeAndExecuteAuctionDecision(AIPlayer player) {
        AuctionModel auctionModel = player.getAuctionModel();

        if( auctionModel.getHighestBid() <= auctionModel.getAuctionedTitleDeeds().get(1).getPropertyValue()
            && player.getBalance() > 3 * auctionModel.getHighestBid()){
            // TODO bid
        }
    }

    /**
     *  Is invoked when the player lands on an IncomeTaxTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing balanced, so the AI player makes rational decisions.
     * @param aiPlayer is the player subject to the decision
     */
    @Override
    public void makeAndExecuteIncomeTaxDecision(AIPlayer aiPlayer) {
        System.out.println( "Balanced AI Strategy: Income Tax");

        if (aiPlayer.getTaxOption() == null || aiPlayer.getTaxOption() == TaxOption.UNDETERMINED) {
            aiPlayer.setTaxOption(TaxOption.TAX_WITH_RATIO);
        }

        // pay the tax
        getGameAction(aiPlayer.getCurrentTile().getPossibleActions(aiPlayer), PAY_TAX_ACTION).execute();
    }

    /**
     *  Is invoked when the player lands on a CardTile.
     *  Makes a decision and executes the corresponding game action according to the the strategy.
     *  Strategy now is playing balanced, so the AI player makes rational decisions.
     *  If the drawn card involves paying money, and the player cannot afford it, player either sells property or
     *  downgrades property to pay, or declares bankruptcy.
     * @param aiPlayer is the player subject to the decision
     */
    @Override
    public void makeAndExecuteCardDecision(AIPlayer aiPlayer) {
        System.out.println( "Balanced AI Strategy: Card");

        ArrayList<GameAction> gameActions = aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
        Card currentCard = aiPlayer.getCurrentlyDrawnCard();

        if( currentCard.getCardDetails().containsKey("PAY") ){
            int moneyToPay = currentCard.getCardDetails().get( "PAY");
            if( aiPlayer.getBalance() > moneyToPay){
                getGameAction(gameActions, APPLY_ACTION).execute();
            }
            else if( aiPlayer.getLiquidTotalWorth() >= moneyToPay){
                System.out.println( "AXBBC191-C2");

                while( aiPlayer.getBalance() < moneyToPay){

                    for (TitleDeedCard titleDeedCard : aiPlayer.getTitleDeeds()) {
                        if (titleDeedCard.getUpgradeLevel() >= 1 && titleDeedCard.isDowngradeable()
                                && aiPlayer.getBalance() < moneyToPay) {

                            System.out.println( "DEBUG: Downgrading to pay debt to card.");

                            aiPlayer.setSelectedTitleDeed( titleDeedCard);
                            getGameAction(titleDeedCard.getPropertyActions(), DOWNGRADE_PROPERTY_ACTION).execute();
                            aiPlayer.setSelectedTitleDeed(null);
                            aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
                        }
                    }
                    if (aiPlayer.getBalance() < moneyToPay) {
                        for (TitleDeedCard titleDeedCard : aiPlayer.getTitleDeeds()) {
                            System.out.println( "Attempting 2 mortgage 2 pay card mandated money");


                            if (!titleDeedCard.isMortgaged ()
                                    && aiPlayer.getBalance() < moneyToPay) {


                                System.out.println( "Mortgaging property to pay card");
                                System.out.println( "Balance b4 mortgage:" + aiPlayer.getBalance());
                                System.out.println( "Property & Mortgaged: " + titleDeedCard.getPropertyName() + " & " + titleDeedCard.isMortgaged());
                                aiPlayer.setSelectedTitleDeed( titleDeedCard);
                                getGameAction(titleDeedCard.getPropertyActions(), MORTGAGE_PROPERTY_ACTION).execute();
                                aiPlayer.setSelectedTitleDeed(null);
                                aiPlayer.getCurrentTile().getPossibleActions(aiPlayer);
                                // player.setSelectedTitleDeed( currentPropertyTile.getTitleDeedCard());
                                System.out.println( "Property & Mortgaged: " + titleDeedCard.getPropertyName() + " & " + titleDeedCard.isMortgaged());
                                System.out.println( "Balance after mortgage:" + aiPlayer.getBalance());

                            }
                        }
                    }
                }

                // now he has acquired the money
                getGameAction(gameActions, APPLY_ACTION).execute();
            }
            else if( aiPlayer.getLiquidTotalWorth() < moneyToPay){
                aiPlayer.declareBankruptcy();
            }

        }
        else{
            getGameAction(gameActions, APPLY_ACTION).execute();
        }
    }
}
