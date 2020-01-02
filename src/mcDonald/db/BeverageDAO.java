package mcDonald.db;

import java.sql.*;

public class BeverageDAO {

    DBConnection dc = new DBConnection();

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public BeverageDTO initPan3() {

        con = dc.loadConnection();
        BeverageDTO beverage = new BeverageDTO();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from beverage");
            rs.first();
            beverage.name = rs.getString(1);
            beverage.price = rs.getInt(2);
            beverage.calorie = rs.getInt(3);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return beverage;
    }

    public BeverageDTO selectBeverageByName(String name) {

        con = dc.loadConnection();
        BeverageDTO beverage = new BeverageDTO();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from beverage where name = '" + name + "'");
            rs.next();
            beverage.name = rs.getString(1);
            System.out.println(beverage.name);
            beverage.price = rs.getInt(2);
            System.out.println(beverage.price);
            beverage.calorie = rs.getInt(3);
            System.out.println(beverage.calorie);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return beverage;
    }


}