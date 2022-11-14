package game.consumables.consumable_types;

import game.consumables.Consumable;
import game.hero.Hero;

public class Pizza extends Consumable {
    public Pizza(int level) {
        super("Pizza", "P", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostPower(13);
        return (--uses) != 0;
    }
}
