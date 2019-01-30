package Models;

import Models.Contracts.IFight;

import java.util.Random;

public class Monster extends NPC implements IFight {

    private Random rand = new Random();

    public Monster(String name, int damage) {

        super(name);
        super.damage = damage;
    }

    @Override
    public void attack(Character c) {
        c.life = c.life - (super.damage + (rand.nextInt(12) + 10));
    }

    @Override
    public void defend() {
        if (super.life != super.maxLife) super.life++;
    }

    @Override
    public boolean isDead() {
        return super.life <= 0;
    }

    @Override
    public String appear() {
        return super.name + " has appeared!";
    }
}
