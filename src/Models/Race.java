package Models;

public enum Race {
    Human,
    Elf,
    Dwarf;

    protected CharacterClass characterClass;

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public boolean setCharacterClass(String characterClass) {
        switch (characterClass.toLowerCase()) {
            case "warrior":
                this.characterClass = CharacterClass.Warrior;
                return true;
            case "mague":
                this.characterClass = CharacterClass.Mague;
                return true;
            case "rogue":
                this.characterClass = CharacterClass.Rogue;
                return true;
            default:
                return false;
        }
    }

    public Weapon getWeapon() {
        return this.characterClass.weapon;
    }

    public boolean setWeapon(String weapon) {
        if (this.characterClass.equals(CharacterClass.Warrior)) {
            switch (weapon.toLowerCase()) {
                case "sword":
                    this.characterClass.weapon = Weapon.Sword;
                    return true;
                case "hammer":
                    this.characterClass.weapon = Weapon.Hammer;
                    return true;
                case "axe":
                    this.characterClass.weapon = Weapon.Axe;
                    return true;
                default:
                    return false;
            }
        } else if (this.characterClass.equals(CharacterClass.Mague)) {
            switch (weapon.toLowerCase()) {
                case "sword":
                    this.characterClass.weapon = Weapon.Sword;
                    return true;
                case "staff":
                    this.characterClass.weapon = Weapon.Staff;
                    return true;
                default:
                    return false;
            }
        } else if (this.characterClass.equals(CharacterClass.Rogue)) {
            switch (weapon.toLowerCase()) {
                case "blade":
                    this.characterClass.weapon = Weapon.Blade;
                    return true;
                case "bow":
                    this.characterClass.weapon = Weapon.Bow;
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
