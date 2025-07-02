import java.util.Random;
import java.util.ArrayList;

public class Main_13 {

    public static void Drop(String drop) {
        System.out.println(drop);
    }

    public static String dropLoot(String mobName, Random rand) {
        String drop_1 = "Меч!";
        String drop_2 = "Курятину!";
        String drop_3 = "10 монет!";
        String drop_4 = "Нічого!";

        int dropChance = rand.nextInt(100);
        String drop;

        if (dropChance < 10) {
            drop = drop_1; // 0–9
        } else if (dropChance < 30) {
            drop = drop_2; // 10–29
        } else if (dropChance < 60) {
            drop = drop_3; // 30–59
        } else {
            drop = drop_4; // 60–99
        }

        Drop(mobName + " дропнув " + drop);
        return drop;  // повертаємо дроп, щоб додати його в інвентар
    }

    public static void main(String[] args) {
        String zoombeName = "zoombe";
        ArrayList<String> inventory = new ArrayList<>();
        Random rand = new Random();

        // Додаємо дроп в інвентар
        String loot = dropLoot(zoombeName, rand);
        inventory.add(loot);

        // Виводимо інвентар
        System.out.println("Інвентар:");
        for (String item : inventory) {
            System.out.println("- " + item);
        }
    }
}