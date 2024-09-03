import java.util.ArrayList;

public class BorrowerManagement {
    ArrayList<Borrower> borrowers = new ArrayList<>();

    void registerBorrower(Borrower borrower){
        borrowers.add(borrower);
    }

    void removeBorrower(int index){
        borrowers.remove(index);
    }

    void displayBorrower(){
        for(int i = 0;i<borrowers.size();i++){
            System.out.println((i+1)+". "+borrowers.get(i));
        }
    }
}
