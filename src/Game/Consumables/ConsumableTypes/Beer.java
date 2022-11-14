package Game.Consumables.ConsumableTypes;

import Game.Consumables.Consumable;
import Game.hero.Hero;

public class Beer extends Consumable {
    Beer(int level) {
        super("Beer", "B", level, level);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.damagePower(15);
        System.out.println(hero.getHeroInfo());
        return (--uses) != 0;
    }
}
