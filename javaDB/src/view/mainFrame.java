/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author Admin
 */
public class mainFrame extends JFrame{
    final String TOP = BorderLayout.PAGE_START;
    final String CENTER = BorderLayout.CENTER;
    final String BOTTOM = BorderLayout.PAGE_END;
    final String LEFT = BorderLayout.LINE_START;
    final String RIGHT = BorderLayout.LINE_END;
    
    private static mainFrame instance = null;
    public static mainFrame getInstance() throws IOException
    {
        if(instance == null)
        {
            instance = new mainFrame();
            return instance;
        }else 
            return instance;
    }
    private mainFrame(String title) throws IOException
    {
        super(title);
        init();
    }
    private mainFrame() throws IOException
    {
        init();
    }
    private void init() throws IOException
    {
        setSize(900, 650);
        //setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
              
        add(TopBar.getInstance(),TOP); //add vao vi tri tren 
        add(MenuBar.getInstance(),LEFT);// add vao vi tri trai
        add(ContentAreaMenuMain.getInstance(),CENTER);//add vao vi tri giưa
        
    }
    
}
