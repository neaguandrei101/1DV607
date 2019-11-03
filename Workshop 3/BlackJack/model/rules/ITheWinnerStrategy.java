package BlackJack.model.rules;

public interface ITheWinnerStrategy {

    boolean isDealerWinner(int dealerScore, int playerScore, int maxScore);

}
