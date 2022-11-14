package Game;

import Game.Consumables.Consumable;
import Game.Directions.Direction;
import Game.Field.Field;
import Game.hero.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameLogic {
    private ArrayList<Hero> aliveHeroes;
    private ArrayList<Consumable> consumables;
    private ArrayList<Direction> directions;

    final Field field;

    public GameLogic(Field field) throws IllegalArgumentException {
        if(field == null) {
            throw new IllegalArgumentException("Field cannot be null!");
        }

        this.aliveHeroes = new ArrayList<>();
        this.consumables = new ArrayList<>();
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

    public GameLogic addObject(Object obj) {
        field.placeObject(obj);

        if(obj instanceof Hero) {
            aliveHeroes.add((Hero) obj);
            System.out.printf("Hero added %s at x=%d, y=%d)\n", ((Hero) obj).getHeroInfo(),
                                                                ((Hero) obj).getX(),
                                                                ((field.getHeight() - 1 - ((Hero) obj).getY())) % field.getHeight());
        } else if(obj instanceof Consumable) {
            consumables.add((Consumable) obj);
            System.out.printf("Consumable added %s(initial=%s, level=%d) at x=%d, y=%d\n", ((Consumable) obj).getName(),
                                                                                           ((Consumable) obj).getInitial(),
                                                                                           ((Consumable) obj).getLevel(),
                                                                                           ((Consumable) obj).getX(),
                                                                                           ((field.getHeight() - 1 - ((Consumable) obj).getY())) % field.getHeight());
        }

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

        int x = hero.getX();
        int y = hero.getY();

        System.out.printf("%s moves ", hero.getName());

        switch (directions.get(random.nextInt(directions.size()))) {
            case UP:
                y -= 1;
                System.out.println("UP");
                break;
            case DOWN:
                y += 1;
                System.out.println("DOWN");
                break;
            case LEFT:
                x -= 1;
                System.out.println("LEFT");
                break;
            case RIGHT:
                x += 1;
                System.out.println("RIGHT");
                break;
            default:
                System.out.println("Invalid direction");
                break;
        }

        if(field.isWithin(x, y)) {
            if(field.at(x, y) instanceof Consumable consumable) {
                System.out.printf("%s consumes %s\n", hero.getName(), consumable.getName());
                hero.applyConsumable(consumable);
            } else if(field.at(x, y) instanceof Hero opponent) {
                System.out.printf("%s fights %s\n", hero.getName(), opponent.getName());
                battle(hero, opponent);
            }

            // a hero is dead if they are not on the list with aliveHeroes
            if(aliveHeroes.contains(hero)) {
                field.changeHeroPosition(hero, x, y);
                hero.setX(x);
                hero.setY(y);
            }
        }
    }

    private void battle(Hero hero, Hero opponent) {
        if (hero.getPower() > opponent.getPower() ||
                (hero.getPower() == opponent.getPower() && hero.getHealth() > opponent.getHealth())) {
            System.out.printf("%s kills %s\n", hero.getName(), opponent.getName());

            aliveHeroes.remove(opponent);
            field.removeObjectAt(opponent.getX(), opponent.getY());

        } else if(hero.getPower() < opponent.getPower() ||
                (hero.getPower() == opponent.getPower() && hero.getHealth() < opponent.getHealth())) {

            System.out.printf("%s kills %s\n", opponent.getName(), hero.getName());

            aliveHeroes.remove(hero);
            field.removeObjectAt(hero.getX(), hero.getY());

        } else {

            System.out.printf("%s and %s kill each other\n", hero.getName(), opponent.getName());

            aliveHeroes.remove(hero);
            field.removeObjectAt(hero.getX(), hero.getY());

            aliveHeroes.remove(opponent);
            field.removeObjectAt(opponent.getX(), opponent.getY());

        }
    }
}
