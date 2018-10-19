/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Card;


import Controller.ControllerDB;
import view.search.BtnNone;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class ListCard extends JPanel{

    public  JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel);
    public void loadListCard() throws SQLException {

        ResultSet data = ControllerDB.getInstance().loadDataCardToFavoritesWord();
        int i =0;
        while(data.next())
        {
            System.out.println(data.getString("explan"));
            CardItem tmp = new CardItem(
                    data.getString("word"),
                    data.getString("explan"),
                    i
            );
            if(i%2==0)
            {
                tmp.setBackground(new Color(242, 242, 242));
            }
            else
            {
                tmp.setBackground(Color.WHITE);
            }
            panel.add(tmp);
            i++;
        }
       /*for(int i = 0; i< FavoritesWordList.getInstance().size(); i++)
       {
           panel.add(new CardItem(FavoritesWordList.getInstance().get(i).getWord_target(),
                   FavoritesWordList.getInstance().get(i).getWord_explain() , i));
       }*/
        
    }
    public void exportToDataBase() throws SQLException {
        ControllerDB.getInstance().exportCardToDataBase();
    }
    private static ListCard instance = null;
    public static ListCard getInstance() throws SQLException {
        if(instance == null)
        {
            instance = new ListCard();
            return instance;
        }else 
            return instance;
    }
    protected ListCard() throws SQLException {
        loadListCard();
        init();
    }
    private void init()
    {
        
       BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
       panel.setLayout(boxLayout);
        setLayout(new BorderLayout());
        setBackground(Color.white);

        
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
        
    }

    public void reloadListCard() throws IOException
    {
       for(int i = 0; i <panel.getComponentCount(); i++)
       {
           Color color;
           if(i%2==0)
               color =new Color(242, 242, 242);
           else
               color =Color.WHITE;

           ((CardItem)panel.getComponent(i)).setBackground(color);
           ((CardItem)panel.getComponent(i)).uploadActionCmd(i);
       }
        
    }


}
