/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.search;

import Model.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Admin
 */
public class CollectionContent extends JPanel{
     protected static CollectionContent instance = null;
     public static CollectionContent getInstance() throws IOException
    {
        if(instance == null)
        {
            instance = new CollectionContent();
            return instance;
        }else 
            return instance;
    }
     //public  ArrayList<WordItem>  collItems= new ArrayList();
    JPanel panel = new JPanel();

    public CollectionContent() throws IOException
    {
        init();
    }
    protected void init() throws IOException
    {
        setLayout(new BorderLayout());
        //JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        /*DictionaryManagement.getInstance();

        for(int i =0; i<Dictionary.getInstance().size(); i++)
        {
            panel.add(new WordItem(Dictionary.getInstance().get(i).getWord_target(),Dictionary.getInstance().get(i).getWord_explain(),i));
        }*/

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
    }
    public void removeOneItem(int index) throws IOException
    {
        System.out.println("remove"+index);
        panel.remove(index);

        panel.updateUI();

    }
    public void removeAllItems()
    {
        System.out.println("remove");
        panel.removeAll();
        panel.repaint();


    }
    public void upload()
    {
        panel.removeAll();
       /* for(int i =0; i<Dictionary.getInstance().size(); i++)
        {
            panel.add(new WordItem(Dictionary.getInstance().get(i).getWord_target(),Dictionary.getInstance().get(i).getWord_explain(),i));
        }*/
        panel.updateUI();
    }
    
}
