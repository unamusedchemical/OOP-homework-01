package game.placeable.consumables.consumable_types;

import game.placeable.consumables.Consumable;
import game.placeable.hero.Hero;

public class Whiskey extends Consumable {
    public Whiskey(int level) {
        super("Whiskey", "W", level, level);
    }

    @Override
    public boolean apply(Hero hero) {
        super.apply(hero);
        hero.damagePower(15);
        return (--uses) != 0;
    }


}
