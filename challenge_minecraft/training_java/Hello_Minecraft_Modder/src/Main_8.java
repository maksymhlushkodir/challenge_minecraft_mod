public class Main_8 {
    public static void main(String[] args) {

        int playerHealth = 100;
        int zoombieDamage = 20;

        for (int i = 1; i <= 5; i++) {
            playerHealth = playerHealth - zoombieDamage;

            System.out.println("Зомбі атакує! Удар №" + i);
            System.out.println("HP героя зараз:" + playerHealth);
        }

        if (playerHealth <= 0) {
            System.out.println("Гравець помер!");
        } else {
            System.out.println("Гравець вижив!");
        }
    }
}