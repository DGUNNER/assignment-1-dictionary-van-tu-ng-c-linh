/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.search;


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
public class CollectionResult extends JPanel{
    protected static CollectionResult instance = null;
    public static CollectionResult getInstance()
    {
        if(instance == null)
        {
            instance = new CollectionResult();
            return instance;
        }else
            return instance;
    }
   // public  ArrayList<WordItem>  collItems= new ArrayList();
    JPanel panel = new JPanel();

    public CollectionResult()
    {
        init();
    }
    public void loadding() {
        panel.removeAll();
        /*for(int i =0; i<ArrayResult.getInstance().size(); i++)
        {
            System.out.println(ArrayResult.getInstance().get(i).getWord_target()+ArrayResult.getInstance().get(i).getWord_explain());
            panel.add(new WordItemResult(ArrayResult.getInstance().get(i).getWord_target(),ArrayResult.getInstance().get(i).getWord_explain(),i));
        }*/
    }
    protected void init()
    {
        setLayout(new BorderLayout());
        //JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        //ArrayResult.getInstance();

/*        for(int i =0; i<ArrayResult.getInstance().size(); i++)
        {
            System.out.println(ArrayResult.getInstance().get(i).getWord_target()+ArrayResult.getInstance().get(i).getWord_explain());
            panel.add(new WordItem(ArrayResult.getInstance().get(i).getWord_target(),ArrayResult.getInstance().get(i).getWord_explain(),i));
        }*/

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane,BorderLayout.CENTER);
    }
    public void removeOneItem(int index)
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


}
