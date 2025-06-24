public class Main_9 {
    public static void main(String[] args) {
        int playerIron = 30;

        int helmetIron = 5;
        int bibIron = 8;
        int pantsIron = 7;
        int bootsIron = 4;

        if (playerIron >= helmetIron) {
            playerIron -= helmetIron;
            System.out.println("Ви зробили шолом! Заліза залишилось: " + playerIron);
        } else {
            System.out.println("Недостатньо заліза для шолома!");
        }

        if (playerIron >= bibIron) {
            playerIron -= bibIron;
            System.out.println("Ви зробили нагрудник! Заліза залишилось: " + playerIron);
        } else {
            System.out.println("Недостатньо заліза для нагрудника!");
        }

        if (playerIron >= pantsIron) {
            playerIron -= pantsIron;
            System.out.println("Ви зробили штани! Заліза залишилось: " + playerIron);
        } else {
            System.out.println("Недостатньо заліза для штанів!");
        }

        if (playerIron >= bootsIron) {
            playerIron -= bootsIron;
            System.out.println("Ви зробили черевики! Заліза залишилось: " + playerIron);
        } else {
            System.out.println("Недостатньо заліза для черевиків!");
        }
    }
}