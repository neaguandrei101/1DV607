package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.observer.Observer_IO;
import BlackJack.view.IView;

public class PlayGame implements Observer_IO {
  private int pause = 1500;
  private Game observerGame;
  private IView observerView;




  public boolean Play(Game a_game, IView a_view) {
    observerGame = a_game;
    observerView = a_view;

    a_game.newGameObserver(this);
    a_game.IsGameOver();

    int input = a_view.GetInput();
    if (input == a_view.newGameEvent()) {
      a_game.NewGame();
    } else if (input == a_view.hitEvent()) {
      a_game.Hit();
    } else if (input == a_view.standEvent()) {
      a_game.Stand();
    }

    return input != a_view.quitEvent();
  }

  @Override
  public void send_To_Observer() {
    try{
      Thread.sleep(pause);
      observerView.DisplayDealerHand(observerGame.GetDealerHand(), observerGame.GetDealerScore());
      observerView.DisplayPlayerHand(observerGame.GetPlayerHand(), observerGame.GetPlayerScore());
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}
