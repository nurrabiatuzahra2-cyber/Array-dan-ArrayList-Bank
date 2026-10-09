
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        // Customer pertama
        System.out.print("Masukkan nama depan: ");
        String depan = input.nextLine();

        System.out.print("Masukkan nama belakang: ");
        String belakang = input.nextLine();

        bank.addCustomer(depan, belakang);

        // Rekening customer pertama
        Customer pelanggan = bank.getCustomer(0);
        pelanggan.setAccount(new Account(500000));

        int pilihan;

        do {
            System.out.println("\n=== MENU BANK ===");
            System.out.println("1. Cek saldo");
            System.out.println("2. Deposit (Tambah Saldo)");
            System.out.println("3. Withdraw (Tarik Saldo)");
            System.out.println("4. Tambah Customer");
            System.out.println("5. Lihat Daftar Customer");
            System.out.println("6. Pilih Customer");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println(
                        "Saldo: Rp" + (int) pelanggan.getAccount(0).getBalance()
                    );
                    break;

                case 2:
                    System.out.print("Jumlah deposit: Rp");
                    double deposit = input.nextDouble();

                    if (pelanggan.getAccount(0).deposit(deposit)) {
                        System.out.println("Deposit berhasil!");
                    } else {
                        System.out.println("Jumlah tidak valid!");
                    }
                    break;

                case 3:
                    System.out.print("Jumlah withdraw: Rp");
                    double withdraw = input.nextDouble();

                    if (pelanggan.getAccount(0).withdraw(withdraw)) {
                        System.out.println("Withdraw berhasil!");
                    } else {
                        System.out.println(
                            "Saldo tidak cukup atau jumlah tidak valid!"
                        );
                    }
                    break;

                case 4:
                    if (bank.getNumOfCustomers() >= 10) {
                        System.out.println("Kapasitas customer penuh!");
                        break;
                    }

                    System.out.print("Nama depan customer baru: ");
                    String namaDepan = input.nextLine();

                    System.out.print("Nama belakang customer baru: ");
                    String namaBelakang = input.nextLine();

                    bank.addCustomer(namaDepan, namaBelakang);

                    Customer baru = bank.getCustomer(
                        bank.getNumOfCustomers() - 1
                    );

                    baru.setAccount(new Account(500000));

                    System.out.println(
                        "Rekening dibuat dengan saldo awal Rp500000."
                    );
                    break;

                case 5:
                    System.out.println("\n=== DAFTAR CUSTOMER ===");

                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer c = bank.getCustomer(i);

                        System.out.println(
                            (i + 1) + ". " + c.getFirstName()
                            + " " + c.getLastName()
                        );
                    }
                    break;

                case 6:
                    System.out.println("\n=== PILIH CUSTOMER ===");

                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer c = bank.getCustomer(i);

                        System.out.println(
                            (i + 1) + ". " + c.getFirstName()
                            + " " + c.getLastName()
                        );
                    }

                    System.out.print("Masukkan nomor customer: ");
                    int nomor = input.nextInt();
                    input.nextLine();

                    Customer dipilih = bank.getCustomer(nomor - 1);

                    if (dipilih != null) {
                        pelanggan = dipilih;
                        System.out.println(
                            "Customer aktif: " + pelanggan.getFirstName()
                            + " " + pelanggan.getLastName()
                        );
                    } else {
                        System.out.println("Nomor customer tidak valid!");
                    }
                    break;

                case 0:
                    System.out.println("Oke Thanks Bro!");
                    break;

                default:
                    System.out.println("Plis Deh Pilih Yang Ada Aja Bisa ga?");
            }

        } while (pilihan != 0);

        input.close();
    }
}
