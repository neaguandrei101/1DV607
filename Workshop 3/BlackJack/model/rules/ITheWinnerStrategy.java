package BlackJack.model.rules;

public interface ITheWinnerStrategy {

    boolean isWinner(int dealerScore, int playerScore);

}
