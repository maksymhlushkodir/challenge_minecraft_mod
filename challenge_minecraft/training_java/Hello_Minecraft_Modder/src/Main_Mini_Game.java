public class Main_Mini_Game {
    public static int  attack_player(int zoombeHP,int playerDamage) {
        return zoombeHP - playerDamage;
    }
    public static int attack_zoombe(int playerHP, int zoombeDamage) {
        return playerHP - zoombeDamage;
    }
    public static void main(String[] args) {
        int playerHP = 100;
        int playerDamage = 30;
        int zoombeHP = 100;
        int zoombeDamage = 20;

        while (playerHP > 0 && zoombeHP > 0) {


            zoombeHP = attack_player(zoombeHP, playerDamage);
            System.out.println("HP зомбі:" + zoombeHP);

            if (zoombeHP <= 0) {
                zoombeHP = 0;
                break;
            }

            playerHP = attack_zoombe(playerHP, zoombeDamage);
            System.out.println("HP Гравця:" + playerHP);

            if (playerHP <= 0){
                playerHP = 0;
                break;
            }

            if (playerHP <= 0) {
                System.out.println("\nГравець загинув! Зомбі переміг!");
            } else {
                System.out.println("\nзомбі загинув! гравець переміг!");
            }

        }
    }



}