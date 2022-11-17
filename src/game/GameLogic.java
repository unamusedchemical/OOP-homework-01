package game;

import game.placeable.Placeable;
import game.placeable.consumables.Consumable;
import game.directions.Direction;
import game.field.Field;
import game.placeable.hero.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameLogic {
    private ArrayList<Hero> aliveHeroes;
    private ArrayList<Direction> directions;

    final Field field;

    public GameLogic(Field field) throws IllegalArgumentException {
        if(field == null) {
            throw new IllegalArgumentException("Field cannot be null!");
        }

        this.aliveHeroes = new ArrayList<>();
        this.field = field;
        directions = new ArrayList<>(Arrays.asList(Direction.values()));
    }

    public void start() throws IllegalAccessError{
        System.out.println("Game started");

        if(aliveHeroes.size() < 2) {
            throw new IllegalAccessError("Cannot start game with less than two characters");
        }

        while(true) {
            for(int i = 0; i < aliveHeroes.size(); ++i) {
                field.draw();
                move(aliveHeroes.get(i));
            }
            if(this.checkForWinner()) {
                field.draw();
                break;
            }
        }
    }

    public GameLogic addObject(Placeable obj) {
        field.placeObject(obj);

        if(obj instanceof Hero) {
            aliveHeroes.add((Hero) obj);
            System.out.print("Hero added ");
        } else if(obj instanceof Consumable) {
            System.out.print("Consumable added ");
        }

        System.out.printf("%s at x=%d, y=%d\n", obj.getInfo(), obj.getX(), obj.getY());

        return this;
    }

    private boolean checkForWinner() {
        if(aliveHeroes.size() == 0) {
            System.out.println("No winners.");
            return true;
        } else if(aliveHeroes.size() == 1) {
            System.out.printf("%s wins.\n", aliveHeroes.get(0).getName());
            return true;
        }

        return false;
    }

    private void move(Hero hero) {
        Random random = new Random();

        hero.applyConsumableLongLastingEffects();

        if(hero.isDead()) {
            System.out.printf("%s dies\n", hero.getName());
            removeHero(hero);
            return;
        }

        int x = hero.getX();
        int y = hero.getY();

        System.out.printf("%s moves ", hero.getName());

        switch (directions.get(random.nextInt(directions.size()))) {
            case UP -> {
                y -= 1;
                System.out.println("UP");
            }
            case DOWN -> {
                y += 1;
                System.out.println("DOWN");
            }
            case LEFT -> {
                x -= 1;
                System.out.println("LEFT");
            }
            case RIGHT -> {
                x += 1;
                System.out.println("RIGHT");
            }
            default -> System.out.println("Invalid direction");
        }

        checkMovePosition(hero, x, y);
    }

    private void checkMovePosition(Hero hero, int x, int y) {
        if(field.isWithin(x, y)) {
            if(field.at(x, y) instanceof Consumable consumable) {
                System.out.printf("%s consumes %s\n", hero.getName(), consumable.getName());
                hero.applyConsumable(consumable);
                if(hero.isDead()) {
                    System.out.printf("%s dies after consuming %s\n", hero.getName(), consumable.getName());
                    removeHero(hero);
                    field.removeObjectAt(x, y);
                }
            } else if(field.at(x, y) instanceof Hero opponent) {
                System.out.printf("%s fights %s\n", hero.getName(), opponent.getName());
                battle(hero, opponent);
            }

            if(aliveHeroes.contains(hero)) {
                field.changeHeroPosition(hero, x, y);
                hero.setX(x);
                hero.setY(y);
            }
        }
    }

    private void battle(Hero hero, Hero opponent) {

        Hero dead = hero.fightToTheDeath(opponent);

        if(dead == null) {
            removeHero(hero);
            removeHero(opponent);
        } else {
            removeHero(dead);
        }
    }

    private void removeHero(Hero hero) {
        aliveHeroes.remove(hero);
        field.removeObjectAt(hero.getX(), hero.getY());
    }
}
