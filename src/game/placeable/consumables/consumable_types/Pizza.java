package game.placeable.consumables.consumable_types;

import game.placeable.consumables.Consumable;
import game.placeable.hero.Hero;

public class Pizza extends Consumable {
    public Pizza() {
        super("Pizza", "P", 1, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostPower(13);
        return (--uses) != 0;
    }
}
