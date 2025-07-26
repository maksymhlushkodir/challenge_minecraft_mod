import java.util.ArrayList;

class Book{

    private String title;
    private String author;
    private int year;
    private String genre;
    private int id;

    public int getId(){
        return id;
    }

    public Book(String title, String author, int year, String genre, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.id = id;
    }

    @Override
    public String toString(){
        return this.title + " [" + author + ", " + year + ", " + genre + ", " + id + "]";
    }
}

class Library{
    ArrayList<Book> library = new ArrayList<>();

    public void addBook(String title, String author,
                        int year, String genre, int id){
        Book newbook = new Book(title, author, year, genre, id);
        library.add(newbook);
        System.out.println("Книгу додано!");
        return;
    }

    public void removeBook(int id){
        for (Book book : library) {
            if (book.getId() == id) {
                library.remove(book);
                System.out.println("Книгу видалено!");
                return;
            }
        }
    }

    public void searchBook(int id){
        for (Book book : library) {
            if (book.getId() == id) {
                System.out.println(book);
                return; // Щоб не продовжував шукати після знаходження
            }
        }
        System.out.println("Книгу не знайдено");
    }

    public void listBooks(){
        if (library.isEmpty()) {
            System.out.println("Немає книг!");
        } else {
            for (Book book : library) {
                System.out.println("- " + book);
            }
        }
    }
}

public class Library_manager {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Апокаліпсис: Мережа", "Maksym UGO", 2029,
                "Post-apocalypse, Techno-thriller, Social drama", 243);
        library.addBook("Книга", "---", 2004,
                "Cyberpunk", 267);

        library.searchBook(243);

        library.listBooks();

        library.removeBook(243);

        library.listBooks();
    }
}
