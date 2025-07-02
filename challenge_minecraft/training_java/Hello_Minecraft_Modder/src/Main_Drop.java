import javax.print.DocFlavor;
import java.util.Random;

public class Main_Drop {
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
    public static void drop(String Name, String drop) {
        System.out.println("\n" + Name + " дропнув" + drop);
    }

    public static int attack (int attackerDamage, int defenderHP) {
        return defenderHP - attackerDamage;
    }

    public static void HP(String Name ,int HP) {
        System.out.println("У " + Name + " зараз " + HP + " HP");
    }

    public static void dropLoot(Random rand) {
        int dropChance = rand.nextInt(100);
    }

    //public static void dropLoot(String mobName, Random rand) {
    //    int dropChance = rand.nextInt(100);
    //
    //    if (dropChance < 10) {
    //        drop(mobName, " Меч!");
    //    } else if (dropChance < 30) {
    //        drop(mobName, " Курятину!");
    //    } else if (dropChance < 60) {
    //        drop(mobName, " 10 монет!");
    //    } else {
    //        drop(mobName, " Нічого");
    //    }
    //}

    public static void main(String[] args) {

        String drop_1 = " Меч!";
        String drop_2 = " Курятину!";
        String drop_3 = " 10 монет!";
        String drop_4 = " Нічого";

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
            if (dropChance < 10) {
                drop(zoombeName, drop_1);
            } else if (dropChance < 30) {
                drop(zoombeName, drop_2);
            } else if (dropChance < 60) {
                drop(zoombeName, drop_3);
            } else {
                drop(zoombeName, drop_4);
            }

        }
    }
}