package game.placeable.consumables.consumable_types;

import game.placeable.consumables.Consumable;
import game.placeable.hero.Hero;

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
