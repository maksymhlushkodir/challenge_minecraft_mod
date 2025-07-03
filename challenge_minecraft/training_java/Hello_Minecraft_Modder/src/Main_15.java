import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Random;

public class Main_15 {
    public static void  printRoundInfo(int roundNumber) {
        System.out.println("\n===================");
        System.out.println("⚔ РАУНД #" + roundNumber);
        System.out.println("===================\n");
    }

    public static void gameOver (String winnerName) {
        System.out.println("\n=====================");
        System.out.println(" Переможець: " + winnerName + "!");
        System.out.println("=====================\n");
    }

    public static int attack (int attackerDamage, int defenderHP) {
        return defenderHP - attackerDamage;
    }

    public static void HP(String Name ,int HP) {
        System.out.println("У " + Name + " зараз " + HP + " HP");
    }

    public static void Drop(String drop) {
        System.out.println(drop);
    }

    public static String dropLoot(String mobName, Random rand) {
        String drop_1 = "Меч!";
        String drop_2 = "Курятину!";
        String drop_3 = "10 монет!";
        String drop_4 = "Нічого!";

        int dropChance = rand.nextInt(100);
        String drop;

        if (dropChance < 10) {
            drop = drop_1; // 0–9
        } else if (dropChance < 30) {
            drop = drop_2; // 10–29
        } else if (dropChance < 60) {
            drop = drop_3; // 30–59
        } else {
            drop = drop_4; // 60–99
        }

        Drop(mobName + " дропнув " + drop);
        return drop;  // повертаємо дроп, щоб додати його в інвентар
    }

    public static void main(String[] args) {

        String playerName = "plater_1";
        String zoombeName = "zoombe";

        int playerHP = 100;
        int zoombeHP = 100;

        int playerDamage = 30;
        int zoombeDamage = 20;

        int roundNumber = 1;

        Random rand = new Random();

        while (playerHP > 0 && zoombeHP > 0 ) {

            printRoundInfo(roundNumber);
            roundNumber++;

            HP (zoombeName , zoombeHP);

            if (rand.nextInt(100) > 30) {
                zoombeHP = attack(playerDamage * 2, zoombeHP);
            } else {
                zoombeHP = attack(playerDamage, zoombeHP);
            }

            if (zoombeHP <= 0) {
                zoombeHP = 0;
                HP(zoombeName , zoombeHP);
                gameOver(playerName);
                break;
            }

            HP (playerName ,playerHP);

            if (rand.nextInt(100) > 30) {
                playerHP = attack(zoombeDamage * 2, playerHP);
            } else {
                playerHP = attack(zoombeDamage, playerHP);
            }

            if (playerHP <= 0) {
                playerHP = 0;
                HP(playerName , playerHP);
                gameOver(playerName);
                break;
            }
        }
        if (zoombeHP == 0) {
            int dropChance = rand.nextInt(100); // ← генеруємо ТУТ! / dropLoot(zoombeName, rand);
            zoombeName = "zoombe";
            ArrayList<String> inventory = new ArrayList<>();


            // Додаємо дроп в інвентар
            String loot = dropLoot(zoombeName, rand);
            inventory.add(loot);

            // Виводимо інвентар
            System.out.println("Інвентар:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }

        }
    }
}