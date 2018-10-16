/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.search;


import Controller.Controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class WordItem extends JPanel{
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
    public WordItem(String _wordEng, String _wordVi, int _index)
    {
        this.index =_index;
        JPopupMenu menu = new JPopupMenu();
        //System.out.println(index);
        JMenuItem addWordItem = new JMenuItem("Thêm thẻ");
        addWordItem.setActionCommand("addWordItem#"+index);
        addWordItem.addActionListener(Controller.getInstance());

        JMenuItem editWorditem = new JMenuItem("Sửa thẻ");
        editWorditem.setActionCommand("editWordItem#"+index);
        editWorditem.addActionListener(Controller.getInstance());

        JMenuItem addWorditemToFavorits = new JMenuItem("Thêm Vào Yêu Thích");
        addWorditemToFavorits.setActionCommand("addWorditemToFavorits#"+index);
        addWorditemToFavorits.addActionListener(Controller.getInstance());

        JMenuItem deleteCWordItem = new JMenuItem("Xóa thẻ");
        deleteCWordItem.setActionCommand("deleteWordItem#"+index);
        deleteCWordItem.addActionListener(Controller.getInstance());

        menu.add(addWordItem);
        menu.add(editWorditem);
        menu.add(addWorditemToFavorits);
        menu.add(deleteCWordItem);


        setWordEng(_wordEng);
        setPreferredSize(new Dimension(40, 50));
        setWordVi(_wordVi);
        setLayout( new GridLayout(1,0));

        BtnNone btn1= new BtnNone(WordEng);
        btn1.setContentAreaFilled(false);
        btn1.setIcon(new ImageIcon("icons/speaker.png"));

        BtnNone btn2= new BtnNone(WordVi);
        btn2.setContentAreaFilled(false);
        btn2.setFocusPainted(false);

        //BtnNone btnicon = new BtnNone(new ImageIcon("icons/speaker.png") );
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
        //add(btnicon);
    }
}
