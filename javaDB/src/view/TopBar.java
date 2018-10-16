/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.*;
import  view.search.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class TopBar extends JPanel implements ActionListener {
    private static TopBar instance = null;
    public BtnCustom Menu = new BtnCustom(new ImageIcon("icons/menu.png"));
    
    public JTextField textBox = new JTextField("Tìm Kiếm ...");
    public static TopBar getInstance()
    {
        if(instance == null)
        {
            instance = new TopBar();
            return instance;
        }else 
            return instance;
    }
    private TopBar()
    {
        init();
    }
    private void init()
    {
        setLayout(null);
        
        Menu.setBounds(10,15,24,24);
        Menu.setBackground(Color.red);
       
        Menu.addActionListener(this);
        
        BtnNone btnSearch = new BtnNone("Search");
        Border border = LineBorder.createGrayLineBorder();
        btnSearch.setBorder(border);
        btnSearch.setBackground(new Color(0, 123, 255));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(750,10,100,40);
        btnSearch.setActionCommand("btnSearch");
                
        textBox.setBounds(230, 10, 500, 40);
        add(Menu);
        add(textBox);
        add(btnSearch);
        btnSearch.addActionListener(Controller.getInstance());
        
        //setSize(500, 500);
        setPreferredSize(new Dimension(0, 60));
    }
    public void actionPerformed(ActionEvent e) {
           
               MenuBar.getInstance().showsMenuBarText(!MenuBar.getInstance().isShowtext);
        }

}
