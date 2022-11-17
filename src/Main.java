import game.placeable.consumables.consumable_types.*;
import game.field.Field;
import game.GameLogic;
import game.placeable.hero.Hero;

public class Main {
    public static void main(String[] args) {
        try {
            Field field = new Field(3, 3);
            GameLogic game = new GameLogic(field);
            game.addObject(new Hero("Thor", 35, 300));
            game.addObject(new Hero("Loki", 30, 200));
            game.addObject(new Hero("Odin", 40, 400));
            game.addObject(new Broccoli(3));
            game.addObject(new Pizza(5));
            game.addObject(new Whiskey(5));
            game.addObject(new Mushroom(5));
            game.addObject(new Orange(5));
            game.addObject(new Rice(5));
            game.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Terminating programme!");
        }
    }
}