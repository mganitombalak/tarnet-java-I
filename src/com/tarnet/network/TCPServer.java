package com.tarnet.network;

import lombok.val;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TCPServer {
    private static final int Port = 81;
    private static ServerSocket serverSocket;
    private static ExecutorService executorService;
    private static boolean isExited = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Opening port");
        serverSocket = new ServerSocket(Port);
        System.out.printf("%d Port has been open on %s%n", Port, serverSocket.getInetAddress().getHostAddress());
        executorService = Executors.newFixedThreadPool(100);
        do {
            listen();
        } while (!isExited);
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
//        localhost 127.0.0.1 - Loopback Interface
//        0.0.0.0
    }

    public static synchronized void Exit() {
        isExited = true;
    }

    private static void listen() throws IOException, InterruptedException {
        val t = new Thread(() -> {
            Socket connection = null;
            try {
                connection = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            executorService.execute(new ConnectionHelper(connection, "Hello from server " + LocalDateTime.now()));
        });
        t.start();
        t.join();
    }
}
