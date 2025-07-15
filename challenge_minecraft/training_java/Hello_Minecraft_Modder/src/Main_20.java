import java.util.ArrayList;

enum ItemType {
    RESOURCE,
    WEAPON,
    ARMOR,
    POTION
}
class Item_2 {
    String name;
    ItemType type;
    String rarity;
    String magic;

    public Item_2(String name, ItemType type,
                  String rarity, String magic) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.magic = magic;
    }

    @Override
    public String toString() {
        return name + "[" + type + ", " + rarity + ", " + magic + "]";
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
}
class Inventory_2 {
    ArrayList<Item_2> items = new ArrayList<>();

    public void addItems(Item_2 item_2) {
        items.add(item_2);
        System.out.println("Додано: " + item_2.name);
    }
    public void showInventory() {
        System.out.println("\n🎒 Інвентар:");
        for (Item_2 item_2 : items) {
            System.out.println("- " + item_2);
        }
    }
}
public class Main_20 {
    public static void main(String[] args) {
        int playerHP = 60;
        Item_2 stone_sword = new Item_2("stone-sword", ItemType.WEAPON,
                "ordinary", "sharpness 1");
        Item_2 iron_pants = new Item_2("iron-pants", ItemType.ARMOR,
                "ordinary", "one");
        Item_2 potion = new Item_2("heal-potion", ItemType.POTION,
                "звичайний", "+20HP");

        System.out.println("\n🎮 Використовуємо зілля...");
        Inventory_2 inventory = new Inventory_2();
        inventory.addItems(potion);
        inventory.addItems(stone_sword);
        inventory.addItems(iron_pants);
        inventory.showInventory();

        System.out.println("\n🧪 Ефект предмета:");
        potion.useItem(playerHP);
    }
}
