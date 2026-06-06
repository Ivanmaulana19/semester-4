import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        
        // 1. Alamat lokasi baru file CSV sesuai yang kamu instruksikan
        String csvFile = "C:\\Users\\Ivan Maulana\\Documents\\SEMESTER 4\\Pemrograman Berorientasi Objek\\Sesi 11\\students.csv";
        String line;
        
        // 2. Menggunakan regex "[,;]" agar program bisa membaca pembatas KOMMA (,) maupun TITIK KOMA (;)
        // Ini solusi mutakhir agar tidak error meskipun Excel menyimpannya dalam format titik koma.
        String csvSplitBy = "[,;]";
        int indeks = 0;

        System.out.println("NIM, NAMA, UMUR, PRODI");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                indeks++;
                if (indeks > 1) {
                    String[] student = line.split(csvSplitBy);
                    
                    // 3. Validasi panjang array untuk mencegah ArrayIndexOutOfBoundsException
                    // Memastikan baris tersebut benar-benar memiliki minimal 4 kolom data sebelum dicetak
                    if (student.length >= 4) {
                        System.out.println(student[0].trim() + ", " + student[1].trim() + ", " + student[2].trim() + ", " + student[3].trim());
                    } else if (!line.trim().isEmpty()) {
                        // Jika ada baris yang formatnya rusak/kurang dari 4 kolom, infokan barisnya tanpa membuat program crash
                        System.out.println("[Peringatan] Baris ke-" + indeks + " formatnya tidak sesuai: " + line);
                    }
                }
            }
            System.out.println("--------------------------------");
            System.out.println("Total keseluruhan baris dalam file: " + indeks);
            System.out.println("Total baris data (tanpa header): " + (indeks - 1));

        } catch (IOException e) {
            System.out.println("Error: File tidak ditemukan di lokasi: " + csvFile);
            System.out.println("Pastikan file 'students.csv' benar-benar ada di folder 'Sesi 11' (bukan di dalam folder 'CODING').");
            e.printStackTrace();
        }
    }
}