import java.util.ArrayList;

public class TransactionManagement {
    ArrayList<Transaction> transactions = new ArrayList<>();

    void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    void displayTransaction(){
        System.out.println("Last Transactions: ");
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }
}
