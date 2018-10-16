/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.exam;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ExamContent extends JPanel{
    private static ExamContent instance = null;
    
    public static ExamContent getInstance()
    {
        if(instance == null)
        {
            instance = new ExamContent();
            return instance;
        }else 
            return instance;
    }
    public ExamContent()
    {
        init();
    }
    private void init()
    {
        setBackground(Color.white);
        setLayout(new CardLayout());
        add(ExamSelect.getInstance(),"EXAMSELECT");
    }
}
