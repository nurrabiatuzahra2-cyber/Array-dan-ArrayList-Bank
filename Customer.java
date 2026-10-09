
import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts = new ArrayList<>();

    // Constructor
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }

    // Accessor nama depan
    public String getFirstName() {
        return firstName;
    }

    // Accessor nama belakang
    public String getLastName() {
        return lastName;
    }

    // Menambahkan rekening ke ArrayList
    public void setAccount(Account acct) {
        accounts.add(acct);
    }

    // Mengambil rekening berdasarkan index
    public Account getAccount(int account_index) {
        return accounts.get(account_index);
    }

    // Mengambil jumlah rekening
    public int getNumOfAccounts() {
        return accounts.size();
    }
}