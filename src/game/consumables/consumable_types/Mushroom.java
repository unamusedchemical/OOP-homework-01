package game.consumables.consumable_types;

import game.consumables.Consumable;
import game.hero.Hero;

public class Mushroom extends Consumable {
    public Mushroom(int level) {
        super("Mushroom", "M", level, level);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.damageHealth(20);
        return (--uses) != 0;
    }
}
