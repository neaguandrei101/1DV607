package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;

class AmericanNewGameStrategy implements INewGameStrategy {
    private Dealer theDealer;

    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
        Card c;
        theDealer = a_dealer;

        theDealer.DealCard(a_player, true);
        theDealer.DealCard(a_dealer, true);
        theDealer.DealCard(a_player, true);
        theDealer.DealCard(a_dealer, false);

        return true;
    }
}