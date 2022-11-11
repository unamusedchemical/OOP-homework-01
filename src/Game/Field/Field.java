package Game.Field;

import Game.Consumables.Consumable;
import Game.Hero.Hero;

import java.util.*;

public class Field {
    private final int height;
    private final int width;
    private Object[][] field;

    public Field(int height, int width) {
        // check if dimensions are ok

        this.height = height;
        this.width = width;
        field = new Object[height][width];
        System.out.printf("Field with size %d x %d has been initialized.\n", width, height);
    }

    public void draw() {
        System.out.print("  ");
        for(int i = 0; i < width; ++i) {
            System.out.printf("%5d.", i);
        }
        System.out.print("\n");

        for(int i = 0; i < height; ++i) {
            System.out.printf("%d. ", i);
            for(int j = 0; j < width; j++) {
                if(field[i][j] instanceof Hero) {
                    System.out.printf("| %3s ", ((Hero)field[i][j]).getInitial());
                } else if(field[i][j] instanceof Consumable) {
                    System.out.printf("| %3s ", ((Consumable) field[i][j]).getInitial());
                } else if(field[i][j] == null) {
                    System.out.print("|     ");
                }
            }
            System.out.println("|");
        }
    }

    private boolean isPositionEmpty(int x, int y) {
        return field[y][x] == null;
    }

    public void placeHero(Hero hero) {
        int x, y;
        do {
            x = getRandomX();
            y = getRandomY();
        } while (!isPositionEmpty(x, y));
        field[y][x] = hero;
        hero.setX(x);
        hero.setY(y);
    }

    public void placeConsumable(Consumable consumable) {
        int x, y;
        do {
            x = getRandomX();
            y = getRandomY();
        } while (!isPositionEmpty(x, y));
        field[y][x] = consumable;
        consumable.setX(x);
        consumable.setY(y);
    }

    public void changeHeroPosition(Hero hero, int x, int y) {
        field[hero.getY()][hero.getX()] = null;
        field[y][x] = hero;
    }

    private int getRandomX() {
        Random random = new Random();
        return random.nextInt(width);
    }

    private int getRandomY() {
        Random random = new Random();
        return random.nextInt(height);
    }

    public void removeObjectAt(int x, int y) {
        field[y][x] = null;
    }

    public Object at(int x, int y) {
        return field[y][x];
    }

    public boolean isWithin(int x, int y) {
        return (x < this.width && x >= 0) && (y < this.height && y >= 0);
    }
}
