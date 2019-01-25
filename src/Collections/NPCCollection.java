package Collections;

import Models.Merchant;
import Models.Monster;
import Models.NPC;

public class NPCCollection {

    private static int counter = 0;

    public static NPC getCharacter(String character) {

        switch (character) {
            case "Monster":
                return monsterList[counter++];
            case "Merchant":
                return merchant;
            default:
                return null;
        }

    }

    private static Monster[] monsterList = {
            new Monster("Murlock"),
            new Monster("Ork"),
            new Monster("Sauron"),
            new Monster("Voldemort"),
            new Monster("Dracula"),
            new Monster("Frankenstein"),
            new Monster("Wolf"),
            new Monster("Legolas"),
            new Monster("Thanos"),
            new Monster("Kratos")
    };

    private static Merchant merchant = new Merchant("Manolo el del Bombo");
}
