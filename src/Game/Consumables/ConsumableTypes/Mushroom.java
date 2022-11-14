package Game.Consumables.ConsumableTypes;

import Game.Consumables.Consumable;
import Game.hero.Hero;

public class Mushroom extends Consumable {
    public Mushroom(int level) {
        super("Mushroom", "M", level, level);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.damageHealth(20);
        System.out.println(hero.getHeroInfo());
        return (--uses) != 0;
    }
}
