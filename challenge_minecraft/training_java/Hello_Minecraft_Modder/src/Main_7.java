public class Main_7 {
    public static void main(String[] args) {
        int playerHealth = 34;
        int zombieDamage = 25;

        playerHealth = playerHealth - zombieDamage;

        if (playerHealth > 0) {
            System.out.println("Гравець ще живий! Залишилось HP: " + playerHealth);
        } else {
            System.out.println("GAME OVER");
        }
    }
}