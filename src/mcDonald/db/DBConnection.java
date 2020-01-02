package mcDonald.db;

import java.sql.*;

public class DBConnection {

    Connection con = null;

    String url = "jdbc:mysql://localhost:3306/mcdonalds?&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
    String user = "root";
    String password = "0330";

    //JDBC load와 connect
    public Connection loadConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("JDBC 적재 성공");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 적재 실패...");
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        } catch (SQLException e) {
            System.err.println("DB 연결 실패...");
            e.printStackTrace();
        }

        return con;
    }

    //각각의 basePan들의 3번째 패널들을 디비의 첫 내용으로 초기화 시켜주려함

}
