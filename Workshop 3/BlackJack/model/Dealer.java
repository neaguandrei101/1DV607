package BlackJack.model;

import BlackJack.model.rules.*;

import java.util.Iterator;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private ITheWinnerStrategy m_winnerRule;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winnerRule = a_rulesFactory.GetNewRule();
    }

    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(m_deck, this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            DealCard(a_player, true);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (CalcScore() > g_maxScore) {
            return false;

        }
        return m_winnerRule.isWinner(this.CalcScore(), a_player.CalcScore());

    }

    public boolean IsGameOver() {
        if (m_deck != null && m_hitRule.DoHit(this) != true) {
            return true;
        }
        return false;
    }

    public boolean Stand() {
        if (m_deck != null) {
            ShowHand();
        }
        while (m_hitRule.DoHit(this)) {
            m_hitRule.DoHit(this);
            DealCard(this, true);
            return true;

        }
        return false;
    }

    public void DealCard(Player a_player, boolean show) {
        Card c = m_deck.GetCard();
        c.Show(show);
        a_player.DealCard(c);

    }

}
