package Models;

public enum Race {
    Human,
    Elf,
    Dawrf;

    private CharacterClass characterClass;

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }
}
