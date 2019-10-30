package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;

class InternationalNewGameStrategy implements INewGameStrategy {
  private Dealer dealer;

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    dealer = a_dealer;
    Card c;

    dealer.DealCard(a_player,true);
    dealer.DealCard(a_dealer,true);
    dealer.DealCard(a_player,true);

    return true;
  }
}