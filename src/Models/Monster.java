package Models;

import Models.Contracts.IFight;

public class Monster extends NPC implements IFight {

    public Monster(String name) {
        super(name);
    }

    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public String appear() {
        return null;
    }
}
