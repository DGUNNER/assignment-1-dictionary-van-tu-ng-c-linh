/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author Admin
 */
public class MenuBar extends JPanel {
    private static MenuBar instance = null;
    private static ArrayList<BtnCustom> menuBtns = new ArrayList();
    public static boolean isShowtext = false; 
    public static MenuBar getInstance()
    {
        if(instance == null)
        {
            instance = new MenuBar();
            return instance;
        }else 
            return instance;
    }
    private MenuBar()
    {
        init();
    }
    private void init()
    {
        setBackground(new Color(73, 73, 73));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS )); // set box layout theo chieu dọc
        
//            BtnCustom btn1= new BtnCustom(new ImageIcon("icons\\collections.png"),"Các Bộ Thẻ");
//            BtnCustom btn2= new BtnCustom(new ImageIcon("icons\\collections.png"),"Tìm Thẻ");
//            BtnCustom btn3= new BtnCustom(new ImageIcon("icons\\collections.png"),"Thông Kê");
//            BtnCustom btn4= new BtnCustom(new ImageIcon("icons\\collections.png"),"Giới Thiệu");
//            BtnCustom btn5= new BtnCustom(new ImageIcon("icons\\collections.png"),"Thiết Lập");
        menuBtns.add(new BtnCustom(new ImageIcon("icons/history.png"), "Lịch Sử"));
        menuBtns.get(0).setRolloverIcon(new ImageIcon("icons/hover-history.png"));
        menuBtns.get(0).setSelectedIcon(new ImageIcon("icons/hover-history.png"));
        menuBtns.get(0).setActionCommand("btnMenuSearch");
        menuBtns.get(0).addActionListener(Controller.Controller.getInstance());
        add(menuBtns.get(0));
        
        
       menuBtns.add(new BtnCustom(new ImageIcon("icons/tag.png"), "Bộ Từ Vựng"));
        menuBtns.get(1).setRolloverIcon(new ImageIcon("icons/hover-tag.png"));
        menuBtns.get(1).setSelectedIcon(new ImageIcon("icons/hover-tag.png"));
        menuBtns.get(1).setActionCommand("card");
        menuBtns.get(1).addActionListener(Controller.Controller.getInstance());
        add(menuBtns.get(1));
        
        
        menuBtns.add(new BtnCustom(new ImageIcon("icons/study.png"), "Học Từ Vựng"));
        menuBtns.get(2).setRolloverIcon(new ImageIcon("icons/hover-study.png"));
        menuBtns.get(2).setSelectedIcon(new ImageIcon("icons/hover-study.png"));
        menuBtns.get(2).setActionCommand("learn");
        menuBtns.get(2).addActionListener(Controller.Controller.getInstance());
        add(menuBtns.get(2));
        
        
        menuBtns.add(new BtnCustom(new ImageIcon("icons/exam.png"), "Kiểm Tra"));
        menuBtns.get(3).setRolloverIcon(new ImageIcon("icons/hover-exam.png"));
        menuBtns.get(3).setSelectedIcon(new ImageIcon("icons/hover-exam.png"));
        menuBtns.get(3).setActionCommand("exam");
        menuBtns.get(3).addActionListener(Controller.Controller.getInstance());
        add(menuBtns.get(3));
        
        
        menuBtns.add(new BtnCustom(new ImageIcon("icons/about.png"), "Các bộ thẻ"));
        menuBtns.get(4).setRolloverIcon(new ImageIcon("icons/hover-about.png"));
        menuBtns.get(4).setSelectedIcon(new ImageIcon("icons/hover-about.png"));
        menuBtns.get(4).setActionCommand("collections");
        add(menuBtns.get(4));
        showsMenuBarText(false); //ban đầu k hiện text
        //add(Box.createVerticalGlue()); // tạo ra khoảng trống ở giữa
        
    }
    public static void showsMenuBarText(boolean display)
    {
        if(display ==true)
        for(int i = 0; i< menuBtns.size(); i++)
        {
            menuBtns.get(i).setVisibleText(true);
            isShowtext =true;
        }
        else
            for(int i = 0; i< menuBtns.size(); i++)
        {
            menuBtns.get(i).setVisibleText(false);
            isShowtext =false;
        }
    }
}
