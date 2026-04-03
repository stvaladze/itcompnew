package com.itcomp.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private static final int POOL_SIZE = 5;
    private final BlockingQueue<AppConnection> connections;

    private static ConnectionPool instance;

    private ConnectionPool() {
        connections = new LinkedBlockingQueue<>(POOL_SIZE);


        for (int i = 0; i < POOL_SIZE; i++) {
            connections.offer(new AppConnection(i));
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }


    public AppConnection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(AppConnection connection) {
        if (connection != null) {
            connections.offer(connection);
        }
    }
}