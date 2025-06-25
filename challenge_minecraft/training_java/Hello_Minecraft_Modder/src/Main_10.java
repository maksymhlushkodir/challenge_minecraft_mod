public class Main_10 {
    public static void main(String[] args) {
        int playerHealth = 100;
        int zoombieDamage = 30;

        for (int i = 1; i <= 3; i++){
            playerHealth = playerHealth - zoombieDamage;
            System.out.println("Зомбі атакує! Удар № "+ i );
            System.out.println("HP героя зараз:" + playerHealth);
        }

        if (playerHealth <= 0){
            System.out.println("\nГравець помер!");
        }
        else {
            System.out.println("\nГравець вижив!");
        }
    }
}