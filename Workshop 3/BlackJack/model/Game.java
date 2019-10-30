package BlackJack.model;

import BlackJack.model.observer.Observer_IO;
import BlackJack.view.IView;

public class Game {

  private Dealer m_dealer;
  private Player m_player;
  private IView a_view;

  public Game(IView v) {
    m_dealer = new Dealer(new BlackJack.model.rules.RulesFactory());
    m_player = new Player();
    a_view = v;
  }

  public boolean IsGameOver() {
    UpdateView();
    boolean outcome = m_dealer.IsGameOver();
    if (outcome)
      a_view.DisplayGameOver(IsDealerWinner());
    return outcome;
  }

  public boolean IsDealerWinner() {
    return m_dealer.IsDealerWinner(m_player);
  }

  public boolean NewGame() {
    UpdateView();
    return m_dealer.NewGame(m_player);
  }

  public boolean Hit() {
    UpdateView();
    return m_dealer.Hit(m_player);
  }

  public boolean Stand() {
    UpdateView();
    return m_dealer.Stand();
  }

  public Iterable<Card> GetDealerHand() {
    return m_dealer.GetHand();
  }

  public Iterable<Card> GetPlayerHand() {
    return m_player.GetHand();
  }

  public int GetDealerScore() {
    return m_dealer.CalcScore();
  }

  public int GetPlayerScore() {
    return m_player.CalcScore();
  }

  private void UpdateView() {
    a_view.DisplayWelcomeMessage();
    a_view.DisplayDealerHand(GetDealerHand(), GetDealerScore());
    a_view.DisplayPlayerHand(GetPlayerHand(), GetPlayerScore());
  }
  public void newGameObserver(Observer_IO observer) {
    m_dealer.addGameObserver(observer);
    m_player.addGameObserver(observer);

  }


}
