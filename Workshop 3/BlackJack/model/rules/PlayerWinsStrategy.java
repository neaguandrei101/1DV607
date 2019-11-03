package BlackJack.model.rules;

public class PlayerWinsStrategy implements ITheWinnerStrategy {
    @Override
    public boolean isDealerWinner(int playerScore,int dealerScore, int maxScore) {
        if (playerScore > maxScore) {
            return false;
        } else if (dealerScore > maxScore) {
            return true;
        }
        return dealerScore <= playerScore;
    }
}
