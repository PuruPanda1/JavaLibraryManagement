import java.util.ArrayList;
import java.util.Objects;

public class BookManagement {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    void addBook(Book book){
        books.add(book);
    }

    void removeBook(int index){
        books.remove(index);
    }

    void displayBooks(){
        for(int i = 0;i<books.size();i++){
            System.out.println((i+1)+". "+books.get(i));
        }
    }

    void addBorrowBook(Book book){
        borrowedBooks.add(book);
    }

    void removeBorrowBook(Book book){
        borrowedBooks.removeIf(bk -> Objects.equals(bk.title, book.title));
    }

    void displayBorrowBooks(){
        for(int i = 0;i<borrowedBooks.size();i++){
            System.out.println((i+1)+". "+borrowedBooks.get(i));
        }
    }

    void displayAvailableBooks(){
        for(int i = 0;i<books.size();i++){
            if(books.get(i).isAvailable){
                System.out.println((i+1)+". "+books.get(i));
            }
        }
    }

    void borrowBook(Book book){
        book.setAvailable(false);
    }

    void returnBook(Book book){
        book.setAvailable(true);
    }
}
