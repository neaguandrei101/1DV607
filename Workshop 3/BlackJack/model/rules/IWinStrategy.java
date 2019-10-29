package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinStrategy {
    public boolean isDealerWinner(Player a_player, Dealer a_dealer, int maxScore);
}
