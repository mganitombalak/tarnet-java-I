package com.tarnet;

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
            Statement stmt = conn.createStatement();
//            ResultSet resultSet = stmt.executeQuery(query); // Connected -> DataReader
//            while(resultSet.next()){
//                System.out.printf("%d %s %n",resultSet.getInt(1),resultSet.getString(2));
//            }
//            stmt.close();
//            conn.close();

//            RowSet rs = new CachedRowSetImpl();
//            rs.setUrl(connectionUrl);
//            rs.setCommand(query);
//            rs.setUsername(user);
//            rs.setPassword(password);
//            rs.execute();
//            while (rs.next()){
//                System.out.printf("%d %s %n",rs.getInt(1),rs.getString(2));
//            }
//            rs.close();

//            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
//            cachedRowSet.populate(resultSet);
//            stmt.close();
//            while (cachedRowSet.next()) {
//                System.out.printf("%d %s %n", cachedRowSet.getInt(1), cachedRowSet.getString(2));
//                if (cachedRowSet.getInt(1) == 2) {
//                    cachedRowSet.updateString(2, "Edirne Tarim Koop");
//                    cachedRowSet.updateRow();
//                }
//            }
//            cachedRowSet.setTableName("customer");
//            cachedRowSet.acceptChanges(conn);
            conn.setAutoCommit(false);
            String query1 = "UPDATE Customer set Name='Tekirdag Tarim Koop' Where id=2";
            stmt.executeUpdate(query1);
            Savepoint sp = conn.setSavepoint("TekirdagUpdated");
            String query2 = "UPDATE Customer set Name='Antalya Tarim Koop' Where id=1";
            stmt.executeUpdate(query2);
            // FATAL ERROR
            conn.rollback(sp);
            conn.commit();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
