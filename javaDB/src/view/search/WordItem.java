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


    BtnNone btn1= new BtnNone();
    public int index;
    public void setTextValue(String WordEng) {

        btn1.setText(WordEng);
    }
    public String getTextValue() {

        return btn1.getText();
    }

    public void setActionCommand(int index)
    {
        ShowExplan.setActionCommand("ShowExplan#"+index);
        addWorditemToFavorits.setActionCommand("addWorditemToFavorits#"+index);
        deleteCWordItem.setActionCommand("deleteWordItem#"+index);
    }
    JPopupMenu menu = new JPopupMenu();
    JMenuItem ShowExplan = new JMenuItem("Xem Giải Thích");
    JMenuItem addWorditemToFavorits = new JMenuItem("Thêm Vào Yêu Thích");
    JMenuItem deleteCWordItem = new JMenuItem("Xóa");
    public WordItem(String _wordEng, int _index)
    {
        this.index =_index;

        //System.out.println(index);

        ShowExplan.setActionCommand("ShowExplan#"+index);
        ShowExplan.addActionListener(Controller.getInstance());




        addWorditemToFavorits.setActionCommand("addWorditemToFavorits#"+index);
        addWorditemToFavorits.addActionListener(Controller.getInstance());


        deleteCWordItem.setActionCommand("deleteWordItem#"+index);
        deleteCWordItem.addActionListener(Controller.getInstance());

        menu.add(ShowExplan);

        menu.add(addWorditemToFavorits);
        menu.add(deleteCWordItem);



        setPreferredSize(new Dimension(40, 50));

        setLayout(new BorderLayout());

        btn1.setText(_wordEng);
        btn1.setContentAreaFilled(false);
        btn1.setIcon(new ImageIcon("icons/speaker.png"));


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


                add(btn1,BorderLayout.CENTER);
        //add(btnicon);
    }
}
