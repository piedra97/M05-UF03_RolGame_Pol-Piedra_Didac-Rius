package Models;

import java.util.ArrayList;
import java.util.List;

public enum Weapon {
    Sword,
    Bow,
    Blade,
    Axe,
    Staff,
    Hammer;

    public static List<Weapon> getValues(CharacterClass characterClass) {
        ArrayList list = new ArrayList();
        if (characterClass.equals(CharacterClass.Warrior)) {
            list.add(Sword);
            list.add(Hammer);
            list.add(Axe);
        } else if (characterClass.equals(CharacterClass.Mague)) {
            list.add(Sword);
            list.add(Staff);
        } else if (characterClass.equals(CharacterClass.Rogue)) {
            list.add(Blade);
            list.add(Bow);
        }
        return list;
    }
}
