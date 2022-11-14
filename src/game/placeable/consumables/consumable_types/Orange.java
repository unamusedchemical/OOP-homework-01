package game.placeable.consumables.consumable_types;

import game.placeable.consumables.Consumable;
import game.placeable.hero.Hero;

public class Orange extends Consumable {
    public Orange(int level) {
        super("Orange", "O", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostHealth(this.level);
        return (--uses) != 0;
    }
}
