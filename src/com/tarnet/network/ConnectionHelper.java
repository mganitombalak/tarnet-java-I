package com.tarnet.network;

import lombok.SneakyThrows;
import lombok.val;
import lombok.var;
import org.h2.server.TcpServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHelper implements Runnable {

    private Socket connection;
    private String message;

    public ConnectionHelper(Socket connection,String message) {
        this.connection = connection;
        this.message=message;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("%s has been connected.%n",connection.getRemoteSocketAddress());
        val socketReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        val socketWriter=new PrintWriter(connection.getOutputStream(),true);
        var incomingMessage=socketReader.readLine();
        if(incomingMessage.equals("Exit")){
            TCPServer.Exit();
        }
        System.out.printf("%s -> %s%n", connection.getRemoteSocketAddress(),incomingMessage);
        socketWriter.println(message);
        socketWriter.flush();
        connection.close();
    }
}
