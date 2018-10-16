/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Card;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class BtnImage extends JButton implements ActionListener{
    public final int WIDTH =150;
    public final int HEIGHT =150;
    public BtnImage(ImageIcon icon)
    {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setIcon(icon);
        addActionListener(this);
    }
//    public static void main(String []args){
//        JFrame  fm = new JFrame();
//        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fm.setSize(500, 500);
//        BtnImage btn = new BtnImage(new ImageIcon("icons\\default_card.png"));
//        btn.setBounds(0,0,btn.WIDTH,btn.HEIGHT);
//        JPanel panel = new JPanel(null);
//        panel.add(btn);
//        fm.add(
//                panel
//        );
//        fm.setVisible(true);
//        
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}
