package mcDonald.manager;

import javax.swing.*;
import java.util.Vector;

public class McCrews extends JFrame {

    public JTabbedPane tab;
    public JPanel[] basePanel1 = new JPanel[1];
    public Vector rowData = null;
    public int clientNum = 0;

    public McCrews() {
        this.setTitle("McCrew 관리자 모드");
        this.setSize(500, 700);
        this.setLocation(1200, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tab = new JTabbedPane(JTabbedPane.TOP);

        basePanel1[0] = new IncomingOrderPanel();
        tab.add("방금 들어온 주문", basePanel1[0]);

        this.add(tab);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new McCrews();
    }

}
