import java.util.ArrayList;

enum Permission {
    USER,
    ADMIN
}

class User {
    private String userName;
    private String email;
    private int id;
    Permission type;


    // Геттери
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public User(String userName, String email,
                int id, Permission type) {
        this.userName = userName;
        this.email = email;
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString(){
        return "ID " + id + " [" + userName  + ", " + email +" ," + type + "]";
    }
}

class Admin {
    private ArrayList<User> users = new ArrayList<>();

    // 1. Додати користувача
    public void addUser(String userName, String email, int id, Permission type) {
        User newUser = new User(userName, email, id, type);
        users.add(newUser);
        System.out.println("✅ Користувача '" + userName + "' додано!");
    }

    // 2. Видалити користувача (по ID)
    public void removeUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                System.out.println("\n❌ Користувача " + user.getUserName() + " видалено!");
                return;
            }
        }
        System.out.println("⚠️ Користувача з ID " + id + " не знайдено!");
    }
    // 3. Показати всіх користувачів
    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("📭 Список користувачів порожній!");
            return;
        }
        System.out.println("\nСписок користувачів:");
        for (User user : users) {
            System.out.println(user); // Використовуємо toString()
        }
    }
}

public class система_користувачів {
    public static void main(String[] args) {
        Admin admin = new Admin();

        // Додаємо користувачів
        admin.addUser("Maksym", "maksymhlushko00@gmail.com", 385, Permission.USER);
        admin.addUser("Naoufal", "Npdf4@gmail.com", 257, Permission.USER);
        admin.addUser("Daniel", "Gamba1@gmail.com", 204, Permission.USER);

        // Показуємо список
        admin.showUsers();

        // Видаляємо користувача maksym
        admin.removeUser(385);

        // Показуємо оновлений список
        admin.showUsers();
    }
}
