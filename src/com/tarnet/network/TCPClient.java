package com.tarnet.network;

import com.tarnet.desktop.MainForm;
import lombok.val;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    private static InetAddress Host;
    private static int Port = 81;
    private static BufferedReader consoleReader;
    private static boolean isExited = false;

    public static void main(String[] args) throws IOException {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        Host = InetAddress.getLocalHost();
        connectToServer(null);
    }

    public static void connectToServer(String s) throws IOException {
        Socket connection = new Socket(Host, Port);
        val socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        val socketWriter = new PrintWriter(connection.getOutputStream(), true);
        do {
            if(s!=null) {
                System.out.printf("Enter message:");
                String outgoingMessage = consoleReader.readLine();
                isExited = outgoingMessage.equals("exit") || outgoingMessage.equals("Exit");
                socketWriter.println(outgoingMessage);
                System.out.printf("Server(%s):%s%n", connection.getRemoteSocketAddress(), socketReader.readLine());
                MainForm.summary.setText(s);
            }
        } while (!isExited);


    }
}
