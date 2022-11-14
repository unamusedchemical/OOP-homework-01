package game.consumables.consumable_types;

import game.consumables.Consumable;
import game.hero.Hero;

public class Orange extends Consumable {
    public Orange(int level) {
        super("Orange", "O", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostHealth(this.level);
        System.out.println(hero.getHeroInfo());
        return (--uses) != 0;
    }
}