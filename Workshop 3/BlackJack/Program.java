package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program {

    public static void main(String[] a_args) {

        IView v = new SimpleView(); // new SwedishView();
        Game g = new Game(v);
        PlayGame ctrl = new PlayGame();

        while (ctrl.Play(g, v));
    }
}