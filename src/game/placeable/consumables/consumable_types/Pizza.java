package game.placeable.consumables.consumable_types;

import game.placeable.consumables.Consumable;
import game.placeable.hero.Hero;

public class Pizza extends Consumable {
    public Pizza(int level) {
        super("Pizza", "P", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        super.apply(hero);
        hero.boostPower(13);
        return (--uses) != 0;
    }
}
