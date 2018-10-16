/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class BtnCustom extends JButton {
    private String  txtButton = null;
    
    
   
    public void setVisibleText(boolean isVisible)
    {
        if(isVisible == true)
        {
            setText(txtButton);
            setBorder(new EmptyBorder(10,10,10,50));//bỏ viền button magrin cho text trong button (top,left,bottom,right)
        }
        else
        {
            setBorder(new EmptyBorder(10,10,10,10));//bỏ viền button magrin cho text trong button (top,left,bottom,right)
            setText("");
        }
    }
    public BtnCustom(String title)
    {
        txtButton = title;
         init();
    }
    
    public BtnCustom(ImageIcon img)
    {
        super(img);
        init();
    }
    public BtnCustom(ImageIcon img,String lblButton)
    {
        super(img);
        txtButton = lblButton;
        init();
        
    }
    private void init()
    {   
        
        setBackground(new Color(242, 242, 242));// set màu backGround
        setIconTextGap(20);//tạo khoảng cách giữa icon và text
        setContentAreaFilled(false);// xóa hiệu ứng clich cho button
        setBorder(new EmptyBorder(10,10,10,10));
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.PLAIN, 16));
      
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //your actions
                
            }
        });
        addMouseListener(new MouseAdapter() {   
            @Override
            public void mouseEntered(MouseEvent evt) {
                setForeground(new Color(0, 148, 255));
                //
               
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                setForeground(Color.WHITE);
                //setIcon(new ImageIcon("icons\\hover-about.png"));
            }
        }); 
    }

   
    
}
