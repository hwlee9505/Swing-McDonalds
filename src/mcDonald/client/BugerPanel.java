package mcDonald.client;

import javax.swing.*;
import java.awt.*;

public class BugerPanel extends JPanel {

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
    public String[] burgers = {"1955 스모키 더블베이컨", "1955버거", "더블 쿼터파운더 치즈", "더블1955버거",
            "맥스파이시 상하이버거", "맥치킨 모짜렐라", "메가맥", "불고기 버거", "빅맥",
            "슈슈버거", "치즈 버거", "쿼터파운더 치즈"};

    String[] bImageName = {"img/burger/smoky1955.png", "img/burger/1955.png", "img/burger/doublequater.png", "img/burger/double1955.png",
            "img/burger/mcspicy.png", "img/burger/mcchicken.png", "img/burger/mega.png", "img/burger/bulgogi.png", "img/burger/bigmc.png",
            "img/burger/shushu.png", "img/burger/cheeze.png", "img/burger/quaterpound.png",};

    // 여러 버거 사진들의 사진을 조정하기위해 배열을 만들었습니다.
    // 사진들의 사이즈를 조정하기위해서 웹서칭을 통해 찾은것이고 조금 까다로웠습니다.
    // pan2에 들어갈 사진들 입니다.

    public JButton[] burgerBtn = new JButton[burgers.length];

    public ImageIcon[] orginIcon = new ImageIcon[burgers.length];
    public Image[] orginImg = new Image[burgers.length];
    public Image[] changedImg = new Image[burgers.length];
    public ImageIcon[] image = new ImageIcon[burgers.length];

    //---pan3---

    // 각 라벨에는 디비에 있는 버거의 '이름','가격','칼로리' 를 담을것이며
    // 텍스트 에리아에는 버거의 정보를 입력하려 합니다.
    public String[] burgerAttr = {"이름", "가격", "칼로리", "버거 상세 내용"};
    public JLabel[] bugerLab = new JLabel[burgerAttr.length];
    public JLabel[] bugerLab2 = new JLabel[burgerAttr.length - 1];
    public JTextArea ta = new JTextArea("메뉴를 선택해 주세요 :)", 6, 20);

    public String[] bShape = {"단품", "세트"};
    public JRadioButton[] rb = new JRadioButton[bShape.length];
    public ButtonGroup bg = new ButtonGroup();
//    public JButton preBtn = new JButton("Previous");
//    public JButton nextBtn = new JButton("Next");
    public JButton sumbit = new JButton("장바구니에 담기");

    public BugerPanel() {

        //pan1에 들어가는 맥도날드 사진
        lab.setIcon(image2);
        pan1.add(lab);

        // pan2에 들어갈 사진의 사이즈들을 모두 125,100으로 변경하고 있습니다.
        //변경 후 pan2에 들어 가게 됩니다.
        for (int i = 0; i < burgers.length; i++) {
            orginIcon[i] = new ImageIcon(bImageName[i]);
            orginImg[i] = orginIcon[i].getImage();
            changedImg[i] = orginImg[i].getScaledInstance(125, 100, Image.SCALE_SMOOTH);
            image[i] = new ImageIcon(changedImg[i]);
            burgerBtn[i] = new JButton(image[i]);
            burgerBtn[i].setBorderPainted(true);

            pan2.add(burgerBtn[i]);
        }

        // pan3에 들어갈 디비의 정보들
        // pan2에 있는 버튼들이 클리되며 동적으로 내용들이 변하게 된다.
        for (int i = 0; i < bugerLab2.length; i++) {
            bugerLab[i] = new JLabel(burgerAttr[i]);
            pan3.add(bugerLab[i]);
            bugerLab2[i] = new JLabel("메뉴를 선택해 주세요 :)");
            pan3.add(bugerLab2[i]);
        }
        bugerLab[burgerAttr.length - 1] = new JLabel(burgerAttr[burgerAttr.length - 1]);
        pan3.add(bugerLab[burgerAttr.length - 1]);
        JScrollPane sp = new JScrollPane(ta);
        pan3.add(sp);

        // 단품인지 세트인지 알기위해서 버튼그룹으로 2개를 묶고 판단
        for (int i = 0; i < rb.length; i++) {
            rb[i] = new JRadioButton(bShape[i]);
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
