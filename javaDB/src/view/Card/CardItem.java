package view.Card;

import API.Speaker;
import Controller.Controller;
import view.search.BtnNone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardItem extends BtnNone{


    private JLabel btnViet = new JLabel();
    private JLabel btnAnh = new JLabel();

    public String getTextBtnViet() {
        return btnViet.getText();
    }

    public void setTextBtnViet(String Viet) {
        this.btnViet.setText( Viet);
    }

    public String getTextBtnAnh() {
        return btnAnh.getText();
    }

    public void setTextBtnAnh(String Anh) {
        this.btnAnh.setText(Anh);
    }
    public void uploadActionCmd(int index)
    {
        addCardItem.setActionCommand("addCardItem#"+index);
        editCardItem.setActionCommand("editCardItem#"+index);
        deleteCardItem.setActionCommand("deleteCardItem#"+index);
    }
    JPopupMenu menu = new JPopupMenu();
    JMenuItem addCardItem = new JMenuItem("Thêm thẻ");
    JMenuItem editCardItem = new JMenuItem("Sửa thẻ");
    JMenuItem deleteCardItem = new JMenuItem("Xóa thẻ");
    public CardItem(String _wordEng, String _wordVi, int index)
    {
        addCardItem.setActionCommand("addCardItem#"+index);
        addCardItem.addActionListener(Controller.getInstance());


        editCardItem.setActionCommand("editCardItem#"+index);
        editCardItem.addActionListener(Controller.getInstance());


        deleteCardItem.setActionCommand("deleteCardItem#"+index);
        deleteCardItem.addActionListener(Controller.getInstance());


        menu.add(addCardItem);
        menu.add(editCardItem);
        menu.add(deleteCardItem);



        setPreferredSize(new Dimension(40, 50));

        setLayout( new GridLayout(1,0));

        btnAnh= new JLabel(_wordEng);
        btnAnh.setHorizontalAlignment(CENTER);
        btnAnh.setFont(new Font("Monaco", Font.PLAIN, 18));
        btnAnh.setIcon(new ImageIcon("icons/speaker.png"));
        //btnAnh.setContentAreaFilled(false);

         btnViet= new JLabel(_wordVi);
         btnViet.setHorizontalAlignment(CENTER);
         btnViet.setFont(new Font("Monaco", Font.PLAIN, 18));
        //btnViet.setContentAreaFilled(false);
       // btnViet.setFocusPainted(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getClickCount()==2){
                    // your code here
                    new Speaker(((CardItem)(e.getSource())).getTextBtnAnh());
                }
                if(e.getButton() ==MouseEvent.BUTTON1)
                {

                   TitleListCard.getInstance().setTextAnh(((CardItem)(e.getSource())).getTextBtnAnh());
                    TitleListCard.getInstance().setTextViet(((CardItem)(e.getSource())).getTextBtnViet());
                }
                if(e.getButton() == MouseEvent.BUTTON3) // neu nhap phair chuot thi
                {
                    menu.show(e.getComponent(), e.getX(), e.getY()); // hien thi taij vi tri con tro chuot
                }

            }
        });

        add(btnAnh);
        add(btnViet);
    }
}
