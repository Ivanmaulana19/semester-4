package com.pbo.project;

public class MainApp {
    public static void main(String[] args) {
        // Inisialisasi Object
        Admin adm = new Admin("ADM-001", "Riki Hardianto");

        // Simpan ke dalam Generic Collection
        GudangData<Admin> db = new GudangData<>();
        db.tambah(adm);

        System.out.println("--- LAPORAN SISTEM ---");
        for (Admin a : db.getSemua()) {
            a.tampilkanDetail(); // Polymorphism
            a.Role();            // Abstract Implementation
        }
    }
}