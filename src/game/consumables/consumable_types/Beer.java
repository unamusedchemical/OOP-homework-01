package game.consumables.consumable_types;

import game.consumables.Consumable;
import game.hero.Hero;

public class Beer extends Consumable {
    Beer(int level) {
        super("Beer", "B", level, level);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.damagePower(15);
        return (--uses) != 0;
    }


}
