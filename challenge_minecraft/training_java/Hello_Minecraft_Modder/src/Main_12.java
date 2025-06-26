public class Main_12 {

    public static int attackEnemy (int playerDamage,int enemyHP ) {
        return enemyHP - playerDamage;
    }

    public static void main(String[] args) {
        int playerDamage = 30;
        int enemyHP = 100;


        for (int i = 1; i <= 3; i++) {
            enemyHP = attackEnemy(playerDamage, enemyHP); // ← ось тут головне
            System.out.println("Гравець атакує! У ворога залишилось HP: " + enemyHP);
        }
        if (enemyHP <0 ) {
            System.out.println("\nВорог переможений!");
        } else {
            System.out.println("\nВорог НЕ переможений!");
        }
    }
}