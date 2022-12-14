package game.placeable.hero;

import game.placeable.Placeable;
import game.placeable.consumables.Consumable;

import java.util.ArrayList;

public class Hero extends Placeable {
    private int health;
    private int power;
    private final ArrayList<Consumable> consumables;

    public Hero(String name, int health, int power) throws IllegalArgumentException {
        super(name, name.substring(0, 2));

        if(health <= 0 || power <= 0) {
            throw new IllegalArgumentException("No fields take negative values!");
        }

        this.health = health;
        this.power = power;
        consumables = new ArrayList<>();
    }
    
    public boolean isDead() {
        return this.health <= 0;
    }
    
    // applies a consumable found on the field
    public void applyConsumable(Consumable consumable) {
        if(consumable.apply(this)) {
            consumables.add(consumable);
        }
    }

    // returns the loser
    // in case that both heroes kill each other null is returned
    public Hero fightToTheDeath(Hero other) {
        if (this.power > other.power || (this.power == other.power && this.health > other.health)) {
            System.out.printf("%s kills %s\n", this.name, other.getName());
//            other.health = 0;
            return other;
        }

        if(this.power < other.power || (this.power == other.power && this.health < other.health)) {
            System.out.printf("%s kills %s\n", other.getName(), this.getName());
//            this.health = 0;
            return this;
        }

        System.out.printf("%s and %s kill each other\n", this.getName(), other.getName());
//        this.health = 0;
//        other.health = 0;

        return null;
    }

    // applies long-lasting effects
    public void applyConsumableLongLastingEffects() {
        this.consumables.removeIf(i -> !i.apply(this));
    }

    public void boostHealth(int amount) {
        this.health += amount;
        System.out.println(this.getInfo());
    }

    public void boostPower(int amount) {
        this.power += amount;
        System.out.println(this.getInfo());
    }

    public void damageHealth(int amount) {
        if(this.health - amount <= 0) {
            this.health = 0;
        } else {
            this.health -= amount;
        }

        System.out.println(this.getInfo());
    }

    public void damagePower(int amount) {
        if(this.power - amount <= 0) {
            this.power = 0;
        } else {
            this.power -= amount;
        }

        System.out.println(this.getInfo());
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

    public String getInfo() {
        return String.format("Hero(name=???%s???, initial=???%s???, health=%d, power=%d)", this.name, this.initial, this.health, this.power);
    }
}
