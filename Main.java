
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Bank bank = new Bank();

        // Memasukkan data pelanggan
        System.out.print("Masukkan nama depan: ");
        String depan = input.nextLine();

        System.out.print("Masukkan nama belakang: ");
        String belakang = input.nextLine();

        bank.addCustomer(depan, belakang);

        // Membuat rekening dengan saldo awal
        Customer pelanggan = bank.getCustomer(0);
        Account rekening = new Account(500000);
        pelanggan.setAccount(rekening);

        int pilihan;

        do {
            System.out.println("\n=== MENU ATM ===");
            System.out.println("1. Cek saldo");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println(
                        "Saldo: Rp" + (int) rekening.getBalance()
                    );
                    break;

                case 2:
                    System.out.print("Jumlah deposit: Rp");
                    double deposit = input.nextDouble();

                    if (rekening.deposit(deposit)) {
                        System.out.println("Deposit berhasil!");
                    } else {
                        System.out.println("Jumlah tidak valid!");
                    }
                    break;

                case 3:
                    System.out.print("Jumlah withdraw: Rp");
                    double withdraw = input.nextDouble();

                    if (rekening.withdraw(withdraw)) {
                        System.out.println("Withdraw berhasil!");
                    } else {
                        System.out.println(
                            "Udah Tau Saldo Dikit Malah Mau Narik Banyak :)"
                        );
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