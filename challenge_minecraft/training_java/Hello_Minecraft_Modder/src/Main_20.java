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
        Item_2 stone_sword = new Item_2("stone-sword", ItemType.WEAPON,
                "ordinary", "sharpness 1");
        Item_2 iron_pants = new Item_2("iron-pants", ItemType.ARMOR,
                "ordinary", "one");

        Inventory_2 inventory = new Inventory_2();
        inventory.addItems(stone_sword);
        inventory.addItems(iron_pants);
        inventory.showInventory();
    }
}
