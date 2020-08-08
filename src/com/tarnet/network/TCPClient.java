package com.tarnet.network;

import lombok.val;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TCPClient {
    private static InetAddress Host;
    private static int Port = 81;
//    private static BufferedReader consoleReader;
    private static boolean isExited = false;

    public static void main(String[] args) throws IOException {
//        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        Host = InetAddress.getByName("localhost");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        IntStream.range(0, 50).forEach(t -> executorService.execute(() -> {
            try {
                connectToServer(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private static void connectToServer(int value) throws IOException {
        Socket connection = new Socket(Host, Port);
        val socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        val socketWriter = new PrintWriter(connection.getOutputStream(), true);
        do {
            String incomingMessage =socketReader.readLine();
            //System.out.printf("Enter message:");
            String outgoingMessage = (value == 900) ? "Exit" : "Hello from thread:" + Thread.currentThread().getId() + " @" + LocalDateTime.now();
            isExited = outgoingMessage.equals("exit") || outgoingMessage.equals("Exit");
            socketWriter.println(outgoingMessage);
            socketWriter.flush();

            System.out.printf("Server(%s):%s%n", connection.getRemoteSocketAddress(), incomingMessage);
        } while (!isExited);


    }
}
