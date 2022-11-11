package Game.Consumables;

import Game.Hero.Hero;

public abstract class Consumable {
    private int x, y;
    private final String name;
    private final String initial;
    protected final int level;
    protected int uses;

    public Consumable(String name, String initial, int level, int uses) throws IllegalArgumentException {
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

    public String getInitial() {
        return this.initial;
    }
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.level;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
