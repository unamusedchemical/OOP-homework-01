package game.placeable;

public abstract class Placeable {
    protected final String name;
    protected final String initial;
    private int x;
    private int y;

    public Placeable(String name, String initial) throws IllegalArgumentException{
        if((null == name || name.isEmpty()) || (null == initial || initial.isEmpty())) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
        this.initial = initial;
    }

    public abstract String getInfo();

    public String getName() {
        return name;
    }

    public String getInitial() {
        return initial;
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
