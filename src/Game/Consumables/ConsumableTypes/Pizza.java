package Game.Consumables.ConsumableTypes;

import Game.Consumables.Consumable;
import Game.hero.Hero;

public class Pizza extends Consumable {
    public Pizza(int level) {
        super("Pizza", "P", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostPower(13);
        System.out.println(hero.getHeroInfo());
        return (--uses) != 0;
    }
}
