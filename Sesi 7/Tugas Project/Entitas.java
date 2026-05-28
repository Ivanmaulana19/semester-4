package com.pbo.project;

public abstract class Entitas {
    private String id; // Encapsulation

    public Entitas(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public abstract void Role(); // Abstract method
}