package BlackJack.model.rules;

public class RulesFactory {

    public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }
    public IHitStrategy GetSoft17HitStrategy() {
        return new Soft17HitStrategy();
    }

    public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }

    public IWinStrategy GetDealerWinsRule() { return new DealerWinsStrategy(); }
    public IWinStrategy GetPlayerWinsRule() { return new PlayerWinsStrategy(); }
}