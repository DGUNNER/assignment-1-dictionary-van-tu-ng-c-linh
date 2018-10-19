/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.search;


import Controller.ControllerDB;
import DataBase.DBConnect;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Admin
 */
public class CollectionContent extends JPanel{
     protected static CollectionContent instance = null;
     public static CollectionContent getInstance() throws SQLException {
        if(instance == null)
        {
            instance = new CollectionContent();
            return instance;
        }else 
            return instance;
    }
     //public  ArrayList<WordItem>  collItems= new ArrayList();
    public JPanel panel = new JPanel();

    public CollectionContent() throws SQLException {
        loadData();

        init();
    }

    protected void init() throws SQLException {
        setLayout(new BorderLayout());
        //JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);


        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
    }
    public void AddItem(String Word,int i)
    {

        panel.add(new WordItem(Word,i),i);
        updateComponent();
        if(panel.getComponentCount()>30)
        {
            //panel.remove(31);
        }
    }
    public void removeOneItem(int index) throws IOException
    {
        System.out.println("remove"+index);
        panel.remove(index);
        panel.updateUI();

    }

    public void updateDatabase() throws SQLException {
        for(int i =0; i < panel.getComponentCount();i ++)
        {
            ControllerDB.getInstance().updateToHistory(((WordItem)panel.getComponent(i)).getTextValue(),i);
        }
    }
    public void loadData() throws SQLException {
        //panel.removeAll();

        ResultSet data =ControllerDB.getInstance().loadDataCollectionContent();
        int index=0;
        while(data.next())
        {

            String a = data.getString("word");
            System.out.println(a);
            AddItem(data.getString("word"),index);

            index++;
        }

        panel.updateUI();
        /*for(int i =0; i< panel.getComponentCount();i++)
        {
            ((WordItem)panel.getComponent(i)).setTextValue("abc");
        }*/
    }
    public void updateComponent()
    {
        for(int i =0; i < panel.getComponentCount();i ++)
        {
            ((WordItem)panel.getComponent(i)).setActionCommand(i);
            if(i%2 ==1)
            {
                ((WordItem)panel.getComponent(i)).setBackground(new Color(242, 242, 242));
            }
            else ((WordItem)panel.getComponent(i)).setBackground(Color.WHITE);

        }
        panel.updateUI();
    }
    
}
