/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Card;


import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Admin
 */
public class ListCard extends JPanel{

    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel);
    public void setListCard() {
        
       /*for(int i = 0; i< FavoritesWordList.getInstance().size(); i++)
       {
           panel.add(new CardItem(FavoritesWordList.getInstance().get(i).getWord_target(),
                   FavoritesWordList.getInstance().get(i).getWord_explain() , i));
       }*/
        
    }
    private static ListCard instance = null;
    public static ListCard getInstance()
    {
        if(instance == null)
        {
            instance = new ListCard();
            return instance;
        }else 
            return instance;
    }
    protected ListCard()
    {
        setListCard();
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

        panel.updateUI();
    }
}
