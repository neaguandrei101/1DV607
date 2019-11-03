package BlackJack.model.rules;

public class RulesFactory {

    public IHitStrategy GetSoft17HitRule() {
        return new Soft17HitStrategy();
    }
    public IHitStrategy GetBasicHitRule() { return new BasicHitStrategy(); }

    public INewGameStrategy GetAmericanGameRule() {
        return new AmericanNewGameStrategy();
    }
    public INewGameStrategy GetInternationalGameRule() { return new InternationalNewGameStrategy();}

    public ITheWinnerStrategy GetDealerWinRule() {
        return new DealerWinsStrategy();
    }
    public ITheWinnerStrategy GetPlayerWinRule() { return new PlayerWinsStrategy(); }
}