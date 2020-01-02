package mcDonald.db;

import java.sql.*;

public class BurgerDAO {

    DBConnection dc = new DBConnection();

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public BurgerDTO initPan3() {

        con = dc.loadConnection();
        BurgerDTO burger = new BurgerDTO();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from burger");
            rs.first();
            burger.name = rs.getString(1);
            burger.price = rs.getInt(2);
            burger.calorie = rs.getInt(3);
            burger.info = rs.getString(4);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return burger;
    }

    // 이름에 맞춰 버거의 칼럼들을 가져옵니다.
    public BurgerDTO selectBurgerByName(String name) {

        con = dc.loadConnection();
        BurgerDTO burger = new BurgerDTO();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from burger where name = '" + name + "'");
            rs.next();
            burger.name = rs.getString(1);
            System.out.println(burger.name);
            burger.price = rs.getInt(2);
            System.out.println(burger.price);
            burger.calorie = rs.getInt(3);
            System.out.println(burger.calorie);
            burger.info = rs.getString(4);
            System.out.println(burger.info);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return burger;
    }

    // 이름에 맞춰 버거 세트의 칼럼들을 가져옵니다.
    public BurgerDTO selectBurgerSetByName(String name) {

        con = dc.loadConnection();
        BurgerDTO burger = new BurgerDTO();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from burgerset where name = '" + name + "'");
            rs.next();
            burger.name = rs.getString(1);
            System.out.println(burger.name);
            burger.price = rs.getInt(2);
            System.out.println(burger.price);
            burger.calorie = rs.getInt(3);
            System.out.println(burger.calorie);
            burger.info = rs.getString(4);
            System.out.println(burger.info);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return burger;
    }

    public void selectAll() {
        con = dc.loadConnection();

        for (int i = 0; i < 12; i++) {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from burger");
                while (rs.next()) {
                    System.out.print("이름: " + rs.getString(1));
                    System.out.print(", 가격: " + rs.getString(2));
                    System.out.print(", 칼로리: " + rs.getString(3));
                    System.out.println(", 정보: " + rs.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int insertBurger(BurgerDTO b) {

        con = dc.loadConnection();

        try {
            pstmt = con.prepareStatement("insert into burger values (?,?,?,?)");
            pstmt.setString(1, b.name);
            pstmt.setInt(2, b.price);
            pstmt.setInt(3, b.calorie);
            pstmt.setString(4, b.info);

            System.out.println(b.name + "추가 되었습니다.");
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int insertBurgerSet(BurgerDTO bSet) {

        con = dc.loadConnection();

        try {
            pstmt = con.prepareStatement("insert into burgerSet values (?,?,?,?)");
            pstmt.setString(1, bSet.name);
            pstmt.setInt(2, bSet.price);
            pstmt.setInt(3, bSet.calorie);
            pstmt.setString(4, bSet.info);

            System.out.println(bSet.name + "추가 되었습니다.");
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        BurgerDAO burgerDAO = new BurgerDAO();
        System.out.println(burgerDAO.selectBurgerByName("빅맥").price);
    }


}