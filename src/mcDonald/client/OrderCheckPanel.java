package mcDonald.client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderCheckPanel extends JPanel {

    //num은 들어오는 줄마다 한개한개씩 늘리기로 한다.
    String[] header = {"num", "name", "price"};
    public DefaultTableModel model = new DefaultTableModel(header, 0);
    public JTable table = new JTable(model);

//    String[][] contents = {
//            {"0", "Test1버거", "Test1000"}
//    };

    public JPanel pan1 = new JPanel();
    public JPanel pan2 = new JPanel(new GridLayout(1,4));
    public JPanel pan3 = new JPanel();

    // 장바구니에 보일 총 칼로리
    public int totalCalorie = 0;
    // 장바구니에 보일 총 가격
    public int totalPrice = 0;

    public JLabel calorieLab = new JLabel("총 칼로리: ");
    public JLabel priceLab = new JLabel("    총 가격: ");
    public JLabel calorieLab2 = new JLabel("0kcal");
    public JLabel priceLab2 = new JLabel("0원");
    public JButton payBtn = new JButton("결제하기");
    public JButton cancelBtn = new JButton("취소하기");


    public OrderCheckPanel() {

        JScrollPane sp = new JScrollPane(table);
        pan1.add(sp);

        pan2.add(calorieLab);
        pan2.add(calorieLab2);
        pan2.add(priceLab);
        pan2.add(priceLab2);

        pan3.add(payBtn);
        pan3.add(cancelBtn);

        this.setLayout(new GridLayout(3,1));
        this.add(pan1);
        this.add(pan2);
        this.add(pan3);


    }

}
