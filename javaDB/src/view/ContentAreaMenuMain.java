/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.search.CollectionContent;
import view.search.CollectionResult;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ContentAreaMenuMain extends JPanel{
     private static ContentAreaMenuMain instance = null;

    public static ContentAreaMenuMain getInstance() throws IOException {
        if (instance == null) {
            instance = new ContentAreaMenuMain();
            return instance;
        }
        return instance;
    }

    protected ContentAreaMenuMain() throws IOException 
    {   
        setBackground(Color.WHITE);
        setLayout(new CardLayout());
        //add(new JButton("sasas"));

        add(CollectionContent.getInstance(),"search");
        add(view.Card.CardContent.getInstance(),"ListCard");
        add(view.learn.LearnContent.getInstance(),"learn");
        add(view.exam.ExamContent.getInstance(),"exam");
        add(CollectionResult.getInstance(),"result");
    }
}
