class BankBNI extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BNI adalah 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI";
        int biaya = hitungBiaya(bankTujuan);

        System.out.println("Transfer Rp" + jumlah + " ke " + rekeningTujuan + " (BNI)");
        System.out.println("Biaya transfer: Rp" + biaya);
    }
}