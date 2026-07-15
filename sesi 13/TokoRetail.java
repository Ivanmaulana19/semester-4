import java.sql.*;
import java.util.Scanner;

public class TokoRetail {
    // Konfigurasi Database (Sesuaikan dengan XAMPP/MySQL kamu)
    static final String DB_URL = "jdbc:mysql://localhost:3306/toko_retail";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Membuka koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            int pilihan;
            do {
                showMenu();
                System.out.print("Pilihan : ");
                // Mengambil input angka
                pilihan = Integer.parseInt(scanner.nextLine()); 
                
                switch (pilihan) {
                    case 1: tampilData(); break;
                    case 2: tambahData(); break;
                    case 3: cariData(); break;
                    case 4: ubahData(); break;
                    case 5: hapusData(); break;
                    case 0: 
                        System.out.println("Keluar dari program..."); 
                        break;
                    default: 
                        System.out.println("Pilihan tidak valid!");
                }
            } while (pilihan != 0);

            // Menutup koneksi
            scanner.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal koneksi ke database. Pastikan XAMPP/MySQL berjalan.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Harap masukkan angka yang valid.");
        }
    }

    static void showMenu() {
        System.out.println("\n==================================");
        System.out.println("        MENU TOKO RETAIL");
        System.out.println("==================================");
        System.out.println("1. Tampil Semua Data");
        System.out.println("2. Tambah Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Ubah Data");
        System.out.println("5. Hapus Data");
        System.out.println("0. Keluar");
    }

    static void tampilData() throws SQLException {
        String sql = "SELECT * FROM barang";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n=======================================================");
        System.out.println("              DAFTAR BARANG TOKO RETAIL                ");
        System.out.println("=======================================================");
        System.out.printf("| %-3s | %-6s | %-15s | %-7s | %-5s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("-------------------------------------------------------");

        int count = 1;
        while (rs.next()) {
            System.out.printf("| %-3d | %-6s | %-15s | %-7d | %-5d |\n", 
                count, 
                rs.getString("kode"), 
                rs.getString("nama_barang"), 
                rs.getInt("harga"), 
                rs.getInt("stok")
            );
            count++;
        }
        System.out.println("=======================================================");
        System.out.println("Total: " + (count - 1) + " barang");
        
        rs.close();
        stmt.close();
    }

    static void tambahData() throws SQLException {
        System.out.println("\n-- TAMBAH DATA --");
        System.out.print("Masukkan Kode: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan Stok: ");
        int stok = Integer.parseInt(scanner.nextLine());

        String sql = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, kode);
        pstmt.setString(2, nama);
        pstmt.setInt(3, harga);
        pstmt.setInt(4, stok);

        int affected = pstmt.executeUpdate();
        if(affected > 0) System.out.println("✅ Data berhasil ditambahkan!");
        pstmt.close();
    }

    static void cariData() throws SQLException {
        System.out.println("\n-- CARI DATA --");
        System.out.print("Masukkan Kode atau Nama Barang: ");
        String keyword = scanner.nextLine();

        String sql = "SELECT * FROM barang WHERE kode LIKE ? OR nama_barang LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        pstmt.setString(2, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();

        System.out.println("\n=======================================================");
        System.out.printf("| %-3s | %-6s | %-15s | %-7s | %-5s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("-------------------------------------------------------");
        
        int count = 1;
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.printf("| %-3d | %-6s | %-15s | %-7d | %-5d |\n", 
                count++, rs.getString("kode"), rs.getString("nama_barang"), rs.getInt("harga"), rs.getInt("stok"));
        }
        if(!found) {
            System.out.println("|                 DATA TIDAK DITEMUKAN                |");
        }
        System.out.println("=======================================================");
        
        rs.close();
        pstmt.close();
    }

    static void ubahData() throws SQLException {
        System.out.println("\n-- UBAH DATA --");
        System.out.print("Masukkan Kode barang yang akan diubah: ");
        String kode = scanner.nextLine();

        String checkSql = "SELECT * FROM barang WHERE kode = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setString(1, kode);
        ResultSet rs = checkStmt.executeQuery();

        if (!rs.next()) {
            System.out.println("❌ Barang tidak ditemukan!");
            return;
        }

        System.out.println("Data saat ini: " + rs.getString("nama_barang") + " | Harga: " + rs.getInt("harga") + " | Stok: " + rs.getInt("stok"));
        
        System.out.print("Masukkan Nama Barang Baru: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga Baru: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan Stok Baru: ");
        int stok = Integer.parseInt(scanner.nextLine());

        String updateSql = "UPDATE barang SET nama_barang=?, harga=?, stok=? WHERE kode=?";
        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
        updateStmt.setString(1, nama);
        updateStmt.setInt(2, harga);
        updateStmt.setInt(3, stok);
        updateStmt.setString(4, kode);

        updateStmt.executeUpdate();
        System.out.println("✅ Data berhasil diubah!");
        
        rs.close();
        checkStmt.close();
        updateStmt.close();
    }

    static void hapusData() throws SQLException {
        System.out.println("\n-- HAPUS DATA --");
        System.out.print("Masukkan Kode barang yang akan dihapus: ");
        String kode = scanner.nextLine();

        String sql = "DELETE FROM barang WHERE kode=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, kode);

        int affected = pstmt.executeUpdate();
        if (affected > 0) {
            System.out.println("✅ Data berhasil dihapus!");
        } else {
            System.out.println("❌ Barang tidak ditemukan!");
        }
        pstmt.close();
    }
}