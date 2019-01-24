package Models;

public enum CharacterClass {
    Warrior,
    Rogue,
    Mague;

    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
