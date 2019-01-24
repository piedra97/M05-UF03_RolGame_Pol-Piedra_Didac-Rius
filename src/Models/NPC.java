package Models;

public abstract class NPC extends Character {

    public NPC(String name) {
        super(name);
    }

    public abstract String appear();
}
