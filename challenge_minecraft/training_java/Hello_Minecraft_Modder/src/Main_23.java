//
import java.util.Random;
import java.util.ArrayList;

//
enum ItemType_2 {
    RESOURCE,
    WEAPON,
    POTION,
    ARMOR
}

class Item_4 {
    private String name;
    private ItemType_2 type;
    private String rarity;
    private String magic;

    // Геттер для поля name
    public String getName() {
        return this.name;
    }

    public Item_4(String name, ItemType_2 type,
                  String rarity, String magic) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.magic = magic;
    }

    public void useItem(int currentHP) {
        switch (type) {
            case POTION:
                int healedHP = currentHP + 20;
                if (healedHP > 100) healedHP = 100;
                System.out.println("💊 Ви використали зілля. HP стало: " + healedHP);
                break;

            case WEAPON:
                System.out.println("🗡 Ви озброїлись " + name + ". Урон: " + magic);
                break;

            case ARMOR:
                System.out.println("🛡 Ви екіпірували " + name + ". Захист: " + magic);
                break;

            case RESOURCE:
                System.out.println("📦 Ви зберегли ресурс: " + name);
                break;
        }
    }
    @Override
    public String toString() {
        return this.name + " [" + this.type + ", " + this.rarity + ", " + this.magic + "]";
    }
}

class Drop {
    public static Item_4 generateDrop() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 60)
            return new Item_4("Small Potion", ItemType_2.POTION, "Common", "+20 HP");
        // ...
        return null;
    }
}

//
class Inventory_3 {
    ArrayList<Item_4> items = new ArrayList<>();

    public void addItems(Item_4 item4) {
        items.add(item4);
        System.out.println("Додано: " + item4.getName());
    }
    public void showInventory() {
        System.out.println("\n Інвентар:\"");
        for (Item_4 item4 : items) {
            System.out.println("- " + item4);
        }
    }
}

//
class Player {
    String name;
    int health;
    int damage;
    Inventory_3 inventory;

    // Геттер для поля name
    public String getName() {
        return this.name;
    }

    public Player(String name, int health,
                  int damage, Inventory_3 inventory) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.inventory = inventory;
    }

    public int attack(Enemy_1 enemy1) {
        Random rand = new Random();
        int crit = rand.nextInt(100);

        if (crit < 70) {  // 70% шанс крита
            int critDamage = (int)(this.damage * 2);  // Прибавляємо 50% урону
            enemy1.health -= critDamage;
            System.out.println(this.name + " атакує " + enemy1.getName() +
                    " та наносить КРІТ УРОН! " + critDamage);
            return critDamage;  // Повертаємо урон для логування
        } else {
            enemy1.health -= this.damage;
            System.out.println(this.name + " атакує " + enemy1.getName() +
                    " та наносить урон! " + this.damage);
            return this.damage;  // Повертаємо звичайний урон
        }
    }
}

class Enemy_1 {
    private String name;
    int health;
    int damage;
    private double dropChance; // Шанс випадання дропу (наприклад 0.7 = 70%)
    private Item_4[] possibleDrops; // Можливі предмети для дропу

    // Геттер
    public String getName() {
        return this.name;
    }
    public Enemy_1(String name, int health, int damage,
                   double dropChance, Item_4[] possibleDrops) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.dropChance = dropChance;
        this.possibleDrops = possibleDrops;

    }
    public int attack(Player player) {
        Random rand = new Random();
        int crit = rand.nextInt(100);

        if (crit < 70) {  // 70% шанс крита
            int critDamage = (int)(this.damage * 2);  // Прибавляємо 50% урону
            player.health -= critDamage;
            System.out.println(this.name + " атакує " + player.getName() +
                    " та наносить КРІТ УРОН! " + critDamage);
            return critDamage;  // Повертаємо урон для логування
        } else {
            player.health -= this.damage;
            System.out.println(this.name + " атакує " + player.getName() +
                    " та наносить урон! " + this.damage);
            return this.damage;  // Повертаємо звичайний урон
        }
    }
    public Item_4 dropItem() {
        Random rand = new Random();
        if (rand.nextDouble() < dropChance && possibleDrops.length > 0) {
            // Вибираємо випадковий предмет з можливих
            return possibleDrops[rand.nextInt(possibleDrops.length)];
        }
        return null; // Нічого не випало
    }
}

class Game {
    public static void fight(Player player, Enemy_1 enemy1){
        while (player.health > 0 && enemy1.health > 0) {
            player.attack(enemy1);
            enemy1.attack(player);
        }
        // Після бою перевіряємо, хто виграв
        if (enemy1.health <= 0) {
            System.out.println(enemy1.getName() + " помер!");

            // Перевіряємо дроп
            Item_4 droppedItem = enemy1.dropItem();
            if (droppedItem != null) {
                System.out.println("З ворога випав предмет: " + droppedItem.getName());
                player.inventory.addItems(droppedItem);
            } else {
                System.out.println("Нічого не випало...");
            }
        }
    }
}


public class Main_23 {
    public static void main(String[] args) {
        Item_4 [] zombieDrops = {
                new Item_4("Small Potion", ItemType_2.POTION, "Common", "+20 HP"),
                new Item_4("Rusty Sword", ItemType_2.WEAPON, "Common", "5-8 damage"),
                new Item_4("Rotten Flesh", ItemType_2.RESOURCE, "Common", "Can be sold")
        };

        // Створюємо ворога з 70% шансом дропу
        Enemy_1 zombie = new Enemy_1("Zombie", 100, 10, 0.7, zombieDrops);
        // Створюємо гравця
        Inventory_3 inv = new Inventory_3();
        Player player = new Player("Hero", 150, 20, inv);

        // Починаємо бій
        Game.fight(player, zombie);
    }
}