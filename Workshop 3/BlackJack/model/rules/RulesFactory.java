package BlackJack.model.rules;

public class RulesFactory {

    public IHitStrategy GetHitRule() {
        return new Soft17HitVariant();
    }

    public INewGameStrategy GetNewGameRule() {
        return new AmericanNewGameStrategy();
    }

    public ITheWinnerStrategy GetNewRule() {
        return new WinGame();
    }
}