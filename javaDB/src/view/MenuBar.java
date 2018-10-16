/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Admin
 */
public class MenuBar extends JPanel {
    private static MenuBar instance = null;
    private static ArrayList<BtnCustom> featureBtns = new ArrayList();
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
        featureBtns.add(new BtnCustom(new ImageIcon("icons/search.png"), "Tìm Kiếm"));
        featureBtns.get(0).setRolloverIcon(new ImageIcon("icons/hover-search.png"));
        featureBtns.get(0).setSelectedIcon(new ImageIcon("icons/hover-search.png"));
        featureBtns.get(0).setActionCommand("btnMenuSearch");
        featureBtns.get(0).addActionListener(Controller.Controller.getInstance());
        add(featureBtns.get(0));
        
        
       featureBtns.add(new BtnCustom(new ImageIcon("icons/tag.png"), "Bộ Thẻ"));
        featureBtns.get(1).setRolloverIcon(new ImageIcon("icons/hover-tag.png"));
        featureBtns.get(1).setSelectedIcon(new ImageIcon("icons/hover-tag.png"));
        featureBtns.get(1).setActionCommand("card");
        featureBtns.get(1).addActionListener(Controller.Controller.getInstance());
        add(featureBtns.get(1));
        
        
        featureBtns.add(new BtnCustom(new ImageIcon("icons/study.png"), "Học Từ Vựng"));
        featureBtns.get(2).setRolloverIcon(new ImageIcon("icons/hover-study.png"));
        featureBtns.get(2).setSelectedIcon(new ImageIcon("icons/hover-study.png"));
        featureBtns.get(2).setActionCommand("learn");
        featureBtns.get(2).addActionListener(Controller.Controller.getInstance());
        add(featureBtns.get(2));
        
        
        featureBtns.add(new BtnCustom(new ImageIcon("icons/exam.png"), "Kiểm Tra"));
        featureBtns.get(3).setRolloverIcon(new ImageIcon("icons/hover-exam.png"));
        featureBtns.get(3).setSelectedIcon(new ImageIcon("icons/hover-exam.png"));
        featureBtns.get(3).setActionCommand("exam");
        featureBtns.get(3).addActionListener(Controller.Controller.getInstance());
        add(featureBtns.get(3));
        
        
        featureBtns.add(new BtnCustom(new ImageIcon("icons/about.png"), "Các bộ thẻ"));
        featureBtns.get(4).setRolloverIcon(new ImageIcon("icons/hover-about.png"));
        featureBtns.get(4).setSelectedIcon(new ImageIcon("icons/hover-about.png"));
        featureBtns.get(4).setActionCommand("collections");
        add(featureBtns.get(4));
        showsMenuBarText(false); //ban đầu k hiện text
        //add(Box.createVerticalGlue()); // tạo ra khoảng trống ở giữa
        
    }
    public static void showsMenuBarText(boolean display)
    {
        if(display ==true)
        for(int i = 0; i<featureBtns.size(); i++)
        {
            featureBtns.get(i).setVisibleText(true);
            isShowtext =true;
        }
        else
            for(int i = 0; i<featureBtns.size(); i++)
        {
            featureBtns.get(i).setVisibleText(false);
            isShowtext =false;
        }
    }
}
