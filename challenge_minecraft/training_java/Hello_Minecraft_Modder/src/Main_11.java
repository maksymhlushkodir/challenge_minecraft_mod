public class Main_11 {
    public static void main(String[] args) {
        int playerHealth = 40;
        int healthSecond = 15;
        boolean runHealth = true;

        while (runHealth){
            if (playerHealth >= 100) {
                playerHealth = 100;
                System.out.println("Гравець повністю зцілений! HP зараз: " + playerHealth);
                runHealth = false;
            }
            else {
                playerHealth += healthSecond;
                System.out.println("Герой лікується... HP зараз:" + playerHealth);
            }
        }
    }
}