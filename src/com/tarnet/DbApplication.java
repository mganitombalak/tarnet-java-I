package com.tarnet;

import java.net.ConnectException;
import java.sql.*;

public class DbApplication {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:h2:~/tarnet";
        String user = "sa";
        String password = "123456";
        String query = "SELECT * FROM Customer";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(connectionUrl, user, password);
            Statement stmt= conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
                System.out.printf("%d %s %n",resultSet.getInt(1),resultSet.getString(2));
            }
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
