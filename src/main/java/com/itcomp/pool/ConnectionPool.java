package com.itcomp.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private static final int POOL_SIZE = 5;
    private final BlockingQueue<AppConnection> connections;

    private static ConnectionPool instance;

    private ConnectionPool() {
        connections = new LinkedBlockingQueue<>();

        for (int i = 0; i < POOL_SIZE; i++) {
            connections.add(new AppConnection(i));
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public AppConnection getConnection() throws InterruptedException {
        return connections.take(); // thread-safe
    }

    public void releaseConnection(AppConnection connection) {
        connections.offer(connection);
    }
}