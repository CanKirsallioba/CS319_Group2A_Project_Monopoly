package model.tiles.actionStrategy;

import model.player.Player;
import model.player.TaxOption;

public class IncomeTaxTileActionStrategy extends ActionStrategy {
    /**
     * This method allows the player to set the tax option to money-wise payment.
     *
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button1Strategy(Player player) {player.setTaxOption(TaxOption.TAX_WITH_RATIO); }

    /**
     * This method allows the player to set the tax option to percentage-wise payment.
     *
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button2Strategy(Player player) {player.setTaxOption(TaxOption.FIXED_TAX_AMOUNT);}

    /**
     * This method allows the player to pay the tax.
     *
     * @param player is the player that the action is inflicted on.
     */
    @Override
    public void button3Strategy(Player player) {
        // TODO implement payTax() method in Player class
        // TODO player.payTax();
        System.out.println("Balance before paying: " + player.getBalance());
        int taxAmount;
        if (player.getTaxOption() == TaxOption.TAX_WITH_RATIO) {
            taxAmount = (int) (player.getBalance() * (0.2));
        } else {
            taxAmount = player.getPlayerToken().getBoard().getBoardSalary() / 4;
        }
        if (player.getBalance() >= taxAmount) {
            player.changeBalance(-taxAmount);
        }
        else{
            player.declareBankruptcy();
        }

        System.out.println("Player paid: " + taxAmount);
        System.out.println("Balance after paying: " + player.getBalance());
    }

    @Override
    public void button4Strategy(Player player) {

    }
}
