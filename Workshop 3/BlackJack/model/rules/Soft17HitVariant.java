package BlackJack.model.rules;

import BlackJack.model.Player;

public class Soft17HitVariant implements IHitStrategy {
    private final int g_hitLimit = 17;


    @Override
    public boolean DoHit(Player a_dealer) {
        int currentDealerScore = a_dealer.CalcScore();
        if (currentDealerScore < g_hitLimit) {
            return true;
        }
        if (g_hitLimit == currentDealerScore && a_dealer.isAce()) {
            return true;
        }
        return false;

    }
}