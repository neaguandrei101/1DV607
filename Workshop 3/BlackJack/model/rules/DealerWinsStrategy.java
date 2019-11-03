package BlackJack.model.rules;

public class DealerWinsStrategy implements ITheWinnerStrategy {
    @Override
    public boolean isDealerWinner(int playerScore,int dealerScore, int maxScore) {
        if (playerScore > maxScore) {
            return true;
        } else if (dealerScore > maxScore) {
            return false;
        }
        return dealerScore >= playerScore;
    }
}
