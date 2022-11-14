package game.field;

import game.consumables.Consumable;
import game.hero.Hero;

import java.util.*;

public class Field {
    private final int height;
    private final int width;
    private Object[][] field;
    private int freePositions;

    public Field(int height, int width) throws IllegalArgumentException{
        // check if dimensions are ok
        if(height * width < 2) {
            throw new IllegalArgumentException("Field must have at least two free spaces!");
        }

        this.height = height;
        this.width = width;
        field = new Object[height][width];
        freePositions = height * width;

        System.out.printf("Field with size %d x %d has been initialized.\n", width, height);
    }

    public void draw() {
        for(int i = 0; i < height; ++i) {
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

    public void placeObject(Object obj) throws IndexOutOfBoundsException {
        if(this.freePositions-- == 0) {
            throw new IndexOutOfBoundsException("No more free positions on the board");
        }

        int x, y;
        do {
            x = getRandomX();
            y = getRandomY();
        } while (!isPositionEmpty(x, y));
        field[y][x] = obj;

        if(obj instanceof Consumable) {
            ((Consumable) obj).setX(x);
            ((Consumable) obj).setY(y);
        } else if(obj instanceof Hero) {
            ((Hero) obj).setX(x);
            ((Hero) obj).setY(y);
        }

    }

    public void changeHeroPosition(Hero hero, int x, int y) {
        field[hero.getY()][hero.getX()] = null;
        field[y][x] = hero;
    }

    private boolean isPositionEmpty(int x, int y) {
        return field[y][x] == null;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
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

    private int getRandomX() {
        Random random = new Random();
        return random.nextInt(width);
    }

    private int getRandomY() {
        Random random = new Random();
        return random.nextInt(height);
    }
}
