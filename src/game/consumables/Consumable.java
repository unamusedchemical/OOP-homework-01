package game.consumables;

import game.FieldObj;
import game.field.Field;
import game.hero.Hero;

public abstract class Consumable extends FieldObj {
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
    public abstract boolean apply(Hero hero);

    public String getInfo() {
        return String.format("%s(initial=%s, level=%s)", this.name, this.initial, this.level);
    }
    public int getLevel() {
        return this.level;
    }
}
