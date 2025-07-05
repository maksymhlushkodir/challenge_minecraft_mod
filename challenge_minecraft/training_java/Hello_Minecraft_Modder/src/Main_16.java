class OldPlayer_2 {
    String name;
    int health;
    int damage;


    public OldPlayer_2(String name, int health, int damage) {
            this.name = name;
            this.health = health;
            this.damage = damage;
    }

    public void attack(Enemy enemy) {
        enemy.health -= this.damage;
        System.out.println(this.name + " атакує " + enemy.name + " на " + this.damage + " урону!");
    }
}
class Enemy {
    String name;
    int health;
    int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void attack(OldPlayer_2 player) {
        player.health -= this.damage;
        System.out.println(this.name + " кусає " + player.name + " на " + this.damage + " урону!");
    }
}
public class Main_16 {
    public static void main(String[] args) {
        OldPlayer_2 player = new OldPlayer_2("Maksym", 100, 30);
        Enemy zoombe = new Enemy("Zoombe", 100, 20);

        while (player.health > 0 && zoombe.health > 0) {
            player.attack(zoombe);
            zoombe.attack(player);

            if (zoombe.health <= 0) {
                zoombe.health = 0;
                System.out.println(zoombe.name + " загинув!");
                break;
            }
            if (player.health <= 0) {
                player.health = 0;
                System.out.println(player.name + " загинув!");
                break;
            }
        }
    }
}