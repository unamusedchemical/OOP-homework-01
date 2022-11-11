package Game.Consumables.ConsumableTypes;

import Game.Consumables.Consumable;
import Game.Hero.Hero;

public class Broccoli extends Consumable {
    public Broccoli(int level) {
        super("Broccoli", "B", level, 1);
    }

    @Override
    public boolean apply(Hero hero) {
        hero.boostHealth(2 * this.level);
        System.out.println(hero.getHeroInfo());
        return (--uses) != 0;
    }
}
