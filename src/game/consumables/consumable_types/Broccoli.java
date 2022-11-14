package game.consumables.consumable_types;

import game.consumables.Consumable;
import game.hero.Hero;

public class Broccoli extends Consumable {
    public Broccoli(int level) {
        super("Broccoli", "B", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostHealth(2 * this.level);
        return (--uses) != 0;
    }
}
