package Models;

import Models.Contracts.IFight;

public class Player extends Character implements IFight {

    private Race race;

    public Player(String name) {
        super(name);
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void move() {
    }

    public void buy(String choice) {
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
}
