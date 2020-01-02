package mcDonald.client;

import javax.swing.*;
import java.awt.*;

public class SubPanel extends JPanel {

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
    public String[] subs = {"딸기 선데이 아이스크림", "맥너겟 4조각", "맥윙 2조각", "모짜렐라 치즈스틱",
            "아이스크림콘", "오레오 맥플러리", "오레오 아포카토", "초코 선데이 아이스크림", "초코콘",
            "치킨 텐더 2조각", "해쉬 브라운", "후렌치 후라이"};

    String[] subImageName = {"img/sub/strowicecream.png", "img/sub/mcneget.png", "img/sub/mcwing.png", "img/sub/cheezestick.png",
            "img/sub/icecreamcone.png", "img/sub/oreomcplery.png", "img/sub/oreoavocato.png", "img/sub/chocoicecream.png", "img/sub/chococone.png",
            "img/sub/chickentender.png", "img/sub/hashbrown.png", "img/sub/frenchfri.png",};

    // 여러 버거 사진들의 사진을 조정하기위해 배열을 만들었습니다.
    // 사진들의 사이즈를 조정하기위해서 웹서칭을 통해 찾은것이고 조금 까다로웠습니다.
    // pan2에 들어갈 사진들 입니다.

    public JButton[] subBtn = new JButton[subs.length];

    public ImageIcon[] orginIcon = new ImageIcon[subs.length];
    public Image[] orginImg = new Image[subs.length];
    public Image[] changedImg = new Image[subs.length];
    public ImageIcon[] image = new ImageIcon[subs.length];

    //---pan3---

    // 각 라벨에는 디비에 있는 버거의 '이름','가격','칼로리' 를 담을것이며
    // 텍스트 에리아에는 버거의 정보를 입력하려 합니다.
    public String[] subAttr = {"이름", "가격", "칼로리"};
    public JLabel[] subLab = new JLabel[subAttr.length];
    public JLabel[] subLab2 = new JLabel[subAttr.length];

    public JButton sumbit = new JButton("장바구니에 담기");

    public SubPanel() {

        //pan1에 들어가는 맥도날드 사진
        lab.setIcon(image2);
        pan1.add(lab);

        // pan2에 들어갈 사진의 사이즈들을 모두 125,100으로 변경하고 있습니다.
        //변경 후 pan2에 들어 가게 됩니다.
        for (int i = 0; i < subs.length; i++) {
            orginIcon[i] = new ImageIcon(subImageName[i]);
            orginImg[i] = orginIcon[i].getImage();
            changedImg[i] = orginImg[i].getScaledInstance(125, 100, Image.SCALE_SMOOTH);
            image[i] = new ImageIcon(changedImg[i]);
            subBtn[i] = new JButton(image[i]);
            subBtn[i].setBorderPainted(true);

            pan2.add(subBtn[i]);
        }

        // pan3에 들어갈 디비의 정보들
        // pan2에 있는 버튼들이 클리되며 동적으로 내용들이 변하게 된다.
        for (int i = 0; i < subLab.length; i++) {
            subLab[i] = new JLabel(subAttr[i]);
            pan3.add(subLab[i]);
            subLab2[i] = new JLabel("메뉴를 선택해 주세요 :)");
            pan3.add(subLab2[i]);
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
