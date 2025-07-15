enum ItemType_1 {
    RESOURCE,
    WEAPON,
    ARMOR,
    POTION
}

class Item_3 {
    private String name;
    private ItemType_1 type;
    private String rarity;
    private String magic;

    public Item_3(String name, ItemType_1 type,
                  String rarity, String magic) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.magic = magic;
    }

    @Override
    public String toString() {
        return this.name + "[ " + this.type + ", " + this.rarity + ", " + this.magic + " ]";
    }
}

public class Main_22 {
    public static void main(String[] args) {
        Item_3 sword = new Item_3("Iron-sword", ItemType_1.WEAPON,
                "Normal", "One");

        System.out.println(sword); // автоматично викличе toString()
    }
}
