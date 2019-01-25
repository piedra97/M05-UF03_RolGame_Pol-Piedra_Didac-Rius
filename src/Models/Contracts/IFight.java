package Models.Contracts;

import Models.Character;

public interface IFight {
    void attack(Character c);
    void defend();
    boolean isDead();
}
