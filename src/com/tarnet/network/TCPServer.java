package com.tarnet.network;

import lombok.val;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private static final int Port = 81;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        System.out.println("Opening port");
        serverSocket = new ServerSocket(Port);
        System.out.printf("%d Port has been open on %s%n", Port, serverSocket.getInetAddress().getHostAddress());
        do {
            listen();
        } while (true);
//        localhost 127.0.0.1 - Loopback Interface
//        0.0.0.0
    }

    private static void listen() throws IOException {
        Socket connection = serverSocket.accept();
        val socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.printf("%s -> %s%n", connection.getRemoteSocketAddress(), socketReader.readLine());
        connection.close();
    }
}
