public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    // Constructor
    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Menambahkan pelanggan baru
    public void addCustomer(String firstName, String lastName) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers] =
                new Customer(firstName, lastName);

            numberOfCustomers++;
            System.out.println("Customer berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas customer sudah penuh!");
        }
    }

    // Accessor jumlah pelanggan
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // Mengambil pelanggan berdasarkan index
    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];
        }

        return null;
    }
}
