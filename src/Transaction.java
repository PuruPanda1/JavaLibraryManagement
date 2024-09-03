public class Transaction {
    Book book;
    Borrower borrower;
    String operation;

    public Transaction(Book book, Borrower borrower, String operation) {
        this.book = book;
        this.borrower = borrower;
        this.operation = operation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(boolean isBorrow) {
        if(isBorrow){
            this.operation = "Borrow";
            return;
        }
        this.operation = "Return";
    }

    @Override
    public String toString() {
        return "BorrowerId: " + borrower.membershipId + ", Book Title: " + book.title + ", Operation: " + operation;
    }
}
