/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DataBase.DBConnect;
import view.Card.ListCard;
import view.search.CollectionContent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class View {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here

        mainFrame.getInstance().setVisible(true);
        mainFrame.getInstance().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                try {
                    CollectionContent.getInstance().updateDatabase();
                    ListCard.getInstance().exportToDataBase();
                    DBConnect.getInstance().closeConnection();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
    
}
