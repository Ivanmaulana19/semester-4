import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    String grade;

    void hitungGrade() {
        if (nilai >= 80) {
            grade = "A";
        } else if (nilai >= 70) {
            grade = "B";
        } else if (nilai >= 60) {
            grade = "C";
        } else if (nilai >= 50) {
            grade = "D";
        } else {
            grade = "E";
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine();

        Mahasiswa[] mhs = new Mahasiswa[jumlah];

        int totalNilai = 0;

        int lulus = 0;
        int tidakLulus = 0;

        int jumlahA = 0;
        int jumlahB = 0;
        int jumlahD = 0;

        String namaLulus = "";
        String namaTidakLulus = "";
        String namaA = "";
        String namaB = "";
        String namaD = "";

        for (int i = 0; i < jumlah; i++) {

            mhs[i] = new Mahasiswa();

            System.out.println("\nData Mahasiswa ke-" + (i + 1));

            System.out.print("NIM  : ");
            mhs[i].nim = input.nextLine();

            System.out.print("Nama : ");
            mhs[i].nama = input.nextLine();

            System.out.print("Nilai: ");
            mhs[i].nilai = input.nextInt();
            input.nextLine();

            mhs[i].hitungGrade();

            totalNilai += mhs[i].nilai;

            if (mhs[i].nilai >= 60) {
                lulus++;
                namaLulus += mhs[i].nama + ", ";
            } else {
                tidakLulus++;
                namaTidakLulus += mhs[i].nama + ", ";
            }

            if (mhs[i].grade.equals("A")) {
                jumlahA++;
                namaA += mhs[i].nama + ", ";
            }

            if (mhs[i].grade.equals("B")) {
                jumlahB++;
                namaB += mhs[i].nama + ", ";
            }

            if (mhs[i].grade.equals("D")) {
                jumlahD++;
                namaD += mhs[i].nama + ", ";
            }
        }

        System.out.println("\n==============================");

        for (int i = 0; i < jumlah; i++) {
            System.out.println("NIM  : " + mhs[i].nim);
            System.out.println("Nama : " + mhs[i].nama);
            System.out.println("Nilai: " + mhs[i].nilai);
            System.out.println("Grade: " + mhs[i].grade);
            System.out.println("==============================");
        }

        double rata = (double) totalNilai / jumlah;

        System.out.println("Jumlah Mahasiswa : " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + namaLulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + namaTidakLulus);

        System.out.println("Jumlah Mahasiswa dengan Nilai A : " + jumlahA + " yaitu " + namaA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B : " + jumlahB + " yaitu " + namaB);
        System.out.println("Jumlah Mahasiswa dengan Nilai D : " + jumlahD + " yaitu " + namaD);

        System.out.println("Rata-rata nilai mahasiswa adalah : " + rata);
    }
}