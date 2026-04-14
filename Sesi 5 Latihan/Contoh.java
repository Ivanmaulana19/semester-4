class Tabungan {
    double saldo;  //tidak dienkapsulasi

    void tambah (double jumlah) {
        saldo += jumlah;
    }

    void ambil (double jumlah) {
        saldo -= jumlah;
    }

    void infoSaldo(){
        System.out.print("Saldo :" + saldo);
    }
}

public class Contoh {
    public static void main(String[] args) {
        Tabungan Ivan = new Tabungan();
        //bisa di ubah langsung
        Ivan.tambah(100000);
        Ivan.ambil(50000);//diubah melaluii methood stter
        //ivan.ambil(50000);
        Ivan.infoSaldo();
    }
}