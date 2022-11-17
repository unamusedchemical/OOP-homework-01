package game.placeable.consumables.consumable_types;

import game.placeable.consumables.Consumable;
import game.placeable.hero.Hero;

public class Rice extends Consumable {
    public Rice(int level) {
        super("Rice", "R", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        super.apply(hero);
        hero.boostPower(this.level * 2);
        return (--uses) != 0;
    }
}

