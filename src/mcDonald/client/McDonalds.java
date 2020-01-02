package mcDonald.client;

import main.MyaddActionListener;
import main.MyaddItemListener;
import mcDonald.db.*;
import mcDonald.manager.McCrews;

import javax.swing.*;
import java.util.Vector;

public class McDonalds extends JFrame {

    public JTabbedPane tab;
    public JPanel[] basePanel2 = new JPanel[4];
    public Vector rowData = null;
    public int orderNum = 0;

    public McDonalds() {
        this.setTitle("McDonald 사용자 모드");
        this.setSize(550, 1170);
        this.setLocation(500, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tab = new JTabbedPane(JTabbedPane.TOP);

        basePanel2[0] = new BugerPanel();
        basePanel2[1] = new BeveragePanel();
        basePanel2[2] = new SubPanel();
        basePanel2[3] = new OrderCheckPanel();
        tab.add("햄버거", basePanel2[0]);
        tab.add("음료수", basePanel2[1]);
        tab.add("서브", basePanel2[2]);
        tab.add("장바구니", basePanel2[3]);

        // 직접 만든 액션으로 어떤 버튼을 눌렀을때 동작하는 경우와 행동들을 구현해놓게 되는 클래스입니다.
        MyaddActionListener mal = new MyaddActionListener(this);
        MyaddItemListener mai = new MyaddItemListener(this);

        //==============================BURGER PANEL================================//
        for (int i = 0; i < ((BugerPanel) (basePanel2[0])).burgerBtn.length; i++) {
            //버거패널에 있는 버거사진버튼들을 눌렀을 때 mal클래스에 의하여 동작하게 됩니다.
            ((BugerPanel) (basePanel2[0])).burgerBtn[i].addActionListener(mal);
        }
        // 세트인지 단품인지 골렸을 때
        ((BugerPanel) (basePanel2[0])).rb[0].addItemListener(mai);
        ((BugerPanel) (basePanel2[0])).rb[1].addItemListener(mai);

        ////////-------------------버거패널 default값 지정해주기--------------------------//////////////
        //MyaddActionListener는 버거 패널의 lab1 name을 가지고 디비에 있는 나머지것들을 가져오므로 일단 DAO를 통해서
        //이름을 가져옴
        BurgerDTO burger = new BurgerDAO().initPan3();
        ((BugerPanel) (basePanel2[0])).bugerLab2[0].setText(burger.name);
        // 단품을 default로
        ((BugerPanel) (basePanel2[0])).rb[0].setSelected(true);
        ///////////////////////////////////////////////////////////////////////////////////////////
        //==============================BURGER END==================================//


        //============================BEVERAGE PANEL================================//
        for (int i = 0; i < ((BeveragePanel) (basePanel2[1])).beverageBtn.length; i++) {
            //음료패널에 있는 음료사진버튼들을 눌렀을 때 mal클래스에 의하여 동작하게 됩니다.
            ((BeveragePanel) (basePanel2[1])).beverageBtn[i].addActionListener(mal);
        }
        // S or M or L size 골렸을 때
        ((BeveragePanel) (basePanel2[1])).rb[0].addItemListener(mai);
        ((BeveragePanel) (basePanel2[1])).rb[1].addItemListener(mai);
        ((BeveragePanel) (basePanel2[1])).rb[2].addItemListener(mai);

        ////////-------------------음료패널 default값 지정해주기--------------------------//////////////
        //MyaddActionListener는 음료 패널의 lab1 name을 가지고 디비에 있는 나머지것들을 가져오므로 일단 DAO를 통해서
        //이름을 가져옴
        BeverageDTO beverage = new BeverageDAO().initPan3();
        ((BeveragePanel) (basePanel2[1])).beverageLab2[0].setText(beverage.name);
        // size S default로
        ((BeveragePanel) (basePanel2[1])).rb[0].setSelected(true);
        ///////////////////////////////////////////////////////////////////////////////////////////
        //============================BEVERAGE END==================================//


        //==============================SUB PANEL===================================//
        for (int i = 0; i < ((SubPanel) (basePanel2[2])).subBtn.length; i++) {
            //음료패널에 있는 음료사진버튼들을 눌렀을 때 mal클래스에 의하여 동작하게 됩니다.
            ((SubPanel) (basePanel2[2])).subBtn[i].addActionListener(mal);
        }
        ////////-------------------서브패널 default값 지정해주기--------------------------//////////////
        //MyaddActionListener는 서브 패널의 lab1 name을 가지고 디비에 있는 나머지것들을 가져오므로 일단 DAO를 통해서
        //이름을 가져옴
        SubDTO sub = new SubDAO().initPan3();
        ((SubPanel) (basePanel2[2])).subLab2[0].setText(sub.name);
        ((SubPanel) (basePanel2[2])).subLab2[1].setText(sub.price + "원");
        ((SubPanel) (basePanel2[2])).subLab2[2].setText(sub.calorie + "kcal");
        ///////////////////////////////////////////////////////////////////////////////////////////
        //=============================SUB END=====================================//

        //장바구니 담기 버튼
        ((BugerPanel) (basePanel2[0])).sumbit.addActionListener(mal);
        ((BeveragePanel) (basePanel2[1])).sumbit.addActionListener(mal);
        ((SubPanel) (basePanel2[2])).sumbit.addActionListener(mal);


        //주문 취소버튼
        ((OrderCheckPanel) (basePanel2[3])).cancelBtn.addActionListener(mal);

        //결제하기 버튼
        ((OrderCheckPanel) (basePanel2[3])).payBtn.addActionListener(mal);

        this.add(tab);
        this.setVisible(true);
    }


//        for (int i = 0; i < menuItem.length; i++) {
//            menuItem[i] = new JMenuItem(menuList[i]);
//            incomingOrder.add(menuItem[i]);
////            menuItem[i].addActionListener(mbl);
//        }

    public static void main(String[] args) {
        new McDonalds();
        new McCrews();
    }

}
