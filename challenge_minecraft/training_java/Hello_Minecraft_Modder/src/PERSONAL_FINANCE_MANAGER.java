import java.time.LocalDate;
import java.util.ArrayList;

enum Category{
    FOOD,
    TRANSPORTATION,
    ENTERTAINMENT,
    CLOTHING,
    OTHER
}
enum Type{
    INCOME,
    EXPENSES
}

class Transaction{
    private double amount;
    private Category type_category;
    private Type type_type;
    private LocalDate date;
    private String description;
    private int id;
    private  double expenditures;

    public int getId(){
        return id;
    }

    public Transaction(double amount, Category type_category, Type type_type,
                       LocalDate date, String description, int id, double expenditures){
        this.amount = amount;
        this.type_category = type_category;
        this.type_type = type_type;
        this.date = date;
        this.description = description;
        this.id = id;
        this.expenditures = expenditures;
    }

    public void changeCategory(Category newCategory){
        this.type_category = newCategory; // Просто присвоюємо нову категорію!
        System.out.println("Категорію змінено на: " + newCategory);
    }
    public String changeDescription(String newdescription){
        this.description = newdescription;
        System.out.println(newdescription);
        return newdescription;

    }
}
class Wallet{
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(double amount, Category type_category,
                               Type type_type, LocalDate date,
                               String description, int id, double expenditures){
        Transaction transaction = new Transaction(amount, type_category,
                type_type, date, description, id, expenditures);
        amount -= expenditures;
        if (amount >= 0) {
            System.out.println("недостатність коштів");
        } else  {
            transactions.add(transaction);
            System.out.println("Додано!");
            return;
        }
    }
    public void deleteTransaction(int id){
        for (Transaction transaction : transactions){
            if (transaction.getId() == id){
                transactions.remove(transaction);
                System.out.println("видалено!");
                return;
            }
        }

    }
    public void showAllTransactions(){
        if (transactions.isEmpty()) {
            System.out.println("Немає нічого");
        } else {
            for (Transaction transaction : transactions)
                System.out.println("- " + transaction);
        }

    }
    public void showBalance(double amount){
        System.out.println("Дохіт -" + amount);

    }
    public void filterByCategory(){

    }
}

public class PERSONAL_FINANCE_MANAGER {
}
