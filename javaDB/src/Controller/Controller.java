package Controller;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import DataBase.DBConnect;
import ScrollableJPopupmenu.XJPopupMenu;
import view.Card.CardItem;
import view.Card.ListCard;
import view.ExplanWord;
import view.MessgeEditAndFavorites;
import view.TopBar;
import view.mainFrame;
import view.search.CollectionContent;
import view.search.CollectionResult;
import view.search.WordItem;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Controller implements ActionListener{
     private static Controller instance = null;
    public static Controller getInstance() 
    {
        if(instance ==null)
        {
            instance = new Controller();
            return instance;
        }
        else return instance;
    }
    XJPopupMenu menu;
    protected Controller()
    {
        init();
    }
    private void init()
    {

    }
    private void ActionBtnSearch()
    {
        String dataInput = TopBar.getInstance().textBox.getText();

        try {
            if (dataInput.length() > 0) {
                String dataOutput = ControllerDB.getInstance().SearchExplanByWordEng(dataInput);
                System.out.println(dataOutput.length());
                if(dataOutput.length() >0) {
                    ExplanWord.getInstance().setData(
                            dataInput,
                            dataOutput
                    );
                    CollectionContent.getInstance().AddItem(dataInput,0);
                    CollectionContent.getInstance().updateComponent();
                    CardLayout cardLayout = null;
                    cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                    cardLayout.show(view.ContentAreaMenuMain.getInstance(), "explan");
                }
                else{
                    ArrayList<String> res= DBConnect.getInstance().Lookup(dataInput);
                    if(res.size()>0) {
                        menu = new XJPopupMenu(mainFrame.getInstance());
                        JButton btnItem;
                        for (int i = 0; i < res.size(); i++) {
                            btnItem = new JButton(res.get(i));
                            btnItem.setBackground(Color.WHITE);

                            btnItem.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e) {

                                    System.out.println( ((JButton)e.getSource()).getText());
                                    menu.hidemenu();
                                    TopBar.getInstance().textBox.setText( ((JButton)e.getSource()).getText());

                                    ActionBtnSearch();

                                }
                            });
                            menu.add(btnItem);
                        }



                        //menu.setPopupSize(new Dimension(499, 500));
                        menu.show(mainFrame.getInstance(), 233, 75);
                    }
                    else {
                        System.out.println("éo thấy");
                        JOptionPane.showMessageDialog(mainFrame.getInstance(),
                                "Không Tìm Thấy Dữ Liệu Phù Hợp","Thông Báo",
                                JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        }catch (SQLException er)
        {
            System.out.println(er);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        String command = e.getActionCommand();
        if (command.equals("btnSearch")) {
            ActionBtnSearch();

        } else if (command.equals("btnMenuSearch")) {
            CardLayout cardLayout = null;

            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "search");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        } else if (command.equals("card")) {
            CardLayout cardLayout = null;

            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "ListCard");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        } else if (command.equals("learn")) {
            System.out.println("learn");
            CardLayout cardLayout = null;

            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "learn");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        } else if (command.equals("exam")) {
            System.out.println("exam");
            CardLayout cardLayout = null;

            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "exam");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        } else if (command.startsWith("ShowExplan#", 0)) {

                try {
                    for(int i =0; i < CollectionContent.getInstance().panel.getComponentCount(); i++)
                    {
                        if(command.equals("ShowExplan#"+i))
                        {
                            String wordEng =  ((WordItem)CollectionContent.getInstance().panel.getComponent(i)).getTextValue();
                            System.out.println(ControllerDB.getInstance().SearchExplanByWordEng(wordEng));
                            ExplanWord.getInstance().setData(
                                    wordEng,
                                    ControllerDB.getInstance().SearchExplanByWordEng(wordEng)
                            );

                        }
                    }
                    CardLayout cardLayout = null;
                    cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                    cardLayout.show(view.ContentAreaMenuMain.getInstance(), "explan");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            /*for (int i = 0; i < Dictionary.getInstance().size(); i++) {
                if (command.equals("addWordItem#" + i)) {
                    System.out.println("add " + i);
                    MessgeEditAndFavorites.getInstance().Title.setText("Thêm Thẻ Mới");
                    MessgeEditAndFavorites.getInstance().isAdd =true;
                    MessgeEditAndFavorites.getInstance().setIndexCollection(i+1);
                    MessgeEditAndFavorites.getInstance().setVisible(true);
                }
            }*/
        } else if (command.startsWith("editWordItem#", 0)) {


            /*for (int i = 0; i < Dictionary.getInstance().size(); i++) {
                if (command.equals("editWordItem#" + i)) {
                    System.out.println("edit " + i);
                    System.out.println("add " + i);
                    MessgeEditAndFavorites.getInstance().Title.setText("Chỉnh Sửa Thẻ");
                    MessgeEditAndFavorites.getInstance().isAdd =false;
                    MessgeEditAndFavorites.getInstance().setIndexCollection(-i);
                   MessgeEditAndFavorites.getInstance().setVisible(true);
                }
            }*/
        } else if (command.startsWith("addWorditemToFavorits#", 0)) {



            /*for (int i = 0; i < Dictionary.getInstance().size(); i++) {
                if (command.equals("addWorditemToFavorits##" + i)) {
                    System.out.println("addWorditemToFavorits# " + i);
                     FavoritesWordList.getInstance().add(new Word(
                        Dictionary.getInstance().get(i).getWord_target(),
                        Dictionary.getInstance().get(i).getWord_explain()
                     ));
                }
            }*/
        }
        else if (command.startsWith("deleteWordItem#", 0)) {

            try {
                for(int i =0; i < CollectionContent.getInstance().panel.getComponentCount();i++)
                {
                    if(command.equals("deleteWordItem#"+i))
                    {
                        CollectionContent.getInstance().panel.remove(i);
                        CollectionContent.getInstance().updateComponent();
                        CollectionContent.getInstance().updateUI();
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } else if (command.startsWith("addCardItem#", 0)) {


            try {

                for (int i = 0; i < ListCard.getInstance().panel.getComponentCount(); i++)
                {
                    if(command.equals("addCardItem#"+i))
                    {
                        MessgeEditAndFavorites.getInstance().resetAnhViet();
                        MessgeEditAndFavorites.getInstance().setTitle("Thêm Từ");
                        MessgeEditAndFavorites.getInstance().setIndexCollection(-1);
                        MessgeEditAndFavorites.getInstance().setVisible(true);

                        System.out.println("thêm");
                        System.out.println(((CardItem)ListCard.getInstance().panel.getComponent(i)).getTextBtnAnh());
                    }
                }
            }catch (SQLException er)
            {
                System.out.println(er);
            }


        } else if (command.startsWith("editCardItem#", 0)) {


            try {

                for (int i = 0; i < ListCard.getInstance().panel.getComponentCount(); i++)
                {
                    if(command.equals("editCardItem#"+i))
                    {
                        MessgeEditAndFavorites.getInstance().resetAnhViet();
                        MessgeEditAndFavorites.getInstance().setTitle("Sửa Từ");
                        MessgeEditAndFavorites.getInstance().setIndexCollection(i);
                        MessgeEditAndFavorites.getInstance().setVisible(true);

                        System.out.println("sửa");
                        System.out.println(((CardItem)ListCard.getInstance().panel.getComponent(i)).getTextBtnAnh());
                    }
                }
            }catch (SQLException er)
            {
                System.out.println(er);
            }

        } else if (command.startsWith("deleteCardItem#", 0)) {
            try {

                for (int i = 0; i < ListCard.getInstance().panel.getComponentCount(); i++)
                {
                    if(command.equals("deleteCardItem#"+i))
                    {
                        System.out.println("Xóa");
                        System.out.println(((CardItem)ListCard.getInstance().panel.getComponent(i)).getTextBtnAnh());
                        ListCard.getInstance().panel.remove(i);
                        ListCard.getInstance().reloadListCard();
                        ListCard.getInstance().panel.updateUI();

                    }
                }
            }catch (SQLException er)
            {
                System.out.println(er);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            /*for (int i = 0; i < Dictionary.getInstance().size(); i++) {
                if (command.equals("editWordItem#" + i)) {
                    System.out.println("edit " + i);
                    System.out.println("add " + i);
                    MessgeEditAndFavorites.getInstance().Title.setText("Chỉnh Sửa Thẻ");
                    MessgeEditAndFavorites.getInstance().isAdd =false;
                    MessgeEditAndFavorites.getInstance().setIndexCollection(-i);
                    MessgeEditAndFavorites.getInstance().setVisible(true);
                }
            }*/
        }


        else if (command.equals("btnOKMessage"))
        {

            if(MessgeEditAndFavorites.getInstance().txBoxVi.getText().length() >0&&
                    MessgeEditAndFavorites.getInstance().txBoxAnh.getText().length()>0)
            {
                try {
                    int index = MessgeEditAndFavorites.getInstance().getIndexCollection();
                    if (index == -1) // index == -1 thao tac thêm du lieu
                    {
                        System.out.println("them nhé :D");
                        ListCard.getInstance().panel.add(new CardItem(
                                MessgeEditAndFavorites.getInstance().getTxBoxAnh(),
                                MessgeEditAndFavorites.getInstance().getTxBoxVi(),
                                ListCard.getInstance().panel.getComponentCount()
                        ));
                        ListCard.getInstance().reloadListCard();
                        ListCard.getInstance().updateUI();

                    }
                    else {//sửa  data ở vị trí index

                        ((CardItem)(ListCard.getInstance().panel.getComponent(index))).setTextBtnAnh(
                                MessgeEditAndFavorites.getInstance().getTxBoxAnh()
                        );

                        ((CardItem)(ListCard.getInstance().panel.getComponent(index))).setTextBtnViet(
                                MessgeEditAndFavorites.getInstance().getTxBoxVi()
                        );
                        ListCard.getInstance().repaint();
                    }
                }catch (SQLException er)
                {
                    System.out.println(er);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                System.out.println(MessgeEditAndFavorites.getInstance().txBoxAnh.getText()+"==> "+
                        MessgeEditAndFavorites.getInstance().txBoxVi.getText());
                MessgeEditAndFavorites.getInstance().resetAnhViet();
                MessgeEditAndFavorites.getInstance().setVisible(false);
                // update phan layout nưa nhé  chưa code :D
            }
        }
    }
}
