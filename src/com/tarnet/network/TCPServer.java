package com.tarnet.network;

import com.tarnet.desktop.MainForm;
import com.tarnet.thread.Counter;
import lombok.val;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    private static final int Port = 81;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        System.out.println("Opening port");
        serverSocket = new ServerSocket(Port);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable t1 = () -> {
            System.out.printf("%d Port has been open on %s%n", Port, serverSocket.getInetAddress().getHostAddress());
            do {
                try {
                    listen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (true);
        };
        Runnable t2 = () -> {
            System.out.printf("%d Port has been open on %s%n", Port, serverSocket.getInetAddress().getHostAddress());
            do {
                try {
                    listen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (true);
        };
        executor.execute(t1);
        executor.execute(t2);
        executor.shutdown();
//        localhost 127.0.0.1 - Loopback Interface
//        0.0.0.0
    }

    private static void listen() throws IOException {
        Socket connection = serverSocket.accept();
        val socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.printf("%s -> %s %s%n", connection.getRemoteSocketAddress(), socketReader.readLine(), MainForm.messageArea);
        connection.close();
    }
}
