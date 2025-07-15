class Sword {
    public String name;                   // Доступ усюди
    private int damage = 50;              // Доступ лише в цьому класі
    protected String rarity = "Epic";     // Доступ в підкласах та пакеті
    String material = "Diamond";          // (default) доступ лише в пакеті

    public void showInfo(){
        System.out.println(name + " | " + damage + " dmg | " + rarity + " | " + material);
    }
}

public class Main_21 {
    public static void main(String[] args) {
        Sword sword = new Sword();
        sword.name = "Diamond-sword";
        sword.showInfo();
    }
}
