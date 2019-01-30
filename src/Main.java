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

        player = chooseName(player);
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
                findMerchant(player, npc);
            }
        }

    }

    private static void findMerchant(Player player, NPC npc) {
        Merchant merchant = (Merchant) NPCCollection.getCharacter("Merchant");
        System.out.println(merchant.appear());
        System.out.println("Choose your purchase:");
        while (true) {
            for (ProductToSell product: ProductToSell.values()) {
                System.out.println(product.toString());
            }
            String product = read.nextLine();
            if (!merchant.isBuyable(player.buy(product))) {
                System.out.println("The product doesn't exist. Try again. \n");
                continue;
            }

            if (product.toLowerCase().equals("heal")) {
                player.addLife();
                System.out.println(player.getName() + " has increased 38pts. Actually is " + player.getLife());
            } else {
                player.addDamage();
                System.out.println(player.getName() + "Your damage has increased.");
            }
            break;
        }

    }

    private static void fightWithMonster(Player player, NPC npc) {
        npc = NPCCollection.getCharacter("Monster");
        if (npc == null) {
            System.out.println("You won!");
        }
        System.out.println(npc.appear());

        int turn = 1;

        while (true) {

            if (turn++ % 2 != 0) {

                while (true) {
                    System.out.println("Is your turn. ¿Atack or defend? (A/D)");
                    switch (read.nextLine().toLowerCase()) {
                        case "a":
                            player.attack(npc);
                            System.out.println(npc.getName() + "'s life is " + npc.getLife());
                            break;
                        case "d":
                            player.defend();
                            System.out.println(player.getName() + "'s life has increased! His life is " + player.getLife());
                            break;
                        default:
                            System.out.println("Invalid option.");
                            continue;
                    }
                    break;
                }

                if (((Monster) npc).isDead()) {
                    System.out.println("You have killed " + npc.getName() + " monster!");
                    break;
                }

            } else {
                ((Monster) npc).attack(player);
                System.out.println(player.getName() + "'s life is " + player.getLife());
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

    private static Player chooseName(Player player) {
        System.out.print("Choose your player name: ");
        return new Player(read.nextLine());

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
