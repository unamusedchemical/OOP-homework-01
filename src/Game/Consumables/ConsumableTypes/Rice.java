package Game.Consumables.ConsumableTypes;

import Game.Consumables.Consumable;
import Game.Hero.Hero;

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

