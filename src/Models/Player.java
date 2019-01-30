package Models;

import Models.Contracts.IFight;

import java.util.Random;

public class Player extends Character implements IFight {

    private Random rand = new Random();

    private Race race;

    public Player(String name) {

        super(name);
        super.damage = 10;
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
        switch (choice.toLowerCase()) {
            case "heal":
                return ProductToSell.HEAL;
            case "damage":
                return ProductToSell.DAMAGE;
            default:
                return null;
        }
    }

    @Override
    public void attack(Character c) {
        c.life = c.life - (super.damage + (rand.nextInt(20) + 10));;
    }

    @Override
    public void defend() {
        if (super.life <= super.maxLife) {
            int heal = rand.nextInt(30) + 20;
            super.life = (super.life + heal > 100) ? 100 : super.life + heal;
        }

    }

    @Override
    public boolean isDead() {
        return super.life <= 0;
    }
}
