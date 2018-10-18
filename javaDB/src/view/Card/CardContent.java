/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Card;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class CardContent extends JPanel {
     private static CardContent instance = null;
    public static CardContent getInstance() throws SQLException {
        if(instance == null)
        {
            instance = new CardContent();
            return instance;
        }else

            return instance;
    }
    private CardContent() throws SQLException {
        init();
    }
    private void init() throws SQLException {
        setLayout(new BorderLayout());
        
        add(TitleListCard.getInstance(),BorderLayout.PAGE_START);
        add(ListCard.getInstance(),BorderLayout.CENTER);
    }
}
