package Game.hero;

import Game.Consumables.Consumable;

import java.util.ArrayList;

public class Hero {
    private int x, y;
    private String name;
    private String initial;
    private int health;
    private int power;
    private ArrayList<Consumable> consumables;

    public Hero(String name, int health, int power) throws IllegalArgumentException {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }

        if(health <= 0 || power <= 0) {
            throw new IllegalArgumentException("No fields take negative values!");
        }

        this.name = name;
        this.initial = name.substring(0, 2);
        this.health = health;
        this.power = power;
        consumables = new ArrayList<>();
    }

    // applies a consumable found on the field
    public void applyConsumable(Consumable consumable) {
        if(consumable.apply(this)) {
            consumables.add(consumable);
        }
    }

    // applies long-lasting effects
    public void applyConsumableLongLastingEffects() {
        this.consumables.removeIf(i -> !i.apply(this));
    }

    public void boostHealth(int amount) {
        this.health += amount;
    }

    public void boostPower(int amount) {
        this.power += amount;
    }

    public void damageHealth(int amount) {
        this.health -= amount;
    }

    public void damagePower(int amount) {
        this.power -= amount;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getHeroInfo() {
        return String.format("Hero(name=”%s”, initial=”%s”, health=%d, power=%d)", this.name, this.initial, this.health, this.power);
    }
}
