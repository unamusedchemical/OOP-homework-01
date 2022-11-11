import Game.Consumables.ConsumableTypes.*;
import Game.Field.Field;
import Game.GameLogic;
import Game.Hero.Hero;

public class Main {
    public static void main(String[] args) {
        try {
            Field field = new Field(4, 4);
            GameLogic game = new GameLogic(field);
            game.addHero(new Hero("Thor", 2000, 300));
            game.addHero(new Hero("Loki", 1500, 200));
            game.addHero(new Hero("Odin", 2500, 400));
            game.addConsumable(new Broccoli(3));
            game.addConsumable(new Rice(1));
            game.addConsumable(new Mushroom(5));
            game.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Terminating programme!");
        }
    }
}