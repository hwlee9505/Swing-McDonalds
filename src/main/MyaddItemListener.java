package main;

import mcDonald.client.BeveragePanel;
import mcDonald.client.BugerPanel;
import mcDonald.client.McDonalds;
import mcDonald.db.BeverageDAO;
import mcDonald.db.BeverageDTO;
import mcDonald.db.BurgerDAO;
import mcDonald.db.BurgerDTO;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyaddItemListener implements ItemListener {

    McDonalds mcDonalds;
    BurgerDAO burgerDAO = new BurgerDAO();
    BurgerDTO burgerDTO = new BurgerDTO();
    BeverageDAO beverageDAO = new BeverageDAO();
    BeverageDTO beverageDTO = new BeverageDTO();

    public MyaddItemListener(McDonalds mcDonalds) {
        this.mcDonalds = mcDonalds;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        //==============================BURGER PANEL================================//
        String burgerName = ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].getText();
        if (((BugerPanel) (mcDonalds.basePanel2[0])).rb[0].isSelected() == true) {
            burgerDTO = burgerDAO.selectBurgerByName(burgerName);
            selectBurgerPan3();
        } else if (((BugerPanel) (mcDonalds.basePanel2[0])).rb[1].isSelected() == true) {
//            String name = ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].getText();
            burgerDTO = burgerDAO.selectBurgerSetByName(burgerName);
            selectBurgerPan3();
        }

        //==============================BEVERAGE PANEL================================//
        String beverageName = ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[0].getText();
        if (((BeveragePanel) (mcDonalds.basePanel2[1])).rb[0].isSelected() == true) {
            beverageDTO = beverageDAO.selectBeverageByName(beverageName);
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[0].setText(beverageDTO.name);
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[1].setText(beverageDTO.price + "원");
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[2].setText(beverageDTO.calorie + "kcal");
        } else if (((BeveragePanel) (mcDonalds.basePanel2[1])).rb[1].isSelected() == true) {
//            String name = ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].getText();
            beverageDTO = beverageDAO.selectBeverageByName(beverageName);
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[0].setText(beverageDTO.name);
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[1].setText((beverageDTO.price + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusPrice[0]) + "원");
            // 0칼로리 인데 사이즈가 커진다고 해서 칼로리를 더하면 논리적으로 오류이므로 0칼로리 인경우 칼로리를 더하지 않았다.
            if (beverageDTO.calorie == 0) {
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[2].setText(beverageDTO.calorie + "kcal");
            } else {
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[2].setText((beverageDTO.calorie + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusCalrie[0]) + "kcal");
            }
        } else if (((BeveragePanel) (mcDonalds.basePanel2[1])).rb[2].isSelected() == true) {
//            String name = ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].getText();
            beverageDTO = beverageDAO.selectBeverageByName(beverageName);
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[0].setText(beverageDTO.name);
            ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[1].setText((beverageDTO.price + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusPrice[1]) + "원");
            // 0칼로리 인데 사이즈가 커진다고 해서 칼로리를 더하면 논리적으로 오류이므로 0칼로리 인경우 칼로리를 더하지 않았다.
            if (beverageDTO.calorie == 0) {
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[2].setText(beverageDTO.calorie + "kcal");
            } else {
                ((BeveragePanel) (mcDonalds.basePanel2[1])).beverageLab2[2].setText((beverageDTO.calorie + ((BeveragePanel) (mcDonalds.basePanel2[1])).plusCalrie[1]) + "kcal");
            }
        }
    }

    public void selectBurgerPan3() {
        ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[0].setText(burgerDTO.name);
        ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[1].setText(burgerDTO.price + "원");
        ((BugerPanel) (mcDonalds.basePanel2[0])).bugerLab2[2].setText(burgerDTO.calorie + "kcal");
        ((BugerPanel) (mcDonalds.basePanel2[0])).ta.setText(burgerDTO.info);
    }


}
