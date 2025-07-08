class Pet {
    String name;
    String type;
    String sound;

    public Pet(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(name + " каже: " + sound);
    }

    @Override
    public String toString() {
        return "Це " + type + " на ім’я " + name + ". Вона каже \"" + sound + "\".";
    }
}

public class Main_18 {
    public static void main(String[] args) {
        Pet MyCatPixel = new Pet("pixel", "cat", "may");

        MyCatPixel.makeSound();
        System.out.println(MyCatPixel);
    }
}
