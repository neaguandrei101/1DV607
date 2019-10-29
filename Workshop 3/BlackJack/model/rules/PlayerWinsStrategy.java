package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class PlayerWinsStrategy implements IWinStrategy {
    @Override
    public boolean isDealerWinner(Player a_player, Dealer a_dealer, int maxScore) {
        if (a_player.CalcScore() > maxScore) {
            return false;
        } else if (a_dealer.CalcScore() > maxScore) {
            return true;
        }
        return a_dealer.CalcScore() <= a_player.CalcScore();
    }
}
