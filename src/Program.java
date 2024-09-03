import java.util.Objects;
import java.util.Scanner;

public class Program {
    static BookManagement bookManagement = new BookManagement();
    static TransactionManagement transactionManagement = new TransactionManagement();
    static BorrowerManagement borrowerManagement = new BorrowerManagement();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Library Management System");
        int choice = -1;
        do {
            displayMenu();
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 0:
                    System.out.println("Thank you for using the Library Management System!");
                    System.exit(0);
                    System.out.println("\n\n");
                    break;
                case 1:
                    addNewBook();
                    System.out.println("\n\n");
                    break;
                case 2:
                    removeBook();
                    System.out.println("\n\n");
                    break;
                case 3:
                    bookManagement.displayBooks();
                    System.out.println("\n\n");
                    break;
                case 4:
                    registerNewBorrower();
                    System.out.println("\n\n");
                    break;
                case 5:
                    removeBorrower();
                    System.out.println("\n\n");
                    break;
                case 6:
                    borrowerManagement.displayBorrower();
                    System.out.println("\n\n");
                    break;
                case 7:
                    borrowBook();
                    System.out.println("\n\n");
                    break;
                case 8:
                    returnBook();
                    System.out.println("\n\n");
                    break;
                case 9:
                    generateBookAvailableReport();
                    System.out.println("\n\n");
                    break;
                case 10:
                    generateBorrowedBookReport();
                    System.out.println("\n\n");
                    break;
                default:
                    System.out.println("Please select a valid option");
                    System.out.println("\n\n");
                    break;

            }
        }while (choice!=0);
    }

    private static void generateBorrowedBookReport() {
        System.out.println("Borrowed books: ");
        bookManagement.displayBorrowBooks();
    }

    private static void generateBookAvailableReport() {
        System.out.println("Available books: ");
        bookManagement.displayAvailableBooks();
    }

    private static void borrowBook() {
        System.out.println("Enter borrower's Membership ID: ");
        String id = scan.nextLine();
        Borrower borrower=new Borrower("","","");
        boolean borrowerFound = false;
        for (int i = 0;i<borrowerManagement.borrowers.size();i++){
            if(Objects.equals(borrowerManagement.borrowers.get(i).membershipId, id)){
                borrower = borrowerManagement.borrowers.get(i);
                borrowerFound = true;
            }
        }
        if(!borrowerFound){
            System.out.println("Borrower Not found");
            return;
        }
        System.out.println("Enter book title ");
        String title = scan.nextLine();
        Book book=new Book("","","",false);
        boolean found = false;
        for (int i = 0;i<bookManagement.books.size();i++){
            if(Objects.equals(bookManagement.books.get(i).title, title)){
                book = bookManagement.books.get(i);
                found = true;
            }
        }
        if(found){
            bookManagement.borrowBook(book);
            bookManagement.addBorrowBook(book);
            transactionManagement.addTransaction(new Transaction(book,borrower,"Borrow"));
            System.out.println("Book borrowed successfully!");
            return;
        }
        System.out.println("Book not found");
    }

    private static void returnBook() {
        System.out.println("Enter borrower's Membership ID: ");
        String id = scan.nextLine();
        Borrower borrower=new Borrower("","","");
        boolean borrowerFound = false;
        for (int i = 0;i<borrowerManagement.borrowers.size();i++){
            if(Objects.equals(borrowerManagement.borrowers.get(i).membershipId, id)){
                borrower = borrowerManagement.borrowers.get(i);
                borrowerFound = true;
            }
        }
        if(!borrowerFound){
            System.out.println("Borrower Not found");
            return;
        }
        System.out.println("Enter book title ");
        String title = scan.nextLine();
        Book book=new Book("","","",false);
        boolean found = false;
        for (int i = 0;i<bookManagement.books.size();i++){
            if(Objects.equals(bookManagement.books.get(i).title, title)){
                book = bookManagement.books.get(i);
                found = true;
            }
        }
        if(found){
            bookManagement.returnBook(book);
            bookManagement.removeBorrowBook(book);
            transactionManagement.addTransaction(new Transaction(book,borrower,"Return"));
            System.out.println("Book returned successfully!");
            return;
        }
        System.out.println("Book not found");
    }

    private static void removeBorrower() {
        System.out.println("Choose the borrower to remove: ");
        for (int i = 0;i<borrowerManagement.borrowers.size();i++){
            System.out.println((i+1)+". " + borrowerManagement.borrowers.get(i));
        }
        int index = Integer.parseInt(scan.nextLine());
        borrowerManagement.removeBorrower(index-1);
    }

    private static void registerNewBorrower() {
        System.out.println("Registering a Borrower:");
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scan.nextLine();
        System.out.print("Enter Membership ID: ");
        String memId = scan.nextLine();
        borrowerManagement.registerBorrower(new Borrower(name,contact,memId));
        System.out.println("Borrower registered successfully!");
    }

    private static void removeBook() {
        System.out.println("Choose the book to remove: ");
        for (int i = 0;i<bookManagement.books.size();i++){
            System.out.println((i+1)+". " + bookManagement.books.get(i));
        }
        int index = Integer.parseInt(scan.nextLine());
        bookManagement.removeBook(index-1);
    }

    private static void addNewBook() {
        System.out.println("Adding a Book:");
        System.out.print("Enter Title: ");
        String title = scan.nextLine();
        System.out.print("Enter Author: ");
        String author = scan.nextLine();
        System.out.print("Enter Category: ");
        String cat = scan.nextLine();
        bookManagement.addBook(new Book(title,author,cat,true));
        System.out.println("Book added successfully!");
    }


    private static void displayMenu() {
        System.out.println("Book Management");
        System.out.println("""
                 1. Add a book
                 2. Remove a book
                 3. Display available books\
                """);
        System.out.println("Borrower Management");
        System.out.println("""
                 4. Register a borrower
                 5. Remove a borrower
                 6. Display registered borrowers\
                """);
        System.out.println("Transaction Management");
        System.out.println("""
                 7. Borrow a book
                 8. Return a book\
                """);
        System.out.println("Reports");
        System.out.println("""
                 9. Generate book availability report
                 10. Generate borrowed books report\
                """);
        System.out.println("0. Exit");
        System.out.print("Choose an option:  ");
    }
}
