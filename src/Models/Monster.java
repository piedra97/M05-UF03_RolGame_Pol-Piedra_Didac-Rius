package Models;

import Models.Contracts.IFight;

public class Monster extends NPC implements IFight {

    public Monster(String name) {
        super(name);
    }

    @Override
    public void attack(Character c) {
        c.life = c.life - super.damage;
    }

    @Override
    public void defend() {
        if (super.life != super.maxLife) super.life++;
    }

    @Override
    public boolean isDead() {
        return super.life == 0;
    }

    @Override
    public String appear() {
        return null;
    }
}
