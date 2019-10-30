package BlackJack.model.rules;

public class WinGame implements ITheWinnerStrategy {
    private int equalScores = 21;

    @Override
    public boolean isWinner(int dealerScore, int playerScore) {
        if (dealerScore == playerScore && playerScore == equalScores) {
            return false;
        }

        return true;
    }

}
