package Collections;

import Models.Merchant;
import Models.Monster;
import Models.NPC;

public class NPCCollection {

    private static int counter = 0;

    public static NPC getCharacter(String character) {

        switch (character) {
            case "Monster":
                if (counter == monsterList.length)
                    return null;
                else
                    return monsterList[counter++];
            case "Merchant":
                return merchant;
            default:
                return null;
        }

    }

    private static Monster[] monsterList = {
            new Monster("Murlock", 1),
            new Monster("Ork", 2),
            new Monster("Sauron", 4),
            new Monster("Voldemort", 8),
            new Monster("Dracula", 16),
            new Monster("Frankenstein", 20),
            new Monster("Wolf", 24),
            new Monster("Legolas", 28),
            new Monster("Thanos", 32),
            new Monster("Kratos", 36)
    };

    private static Merchant merchant = new Merchant("Manolo el del Bombo");
}
