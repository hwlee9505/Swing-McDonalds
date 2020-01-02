package mcDonald.db;

import java.sql.*;

public class SubDAO {

    DBConnection dc = new DBConnection();

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public SubDTO initPan3() {

        con = dc.loadConnection();
        SubDTO sub = new SubDTO();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from sub");
            rs.first();
            sub.name = rs.getString(1);
            sub.price = rs.getInt(2);
            sub.calorie = rs.getInt(3);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return sub;
    }

    public SubDTO selectSubByName(String name) {

        con = dc.loadConnection();
        SubDTO sub = new SubDTO();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from sub where name = '" + name + "'");
            rs.next();
            sub.name = rs.getString(1);
            System.out.println(sub.name);
            sub.price = rs.getInt(2);
            System.out.println(sub.price);
            sub.calorie = rs.getInt(3);
            System.out.println(sub.calorie);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return sub;
    }


}