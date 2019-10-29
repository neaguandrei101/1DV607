package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class DealerWinsStrategy implements IWinStrategy {
    @Override
    public boolean isDealerWinner(Player a_player, Dealer a_dealer, int maxScore) {
        if (a_player.CalcScore() > maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > maxScore) {
            return false;
        }
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
