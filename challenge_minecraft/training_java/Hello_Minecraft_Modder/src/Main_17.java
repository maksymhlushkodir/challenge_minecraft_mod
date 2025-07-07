import java.util.Random;
import java.util.ArrayList;

class OldPlayer_3 {
    //Клас ігрока
    // Ім'я
    String name;
    // хп
    int health;
    // урон
    int damage;
    // інвентарь
    ArrayList<String> inventory = new ArrayList<>();

    // скороцення
    public OldPlayer_3(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // атака
    public void attack(Emeny_1 emeny) {
        // шанс до кріта
        Random rand = new Random();
        int CritRange = rand.nextInt(100);

        // кріт або ні
        if (CritRange > 70) {
            emeny.health -= this.damage * 2;
            System.out.println(this.name + " атакує " + emeny.name + " на " + (this.damage * 2) + " урону (крит)!");
        } else {
            emeny.health -= this.damage;
            System.out.println(this.name + " атакує " + emeny.name + " на " + this.damage + " урону!");
        }
    }
    public void GameOver() {
        System.out.println("\n===========");
        System.out.println("==" + this.name + " помер==");
        System.out.println("===========\n");
    }
    public void HP() {
        System.out.println("У " + this.name +" зараз " + this.health + " HP");
    }

}

class Emeny_1 {
    // клас ворога
    // Ім'я
    String name;
    // хп
    int health;
    // урон
    int damage;


    // скороцення
    public Emeny_1(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // атака
    public void attack(OldPlayer_3 player) {
        // кріт
        Random rand = new Random();
        int CritRange = rand.nextInt(100);

        // кріт або ні
        if (CritRange > 80) {
            player.health -= this.damage * 2;
            System.out.println(this.name + " атакує " + player.name + " на " + (this.damage * 2) + " урону (крит)!");
        } else {
            player.health -= this.damage;
            System.out.println(this.name + " атакує " + player.name + " на " + this.damage + " урону!");
        }
    }
    public void HP() {
        System.out.println("У " + this.name +" зараз " + this.health + " HP");
    }
    // дроп
    public void DropsMode(OldPlayer_3 player) {
        // перевірка а потім підрахунок
        while (this.health <= 0) {
            Random rand = new Random();
            int Drops = rand.nextInt(100);

            if (Drops < 2) {
                System.out.println("Iron Ingot");
                player.inventory.add("Iron Ingot");
                break;
            } else if (Drops < 30) {
                System.out.println("Potato");
                player.inventory.add("Potato");
                break;
            } else if (Drops < 40) {
                System.out.println("Baked Potato");
                player.inventory.add("Baked Potato");
                break;
            } else if (Drops < 50) {
                System.out.println("Potato");
                player.inventory.add("Potato");
                break;
            } else if (Drops < 90) {
                int DropsRottenFlesh = rand.nextInt(100);
                if (DropsRottenFlesh < 10) {
                    System.out.println("Rotten Flesh: 2");
                    player.inventory.add("Rotten Flesh");
                    player.inventory.add("Rotten Flesh");
                    break;
                } else if (DropsRottenFlesh < 50) {
                    System.out.println("Rotten Flesh: 1");
                    player.inventory.add("Rotten Flesh");
                    break;
                } else {
                    System.out.println("Rotten Flesh: 0");
                    break;
                }
            } else {
                System.out.println("none");
                break;
            }
        }
    }
    public void GameOver() {
        System.out.println("\n===========");
        System.out.println("==" + this.name + " помер==");
        System.out.println("===========\n");
    }
}

public class Main_17 {

    // раунд
    public static void RaundInt(int raundInt) {
        System.out.println("\n===========");
        System.out.println("==РАУНД #" + raundInt + "==");
        System.out.println("===========\n");
    }

    // вивод
    public static void main(String[] args) {

    OldPlayer_3 player_1 = new OldPlayer_3("Maksym", 100, 30);
    Emeny_1 zoombe = new Emeny_1("zoombe", 100 , 20);

    int RaundNumber = 1;

    while (player_1.health > 0 && zoombe.health > 0) {

        RaundInt(RaundNumber++);
        player_1.attack(zoombe);
        zoombe.HP();
        player_1.HP();

        if (zoombe.health <= 0){
            zoombe.health = 0;
            zoombe.GameOver();
            zoombe.DropsMode(player_1);
            System.out.println(player_1.inventory);
            break;
        }

        zoombe.attack(player_1);
        if (player_1.health <= 0) {
            player_1.health = 0;
            player_1.GameOver();
            break;
        }
    }
    }
}