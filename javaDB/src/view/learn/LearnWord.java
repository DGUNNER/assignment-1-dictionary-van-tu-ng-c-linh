/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.learn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import view.Card.CardItem;
import view.Card.ListCard;
import view.search.BtnNone;

/**
 *
 * @author Admin
 */
public class LearnWord extends JPanel implements ActionListener{
    
    private static LearnWord instance = null;
    public static LearnWord getInstance() throws SQLException {
        if(instance == null)
        {
            instance = new LearnWord();
            return instance;
        }else
            return instance;
    }
    
    public final int WIDTH_ =Card.getInstance().WIDTH_CARD +50;
    public final int HEIGHT_ =Card.getInstance().HEIGHT_CARD;
    private BtnNone left = new BtnNone(new ImageIcon("icons/left.png"));
    private BtnNone right = new BtnNone(new ImageIcon("icons/right.png"));

    int index =0;
    private void loaddata()
    {

    }
   

    private LearnWord() throws SQLException {
        loaddata();
        init();
    }
    private void init() throws SQLException {
        
        setLayout(new BorderLayout());
        Border border = LineBorder.createGrayLineBorder();
        setBorder(border);
        setBackground(Color.WHITE);
        left.addActionListener(this);
        left.setBackground(Color.WHITE);
        left.setActionCommand("left");
        right.addActionListener(this);
        right.setBackground(Color.WHITE);
        right.setActionCommand("right");
        loopLearn();

        add(Card.getInstance(),BorderLayout.CENTER);
        add(left,BorderLayout.LINE_START);
        add(right,BorderLayout.LINE_END);
    }
    public  void loopLearn() throws SQLException {
        if( index<ListCard.getInstance().panel.getComponentCount())
        {
            System.out.println(index);
            Card.getInstance().setEng(((CardItem)ListCard.getInstance().panel.getComponent(index)).getTextBtnAnh());
            Card.getInstance().setViet(((CardItem)ListCard.getInstance().panel.getComponent(index)).getTextBtnViet());

            Card.getInstance().LoadDataItem();
            Card.getInstance().showBtnEng();
            Card.getInstance().repaint();
        }
    }
    public void EndLearn()
    {
        Card.getInstance().setEng("Kết Thúc");
        Card.getInstance().setViet("Kết Thúc");

        Card.getInstance().LoadDataItem();
        Card.getInstance().showBtnEng();
        Card.getInstance().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        if(cmd.equals("left"))
        {
            if(index >0)
            {
                index--;
                try {
                    loopLearn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else if(cmd.equals("right"))
        {
            try {


                if (index < ListCard.getInstance().panel.getComponentCount() - 1) {
                    index++;
                    loopLearn();
                } else if (index == ListCard.getInstance().panel.getComponentCount() - 1) EndLearn();
            }catch (SQLException er)
            {
                System.out.println(er);
            }
        }
    }
}
