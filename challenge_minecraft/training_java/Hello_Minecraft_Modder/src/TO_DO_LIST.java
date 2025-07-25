import java.util.ArrayList;

enum Priority{
    HIGH,
    MEDIUM,
    LOW
}

enum Status{
    DONE,
    NOT_DONE
}

class TASK{
    private String name;
    private String description;
    Status type_status;
    Priority type_priority;
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public TASK(String name, String description, int id,
                Status type_status, Priority type_priority) {
        this.name = name;
        this.description = description;
        this.type_status = type_status;
        this.type_priority = type_priority;
        this.id = id;
    }
    public void markAsDone() {
        if (this.type_status == Status.NOT_DONE) {  // Перевіряємо поточний статус
            this.type_status = Status.DONE;         // Змінюємо на DONE
        }
    }

    public void changePriority() {

    }

    @Override
    public String toString(){
        return "ID" + this.id + " name: " + this.name + " [" + this.description + ", "
                + this.type_priority + ", " + this.type_status + "]";
    }
}

class TODOLIST{
    ArrayList<TASK> ToDo = new ArrayList<>();

    public void addTask(String name, String description, int id,
                   Status type_status, Priority type_priority) {
        TASK newTASK = new TASK(name, description, id, type_status, type_priority);
        ToDo.add(newTASK);  // Додаємо ОДИН раз
        System.out.println("Завдання додано!");

    }

    public void deleteTask(int id) {
        for (TASK task : ToDo) {
            if (task.getId() == id) {
                ToDo.remove(task);
                System.out.println("Завдання видалено!");
                return;
            }
        }
        System.out.println("Id завдання не знайдено!");

    }

    public void showAllTasks() {
        if (ToDo.isEmpty()){
            System.out.println("Список завдань порожній!");
            return;
        } else {
            for (TASK task : ToDo) {
                System.out.println(task);
            }
        }

    }
    public void markAsDone(int id) {
        for (TASK task : ToDo) {
            if (task.getId() == id) {
                task.markAsDone();  // Викликаємо метод з класу TASK
                System.out.println("Завдання позначено як виконане!");
                return;
            }
        }
        System.out.println("Id завдання не знайдено!");
    }
}

public class TO_DO_LIST {
    public static void main(String[] args) {
        TODOLIST list = new TODOLIST();

        // Додаємо завдання
        list.addTask("Навчитися Java", "Вивчити ООП", 1, Status.NOT_DONE, Priority.HIGH);

        // Позначаємо як виконане
        list.markAsDone(1);

        // Перевіряємо список
        list.showAllTasks();
    }
}