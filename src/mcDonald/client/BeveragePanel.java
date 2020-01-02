package mcDonald.client;

import javax.swing.*;
import java.awt.*;

public class BeveragePanel extends JPanel {

    // bugerPanel에 또 3가지 패널이 들어가게 됩니다.
    // 첫 패널은 단순 디자인을 위해서 사진하나 들어가게 되고
    // 두번째 패널은 여러 사진버튼들이 들어가게되고
    // 서번쨰 패널은 클릭한 사진들의 내용을 상세히 알려주는 패널이 되겠습니다.
    public JPanel pan1 = new JPanel();
    public JPanel pan2 = new JPanel(new GridLayout(3, 4, 5, 5));
    public JPanel pan3 = new JPanel(new GridLayout(0, 2));
    public JPanel pan4 = new JPanel();

    //---pan1---
    public JLabel lab = new JLabel();
    //pan1에 들어갈 사진입니다.
    //img/mcdonald사진은 디자인용 입니다.

    public ImageIcon orginIcon2 = new ImageIcon("img/mcdonald.png");
    public Image orginImg2 = orginIcon2.getImage();
    public Image chagnedImg2 = orginImg2.getScaledInstance(550, 200, Image.SCALE_SMOOTH);
    public ImageIcon image2 = new ImageIcon(chagnedImg2);


    //---pan2---
    public String[] beverages = {"딸기/망고/파인애플 칠러", "미닛메이드 오렌지 주스", "바닐라/딸기/초코 쉐이크", "생수",
            "아메리카노", "아이스 커피", "에스프레소", "우유", "카페라떼",
            "카푸치노", "탄산음료", "프리미엄 로스트 원두커피"};

    String[] bevImageName = {"img/beverage/chiller.png", "img/beverage/orangejuice.png", "img/beverage/shake.png", "img/beverage/water.png",
            "img/beverage/americano.png", "img/beverage/icecoffee.png", "img/beverage/espresso.png", "img/beverage/milk.png", "img/beverage/caffelatte.png",
            "img/beverage/capuchino.png", "img/beverage/tansan.png", "img/beverage/premiumwondo.png",};

    // 여러 버거 사진들의 사진을 조정하기위해 배열을 만들었습니다.
    // 사진들의 사이즈를 조정하기위해서 웹서칭을 통해 찾은것이고 조금 까다로웠습니다.
    // pan2에 들어갈 사진들 입니다.

    public JButton[] beverageBtn = new JButton[beverages.length];

    public ImageIcon[] orginIcon = new ImageIcon[beverages.length];
    public Image[] orginImg = new Image[beverages.length];
    public Image[] changedImg = new Image[beverages.length];
    public ImageIcon[] image = new ImageIcon[beverages.length];

    //---pan3---

    // 각 라벨에는 디비에 있는 버거의 '이름','가격','칼로리' 를 담을것이며
    // 텍스트 에리아에는 버거의 정보를 입력하려 합니다.
    public String[] beverageAttr = {"이름", "가격", "칼로리"};
    public JLabel[] beverageLab = new JLabel[beverageAttr.length];
    public JLabel[] beverageLab2 = new JLabel[beverageAttr.length];

    public String[] bSize = {"S", "M" , "L"};
    // default 사이즈 s에서 m과 l로 커질때 더해지는 가격
    // 사이즈에 따라 테이블을 만들지 않았기 떄문에 이렇게 더하게 되었습니다.
    public int[] plusPrice = {300,500};
    public int[] plusCalrie = {10,25};

    public JRadioButton[] rb = new JRadioButton[bSize.length];
    public ButtonGroup bg = new ButtonGroup();
    //    public JButton preBtn = new JButton("Previous");
//    public JButton nextBtn = new JButton("Next");
    public JButton sumbit = new JButton("장바구니에 담기");

    public BeveragePanel() {

        //pan1에 들어가는 맥도날드 사진
        lab.setIcon(image2);
        pan1.add(lab);

        // pan2에 들어갈 사진의 사이즈들을 모두 125,100으로 변경하고 있습니다.
        //변경 후 pan2에 들어 가게 됩니다.
        for (int i = 0; i < beverages.length; i++) {
            orginIcon[i] = new ImageIcon(bevImageName[i]);
            orginImg[i] = orginIcon[i].getImage();
            changedImg[i] = orginImg[i].getScaledInstance(125, 100, Image.SCALE_SMOOTH);
            image[i] = new ImageIcon(changedImg[i]);
            beverageBtn[i] = new JButton(image[i]);
            beverageBtn[i].setBorderPainted(true);

            pan2.add(beverageBtn[i]);
        }

        // pan3에 들어갈 디비의 정보들
        // pan2에 있는 버튼들이 클리되며 동적으로 내용들이 변하게 된다.
        for (int i = 0; i < beverageLab.length; i++) {
            beverageLab[i] = new JLabel(beverageAttr[i]);
            pan3.add(beverageLab[i]);
            beverageLab2[i] = new JLabel("메뉴를 선택해 주세요 :)");
            pan3.add(beverageLab2[i]);
        }

        // 단품인지 세트인지 알기위해서 버튼그룹으로 2개를 묶고 판단
        for (int i = 0; i < rb.length; i++) {
            rb[i] = new JRadioButton(bSize[i]);
            bg.add(rb[i]);
            pan3.add(rb[i]);
        }
        pan4.add(sumbit);

        // 지난번 과제 처럼 다음 디비내용에 있는것을 가져옴
//        pan3.add(preBtn);
//        pan3.add(nextBtn);


        this.setLayout(new GridLayout(4,1,0,0));
        this.add(pan1);
        this.add(pan2);
        this.add(pan3);
        this.add(pan4);
    }


}
