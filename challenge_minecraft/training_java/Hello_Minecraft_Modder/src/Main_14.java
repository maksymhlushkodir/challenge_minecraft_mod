class OldPlayer_1 {
    String name;
    int health;
    int damage;
    public void showStatus() {
        System.out.println(name + " має " + health + " HP " + " та " + damage + " урону.");
    }
}
class Zoombe {
    String name;
    int health;
    int damage;

    public  void showStatus() {
        System.out.println(name + " має " + health + " HP " + " та " + damage + " урону.");
    }
}
public class Main_14 {
    public static void main(String[] args) {
        // Player

        OldPlayer_1 player_1 = new OldPlayer_1();
        player_1.name = "Maksym";
        player_1.health = 100;
        player_1.damage = 30;

        player_1.showStatus();

        // Zoombe

        Zoombe zoombe = new Zoombe();
        zoombe.name = "zoombe";
        zoombe.health = 100;
        zoombe.damage = 20;

        zoombe.showStatus();

    }
}