package game.placeable.consumables;

import game.placeable.Placeable;
import game.placeable.hero.Hero;

public abstract class Consumable extends Placeable {
    private int x, y;
    private final String name;
    private final String initial;
    protected final int level;
    protected int uses;

    public Consumable(String name, String initial, int level, int uses) throws IllegalArgumentException {
        super(name, initial);

        if(level < 1 || level > 5) {
            throw new IllegalArgumentException("Level must be an integer between 1 and 5!");
        }

        this.name = name;
        this.initial = initial;
        this.level = level;
        this.uses = uses;
    }

    // true - can apply again
    // false - cannot apply again
    public boolean apply(Hero hero) {
        System.out.printf("%s effect is applied to %s\n", this.name, hero.getName());
        return true;
    }

    public String getInfo() {
        return String.format("%s(initial=%s, level=%s)", this.name, this.initial, this.level);
    }
    public int getLevel() {
        return this.level;
    }
}
