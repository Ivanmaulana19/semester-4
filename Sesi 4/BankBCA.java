class BankBCA extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BCA adalah 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA";
        int biaya = hitungBiaya(bankTujuan);

        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (BCA)");
        System.out.println("Biaya transfer: Rp" + biaya);
    }
}