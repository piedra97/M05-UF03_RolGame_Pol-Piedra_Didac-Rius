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

    public boolean setRace(String race) {
        switch (race.toLowerCase()) {
            case "human":
                this.race = Race.Human;
                return true;
            case "elf":
                this.race = Race.Elf;
                return true;
            case "dwarf":
                this.race = Race.Dwarf;
                return true;
            default:
                return false;
        }
    }

    public boolean move(int box) {
        if(box % 2 == 0) {
            return true;
        }
        return false;
    }

    public ProductToSell buy(String choice) {
        switch (choice) {
            case "Heal":
                return ProductToSell.HEAL;
            case "Damage":
                return ProductToSell.DAMAGE;
            default:
                return null;
        }
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
}
