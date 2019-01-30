package Models;

import java.util.Random;
import java.util.UUID;

public abstract class Character {
    private UUID id;
    protected String name;
    protected int life;
    protected int damage;

    protected final int maxLife = 100;

    public Character(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.life = maxLife;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public void addLife() {
        this.life += 50;
    }

    public void addDamage() {
        this.damage += 6;
    }
}
