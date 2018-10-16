package view.Card;

import view.search.BtnNone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardItem extends JPanel{
    private String WordEng,WordVi;

    public String getWordEng() {
        return WordEng;
    }

    public String getWordVi() {
        return WordVi;
    }
    public int index;
    public void setWordEng(String WordEng) {
        this.WordEng = WordEng;
    }

    public void setWordVi(String WordVi) {
        this.WordVi = WordVi;
    }
    public CardItem(String _wordEng, String _wordVi, int index)
    {

        JPopupMenu menu = new JPopupMenu();

        JMenuItem addCardItem = new JMenuItem("Thêm thẻ");

        JMenuItem editCardItem = new JMenuItem("Sửa thẻ");
        JMenuItem deleteCardItem = new JMenuItem("Xóa thẻ");

        menu.add(addCardItem);
        menu.add(deleteCardItem);

        this.index =index;
        setWordEng(_wordEng);
        setPreferredSize(new Dimension(40, 50));
        setWordVi(_wordVi);
        setLayout( new GridLayout(1,0));

        BtnNone btn1= new BtnNone(WordEng);
        btn1.setIcon(new ImageIcon("icons/speaker.png"));
        btn1.setContentAreaFilled(false);

        BtnNone btn2= new BtnNone(WordVi);
        btn2.setContentAreaFilled(false);
        btn2.setFocusPainted(false);

        if(index % 2 ==0)
        {

            this.setBackground(new Color(242, 242, 242));
        }else
        {

            this.setBackground(Color.white);
        }

        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) // neu nhap phair chuot thi
                {
                    menu.show(e.getComponent(), e.getX(), e.getY()); // hien thi taij vi tri con tro chuot

                }
            }
        });
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) // neu nhap phair chuot thi
                {
                    menu.show(e.getComponent(), e.getX(), e.getY()); // hien thi taij vi tri con tro chuot

                }
            }
        });

        add(btn1);
        add(btn2);
    }
}
