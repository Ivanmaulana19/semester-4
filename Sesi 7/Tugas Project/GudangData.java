package com.pbo.project;
import java.util.ArrayList;

// Class Generic untuk menampung objek apapun
public class GudangData<T> {
    private ArrayList<T> daftar = new ArrayList<>(); // Collection

    public void tambah(T data) {
        daftar.add(data);
    }

    public ArrayList<T> getSemua() {
        return daftar;
    }
}