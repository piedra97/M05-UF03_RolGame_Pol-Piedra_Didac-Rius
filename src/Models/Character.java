package Models;

import java.util.UUID;

public abstract class Character {
    private UUID id;
    protected String name;
    protected int life;
    protected int damage;

    public Character(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
