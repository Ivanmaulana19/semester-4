package com.pbo.project;

public class Admin extends Entitas implements LayananData {
    private String nama;

    public Admin(String id, String nama) {
        super(id);
        this.nama = nama;
    }

    @Override
    public void Role() {
        System.out.println("Akses: Administrator Penuh");
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Admin ID: " + getId() + " | Nama: " + nama);
    }
}