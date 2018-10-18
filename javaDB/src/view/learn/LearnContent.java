/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.learn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class LearnContent extends JPanel {
    private static LearnContent instance = null;
    public final int WIDTH_Content = 850;

    public static LearnContent getInstance() throws SQLException {
        if(instance == null)
        {
            instance = new LearnContent();
            return instance;
        }else 
            return instance;
    }

    private LearnContent() throws SQLException {
        init();
    }
    private void init() throws SQLException {
        setLayout(null);
        setBackground(Color.white);
        LearnWord.getInstance().setBounds(WIDTH_Content/2 - LearnWord.getInstance().WIDTH_ /2 - 30
                , 30, LearnWord.getInstance().WIDTH_, LearnWord.getInstance().HEIGHT_);
        add(LearnWord.getInstance(),BorderLayout.CENTER);
        
        
    }

}
