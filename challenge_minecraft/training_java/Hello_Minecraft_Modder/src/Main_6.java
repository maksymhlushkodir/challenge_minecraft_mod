public class Main_6 {
    public static void main(String[] args) {

        //Minecraft Кузня
        int ironIngots = 45;
        int swordsCrafted = ironIngots / 2;
        int theRestOfTheIron = ironIngots % 2;
        
        System.out.println("Всього заліза: " + ironIngots);
        System.out.println("Можна зробити: " + swordsCrafted + " меча");
        System.out.println("Залишилось заліза: " + theRestOfTheIron);
    }
}
