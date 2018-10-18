/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Card;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class TitleListCard  extends JPanel implements ActionListener{

    public static TitleListCard instance = null;
    public static TitleListCard getInstance ()
    {
         if(instance == null)
        {
            instance = new TitleListCard();
            return instance;
        }else 
            return instance;
    }
    public void setTextAnh(String anh)
    {
        WordEn.setText("Tiếng Anh : "+anh);
    }
    public void setTextViet(String viet)
    {
        WordVi.setText("Tiếng Việt : "+viet);
    }

    public TitleListCard() {
        init();
    }
    JLabel WordVi = new JLabel("Tiếng Việt :");
    JLabel WordEn = new JLabel("Tiếng Anh :");
    private void init()
    {
        setLayout(null);
        BtnImage btnImage = new BtnImage(new ImageIcon("icons/default_card.png"));
        btnImage.setBounds(10,10,btnImage.WIDTH,btnImage.HEIGHT);
        
        setPreferredSize(new Dimension(0, 180));
        
        
        JLabel title = new JLabel("Từ Vựng Yêu Thích");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Monaco", Font.PLAIN, 24));;
        title.setBounds(200, 20, 300, 40);
        

        WordVi.setForeground(Color.WHITE);
        WordVi.setBounds(200,70,500,40);
        WordVi.setFont(new Font("Monaco", Font.PLAIN, 18));;
        

        WordEn.setBounds(200,100,500,40);
        WordEn.setForeground(Color.WHITE);
        WordEn.setFont(new Font("Monaco", Font.PLAIN, 18));;
        
        setBackground(new Color(19, 39, 68));
        btnImage.addActionListener(this);
        
        add(btnImage);
        add(WordVi);
        add(WordEn);
        add(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    
}
