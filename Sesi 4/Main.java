public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        // Overloading
        bank.transferUang(100000, "123456");
        bank.transferUang(200000, "654321", "Mandiri");
        bank.transferUang(300000, "987654", "BCA", "Bayar kuliah");
        bank.sukuBunga();

        System.out.println("\n=== BANK BNI ===");
        BankBNI bni = new BankBNI();
        bni.sukuBunga();
        bni.transferUang(500000, "111222", "bebas");

        System.out.println("\n=== BANK BCA ===");
        BankBCA bca = new BankBCA();
        bca.sukuBunga();
        bca.transferUang(750000, "333444", "bebas");
    }
}