/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.search;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class BtnNone extends JButton{
    
    public BtnNone()
    {
        init();
    }
    public BtnNone(ImageIcon icon)
    {
        setIcon(icon);
        init();
    }
    public BtnNone(String text)
    {
        setText(text);
        init();
    }
    private void init()
    {
        setBackground(Color.LIGHT_GRAY);
        //setContentAreaFilled(false);
        //setBorderPainted(false);
        //setFocusPainted(false);

        setFont(new Font("Monaco", Font.PLAIN, 17));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                    // your code here
                    function();
                }
            }
        });
    }
    public void function()
    {
        //System.out.println(this.getText());
    }
}
