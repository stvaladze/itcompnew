package com.itcomp.pool;

public class AppConnection {

    private final int id;

    public AppConnection(int id) {
        this.id = id;
    }

    public void connect() {
        System.out.println("Connection " + id + " is used");
    }

    public int getId() {
        return id;
    }
}