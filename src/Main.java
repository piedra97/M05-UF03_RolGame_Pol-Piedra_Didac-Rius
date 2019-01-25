import Collections.NPCCollection;
import Models.*;
import Models.Character;

import java.util.Scanner;

public class Main {

    private static Scanner read = new Scanner(System.in);

    public static void main(String[] args){
        Game();
    }

    private static void Game() {

        Player player = null;
        NPC npc = null;

        chooseName(player);
        chooseRace(player);
        chooseClass(player);
        chooseWeapon(player);

        int box = 0;
        while (true) {

            if(player.move(box++)) {
                fightWithMonster(player, npc);
                if(player.isDead()) {
                    break;
                }
            }
            else {
                findMerchant(player);
            }
        }

    }

    private static void findMerchant(Player player) {
    }

    private static void fightWithMonster(Player player, NPC npc) {
        npc = NPCCollection.getCharacter("Monster");

        int turn = 1;

        while (true) {

            if (turn % 2 != 0) {

                player.attack(npc);
                if (((Monster) npc).isDead()) {
                    System.out.println("You have killed " + npc.getName() + " monster!");
                    break;
                }

            } else {
                ((Monster) npc).attack(player);
                if (player.isDead()) {
                    System.out.println("Monster " + npc.getName() + " has killed you!");
                    break;
                }
            }

        }
    }

    private static void chooseWeapon(Player player) {
        System.out.println("Choose your weapon:");
        for (Weapon weapon: Weapon.getValues(player.getRace().getCharacterClass())) {
            System.out.println(weapon.toString());
        }
        while (true) {
            if (!player.getRace().setWeapon(read.nextLine())) {
                System.out.println("The weapon doesn't exist. Try again. \n");
                continue;
            }
            break;
        }
    }

    private static void chooseClass(Player player) {
        System.out.println("Choose your class:");
        for (CharacterClass characterClass: CharacterClass.values()) {
            System.out.println(characterClass.toString());
        }
        while (true) {
            if (!player.getRace().setCharacterClass(read.nextLine())) {
                System.out.println("The class doesn't exist. Try again. \n");
                continue;
            }
            break;
        }
    }

    private static void chooseName(Player player) {
        System.out.print("Choose your player name: ");
        player = new Player(read.nextLine());
    }

    private static void chooseRace(Player player) {
        System.out.println("Choose your race:");
        for (Race race: Race.values()) {
            System.out.println(race.toString());
        }
        while (true) {
            if (!player.setRace(read.nextLine())) {
                System.out.println("The race doesn't exist. Try again. \n");
                continue;
            }
            break;
        }
    }
}
