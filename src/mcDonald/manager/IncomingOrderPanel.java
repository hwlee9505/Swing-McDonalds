package mcDonald.manager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IncomingOrderPanel extends JPanel {

    String[] header = {"clientNum", "name", "price", "date"};
    public DefaultTableModel model = new DefaultTableModel(header, 0);
    public JTable table = new JTable(model);

    public IncomingOrderPanel() {

        JScrollPane sp = new JScrollPane(table);
        this.add(sp);

    }


}
