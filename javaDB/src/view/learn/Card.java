/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.learn;


import view.search.BtnNone;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class Card extends JPanel implements ActionListener {
    private static Card instance = null;

    private static BtnNone BtnViet =new BtnNone();
    private static BtnNone BtnEng =new BtnNone();

    public static Card getInstance()
    {
        if(instance == null)
        {
            instance = new Card();
            return instance;
        }else 
            return instance;
    }

    public final int WIDTH_CARD =450;
    public final int HEIGHT_CARD =450;

    private String Eng;

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }

    public String getViet() {
        return Viet;
    }

    public void setViet(String viet) {
        Viet = viet;
    }

    private String Viet;


     public Card(){
         init();
     }
     public void LoadDataItem()
     {
         BtnEng.setText(Eng);
         BtnViet.setText(Viet);
     }
    
     private void init()
     {
        setLayout(new CardLayout());
        BtnViet.setBackground(Color.WHITE);
        BtnViet.setForeground(Color.black);
        BtnViet.setFont(new Font(Font.MONOSPACED, Font.BOLD,  35));
        BtnViet.setActionCommand("VIET");
        BtnViet.addActionListener(this);

        BtnEng.setBackground(Color.WHITE);
        BtnEng.setFont(new Font(Font.MONOSPACED, Font.BOLD,  35));
         BtnEng.setForeground(Color.BLACK);
         BtnEng.setActionCommand("ENG");
         BtnEng.addActionListener(this);
        LoadDataItem();
        add(BtnEng,"ENGLISH");
        add(BtnViet,"VIETNAM");

     }

    public void showBtnEng()
    {
        CardLayout cardLayout = (CardLayout) getInstance().getLayout();
        cardLayout.show(getInstance(),"ENGLISH");
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CardLayout cardLayout = (CardLayout) getInstance().getLayout();
        String cmd =actionEvent.getActionCommand();
         if(cmd.equals("VIET"))
         {
             cardLayout.show(getInstance(),"ENGLISH");
         }else if(cmd.equals("ENG"))
         {
             cardLayout.show(getInstance(),"VIETNAM");
         }
    }
}
