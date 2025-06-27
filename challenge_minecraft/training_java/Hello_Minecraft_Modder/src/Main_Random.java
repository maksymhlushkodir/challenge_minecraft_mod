import java.util.Random;

public class Main_Random {

    public static void printRoundInfo(int roundNumber) {
        System.out.println("\n===================");
        System.out.println("⚔ РАУНД #" + roundNumber);
        System.out.println("===================\n");
    }

    public static void HP(String Name ,int HP) {
        System.out.println("У " +Name + " зараз " + HP + " HP");
    }

    public static void gameOver(String winnerName) {
        System.out.println("\n=====================");
        System.out.println(" Переможець: " + winnerName + "!");
        System.out.println("=====================\n");
    }

    public static int attack(int attackerDamage, int defenderHP) {
        return defenderHP - attackerDamage;
    }

    public static void main(String[] args) {

        Random rand = new Random();

        String namePlayer_1 = "Player_1";
        String nameZoombe = "zoombe";

        int playerHP_1 = 100;
        int zoombeHP = 100;

        int playerDamage_1 = 30;
        int zoombeDamage = 20;

        int roundNumber = 1;

        while (playerHP_1 > 0 && zoombeHP > 0) {
            printRoundInfo(roundNumber);
            roundNumber++;

            HP(nameZoombe, zoombeHP);

            if (rand.nextInt(100) > 30) {
                zoombeHP = attack(playerDamage_1 * 2, zoombeHP);
                System.out.println("Ігрок атакує КРИТИЧНИЙ УДАР!\n");
            } else {
                zoombeHP = attack(playerDamage_1, zoombeHP);
                System.out.println("Ігрок атакує зомбі\n");

            }

            if (zoombeHP <= 0) {
                zoombeHP = 0;
                HP(nameZoombe, zoombeHP);
                gameOver(nameZoombe);
                break;
            }

            HP(namePlayer_1, playerHP_1);
            if (rand.nextInt(100) > 30) {
                playerHP_1 = attack(zoombeDamage * 2, playerHP_1);
                System.out.println("Зомбі атакує КРИТИЧНИЙ УДАР!\n");

            } else {
                playerHP_1 = attack(zoombeDamage, playerHP_1);
                System.out.println("Зомбі атакує ігрока\n");

            }
            if (playerHP_1 <= 0) {
                playerHP_1 = 0;
                HP(namePlayer_1, playerHP_1);
                gameOver(namePlayer_1);
                break;
            }
        }
    }
}