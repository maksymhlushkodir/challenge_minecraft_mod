public class Main_Mini_Game_Structured {
    //===<РАУНД>===
    public static void printRoundInfo(int roundNumber) {
        System.out.println("\n===================");
        System.out.println("⚔ РАУНД #" + roundNumber);
        System.out.println("===================\n");
    }
    //===<HP>===
    public static void showHP(String name, int HP) {
        System.out.println(name + "HP зараз:" + HP);
    }
    //===<GAME/OVER>===
    public static void gameOver(String winnerName) {
        System.out.println("\n=====================");
        System.out.println(" Переможець: " + winnerName + "!");
        System.out.println("=====================\n");
    }
    //===<attack>===
    public static int attack(int attackerDamage, int defenderHP) {
        return defenderHP - attackerDamage;

    }
    //===<Main>===
    public static void main(String[] args) {

        String playerName = "player";
        String zoombeName = "zoombe";

        int playerHP = 100;
        int zoombeHP = 100;
        int playerDamagr = 30;
        int zoombeDamage = 20;
        int numberRound = 1;


        while (playerHP > 0 && zoombeHP > 0) {

            printRoundInfo(numberRound);
            numberRound++;

            showHP(playerName, playerHP);
            playerHP = attack(zoombeDamage,playerHP);

            if (playerHP <= 0) {
                playerHP = 0;
                System.out.println("\nplayer HP зараз:"+ playerHP);
                gameOver(zoombeName);
                break;
            }
            showHP(zoombeName, zoombeHP);
            zoombeHP = attack(playerDamagr,zoombeHP);

            if (zoombeHP <= 0) {
                zoombeHP = 0;
                System.out.println("\nzoombe HP зараз:" + zoombeHP);
                gameOver(playerName);
                break;
            }
        }
    }
}