import game.consumables.consumable_types.*;
import game.field.Field;
import game.GameLogic;
import game.hero.Hero;

public class Main {
    public static void main(String[] args) {
//        print info after status effects
        try {
            Field field = new Field(4, 4);
            GameLogic game = new GameLogic(field);
            game.addObject(new Hero("Thor", 2000, 300));
            game.addObject(new Hero("Loki", 1500, 200));
            game.addObject(new Hero("Odin", 2500, 400));
            game.addObject(new Broccoli(3));
            game.addObject(new Rice(1));
            game.addObject(new Mushroom(5));
            game.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Terminating programme!");
        }
    }
}