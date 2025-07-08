import java.util.ArrayList;

class Item {
    String name;
    String type;
    String rarity;
    String magic;

    public Item(String name, String type, String rarity, String magic) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.magic = magic;
    }

    @Override
    public String toString() {
        return name + " [" + type + ", " + rarity +  ", " + magic + "]";
    }
}
class Inventory {
    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Додано: " + item.name);
    }

    public void showInventory() {
        System.out.println("\n🎒 Інвентар:");
        for (Item item : items ) {
            System.out.println("- " + item);
        }
    }
}

public class Main_19 {
    public static void main(String[] args) {
        Item sword_diamond = new Item("Діамантовий меч", "Зброя", "Рідкісний", "гострота 3");
        Item diamond = new Item("Діамант", "Ресурс", "Рідкісний", "не має чарів");

        Inventory inventory = new Inventory();
        inventory.addItem(sword_diamond);
        inventory.addItem(diamond);
        inventory.showInventory();
    }
}