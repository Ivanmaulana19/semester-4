class Bank {

    // 1. Transfer sederhana
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan);
    }

    // 2. Transfer beda bank
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
    }

    // 3. Transfer + berita
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
        System.out.println("Berita: " + berita);
    }

    // 4. Suku bunga default
    void sukuBunga() {
        System.out.println("Suku bunga standar adalah 3%");
    }

    // BONUS: biaya transfer
    int hitungBiaya(String bankTujuan) {
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            return 3000;
        } else if (bankTujuan.equalsIgnoreCase("BCA")) {
            return 5000;
        } else {
            return 7000;
        }
    }
}