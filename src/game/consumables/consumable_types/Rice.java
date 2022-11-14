package game.consumables.consumable_types;

import game.consumables.Consumable;
import game.hero.Hero;

public class Rice extends Consumable {
    public Rice(int level) {
        super("Rice", "R", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostPower(this.level * 2);
        System.out.println(hero.getHeroInfo());
        return (--uses) != 0;
    }
}
