package main;

import mcDonald.client.*;
import mcDonald.db.*;
import mcDonald.manager.IncomingOrderPanel;
import mcDonald.manager.McCrews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class MyaddActionListener implements ActionListener {

    McDonalds mcDonalds;
    BurgerDAO burgerDAO = new BurgerDAO();
    BurgerDTO burgerDTO = new BurgerDTO();
    BeverageDAO beverageDAO = new BeverageDAO();
    BeverageDTO beverageDTO = new BeverageDTO();
    SubDAO subDAO = new SubDAO();
    SubDTO subDTO = new SubDTO();

    public MyaddActionListener(McDonalds mcDonalds) {
        this.mcDonalds = mcDonalds;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //==============================BURGER PANEL================================//
        // pan2의 버거이미지 라벨을 눌렀을때 pan3의 디비 내용이 변경된다.
        for (int i = 0; i < ((BugerPanel) (mcDonalds.basePanel2[0])).burgers.length; i++) {
            if (e.getSource() == ((BugerPanel) (mcDonalds.basePanel2[0])).burgerBtn[i]) {
                String name = ((BugerPanel) (mcDonalds.basePanel2[0])).burgers[i];
                burgerDTO = burgerDAO.selectBurgerByName(name);
                ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].setText(burgerDTO.name);
                ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[1].setText(burgerDTO.price + "원");
                ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[2].setText(burgerDTO.calorie + "kcal");
                ((BugerPanel) (mcDonalds.basePanel2[0])).ta.setText(burgerDTO.info);
                ((BugerPanel) (mcDonalds.basePanel2[0])).rb[0].setSelected(true);
            }

        }
        // 장바구니 담기 버튼
        if (((BugerPanel) mcDonalds.basePanel2[0]).sumbit == e.getSource()) {

            String name = ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].getText();
            mcDonalds.rowData = new Vector();
            if (((BugerPanel) (mcDonalds.basePanel2[0])).rb[0].isSelected() == true) {
                burgerDTO = burgerDAO.selectBurgerByName(name);

                mcDonalds.rowData.addElement(++mcDonalds.orderNum);
                mcDonalds.rowData.addElement(burgerDTO.name);
                mcDonalds.rowData.addElement(burgerDTO.price);

                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie += burgerDTO.calorie;
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice += burgerDTO.price;
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie + "kcal");
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice + "원");
//                if(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie > 2500){
//                    ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setFont(new Font("Serif",Font.BOLD,20));
//                    ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setForeground(Color.RED);
//                }

                ((OrderCheckPanel) (mcDonalds.basePanel2[3])).model.addRow(mcDonalds.rowData);

            }
            if (((BugerPanel) (mcDonalds.basePanel2[0])).rb[1].isSelected() == true) {
                burgerDTO = burgerDAO.selectBurgerSetByName(name);
                mcDonalds.rowData.addElement(++mcDonalds.orderNum);
                mcDonalds.rowData.addElement(burgerDTO.name + " 세트");
                mcDonalds.rowData.addElement(burgerDTO.price);

                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie += burgerDTO.calorie;
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice += burgerDTO.price;
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText("" + ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie + "kcal");
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText("" + ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice + "원");
//                if(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie > 2500){
//                    ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setFont(new Font("Serif",Font.BOLD,20));
//                    ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setForeground(Color.RED);
//                }

                ((OrderCheckPanel) (mcDonalds.basePanel2[3])).model.addRow(mcDonalds.rowData);

            }
        }

        //============================BEVERAGE PANEL================================//
        // pan2의 음료이미지 라벨을 눌렀을때 pan3의 디비 내용이 변경된다.
        for (int i = 0; i < ((BeveragePanel) (mcDonalds.basePanel2[1])).beverages.length; i++) {
            if (e.getSource() == ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageBtn[i]) {
                String name = ((BeveragePanel) (mcDonalds.basePanel2[1])).beverages[i];
                beverageDTO = beverageDAO.selectBeverageByName(name);
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[0].setText(beverageDTO.name);
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[1].setText(beverageDTO.price + "원");
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[2].setText(beverageDTO.calorie + "kcal");
                ((BeveragePanel) (mcDonalds.basePanel2[1])).rb[0].setSelected(true);
            }

        }
        // 장바구니 담기 버튼
        if (((BeveragePanel) mcDonalds.basePanel2[1]).sumbit == e.getSource()) {

            String name = ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[0].getText();
            System.out.println("name :" + name);
            beverageDTO = beverageDAO.selectBeverageByName(name);
            mcDonalds.rowData = new Vector();
            if (((BeveragePanel) (mcDonalds.basePanel2[1])).rb[0].isSelected() == true) {
                mcDonalds.rowData.addElement(++mcDonalds.orderNum);
                mcDonalds.rowData.addElement(beverageDTO.name + "(S)");
                mcDonalds.rowData.addElement(beverageDTO.price);

                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie += beverageDTO.calorie;
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice += beverageDTO.price;
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie + "kcal");
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice + "원");

            }
            if (((BeveragePanel) (mcDonalds.basePanel2[1])).rb[1].isSelected() == true) {
                mcDonalds.rowData.addElement(++mcDonalds.orderNum);
                mcDonalds.rowData.addElement(beverageDTO.name + "(M)");
                mcDonalds.rowData.addElement(beverageDTO.price + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusPrice[0]);

                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie += beverageDTO.calorie + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusCalrie[0];
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice += beverageDTO.price + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusPrice[0];
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie + "kcal");
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice + "원");

            }

            if (((BeveragePanel) (mcDonalds.basePanel2[1])).rb[2].isSelected() == true) {
                mcDonalds.rowData.addElement(++mcDonalds.orderNum);
                mcDonalds.rowData.addElement(beverageDTO.name + "(L)");
                mcDonalds.rowData.addElement(beverageDTO.price + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusPrice[1]);

                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie += beverageDTO.calorie + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusCalrie[1];
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice += beverageDTO.price + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusPrice[1];
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie + "kcal");
                ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice + "원");
            }
            ((OrderCheckPanel) (mcDonalds.basePanel2[3])).model.addRow(mcDonalds.rowData);
        }

        //==============================SUB PANEL===================================//
        for (int i = 0; i < ((SubPanel) (mcDonalds.basePanel2[2])).subs.length; i++) {
            if (e.getSource() == ((SubPanel) (mcDonalds.basePanel2[2])).subBtn[i]) {
                String name = ((SubPanel) (mcDonalds.basePanel2[2])).subs[i];
                subDTO = subDAO.selectSubByName(name);
                ((SubPanel) (mcDonalds.basePanel2[2])).subLab2[0].setText(subDTO.name);
                ((SubPanel) (mcDonalds.basePanel2[2])).subLab2[1].setText(subDTO.price + "원");
                ((SubPanel) (mcDonalds.basePanel2[2])).subLab2[2].setText(subDTO.calorie + "kcal");

            }

        }
        // 장바구니 담기 버튼

        if (((SubPanel) mcDonalds.basePanel2[2]).sumbit == e.getSource()) {
            String name = ((SubPanel) (mcDonalds.basePanel2[2])).subLab2[0].getText();
            subDTO = subDAO.selectSubByName(name);
            mcDonalds.rowData = new Vector();
            mcDonalds.rowData.addElement(++mcDonalds.orderNum);
            mcDonalds.rowData.addElement(subDTO.name);
            mcDonalds.rowData.addElement(subDTO.price);

            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie += subDTO.calorie;
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice += subDTO.price;
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie + "kcal");
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText(((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice + "원");

            ((OrderCheckPanel) (mcDonalds.basePanel2[3])).model.addRow(mcDonalds.rowData);
        }

        // 결제하기
        // 장바구니 패널에 있는 내용을 manager패키지에 있는 IncomingOrderPanel에 담은후 모두 지워버리기
        if (((OrderCheckPanel) mcDonalds.basePanel2[3]).payBtn == e.getSource()) {


            SimpleDateFormat format = new SimpleDateFormat("MM/dd/HH/mm/ss");
            Calendar time = Calendar.getInstance();
            String format_time = format.format(time.getTime());
            McCrews mcCrews = new McCrews();

            mcCrews.clientNum += 1;

            int count = ((OrderCheckPanel) mcDonalds.basePanel2[3]).model.getRowCount();


            for (int i = 0; i < count; i++) {
                mcDonalds.rowData = new Vector();
                mcCrews.rowData = new Vector();
                mcCrews.rowData.addElement(mcCrews.clientNum);
                Object value = ((OrderCheckPanel) (mcDonalds.basePanel2[3])).table.getValueAt(i, 1);
                mcCrews.rowData.addElement(value);
                Object value2 = ((OrderCheckPanel) (mcDonalds.basePanel2[3])).table.getValueAt(i, 2);
                mcCrews.rowData.addElement(value2);
                mcCrews.rowData.addElement(format_time);
                ((IncomingOrderPanel) (mcCrews.basePanel1[0])).model.addRow(mcCrews.rowData);

            }


            for (int i = 0; i < count; i++) {
                ((OrderCheckPanel) mcDonalds.basePanel2[3]).model.removeRow(0);

            }

            // 전체 칼로리와 가격을 0으로
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie = 0;
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice = 0;

            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText("0kcal");
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText("0원");
            mcDonalds.orderNum = 0;

        }

        // 장바구니 패널에 있는 벡터를 모두 지워 버림
        if (((OrderCheckPanel) mcDonalds.basePanel2[3]).cancelBtn == e.getSource()) {
            int count = ((OrderCheckPanel) mcDonalds.basePanel2[3]).model.getRowCount();
            for (int i = 0; i < count; i++) {
                ((OrderCheckPanel) mcDonalds.basePanel2[3]).model.removeRow(0);

            }

            // 전체 칼로리와 가격을 0으로
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalCalorie = 0;
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).totalPrice = 0;

            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).calorieLab2.setText("0kcal");
            ((OrderCheckPanel) (mcDonalds).basePanel2[3]).priceLab2.setText("0원");
            mcDonalds.orderNum = 0;
        }
    }

    public void selectPan3() {
        ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].setText(burgerDTO.name);
        ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[1].setText(burgerDTO.price + "원");
        ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[2].setText(burgerDTO.calorie + "kcal");
        ((BugerPanel) (mcDonalds.basePanel2[0])).ta.setText(burgerDTO.info);
    }
}