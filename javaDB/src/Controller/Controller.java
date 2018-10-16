package Controller;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.ArrayResult;
import Model.Dictionary;
import Model.FavoritesWordList;
import Model.Word;
import view.Card.ListCard;
import view.MessgeEditAndFavorites;
import view.TopBar;
import view.search.CollectionContent;
import view.search.CollectionResult;

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
    protected Controller()
    {
        init();
    }
    private void init()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        String command = e.getActionCommand();
        if (command.equals("btnSearch")) {
            try {
                ArrayResult.getInstance().setData(TopBar.getInstance().textBox.getText());
                ArrayResult.getInstance().kq();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                CollectionResult.getInstance().loadding();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            CardLayout cardLayout = null;
            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "result");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.equals("btnMenuSearch")) {
            CardLayout cardLayout = null;
            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "search");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.equals("card")) {
            CardLayout cardLayout = null;
            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "ListCard");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.equals("learn")) {
            System.out.println("learn");
            CardLayout cardLayout = null;
            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "learn");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.equals("exam")) {
            System.out.println("exam");
            CardLayout cardLayout = null;
            try {
                cardLayout = (CardLayout) view.ContentAreaMenuMain.getInstance().getLayout();
                cardLayout.show(view.ContentAreaMenuMain.getInstance(), "exam");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.startsWith("addWordItem#", 0)) {



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


            /*for (int i = 0; i < Dictionary.getInstance().size(); i++) {
                if (command.equals("deleteWordItem#" + i)) {
                    System.out.println("delete " + i);
                    try {
                        CollectionContent.getInstance().removeOneItem(i);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    Dictionary.getInstance().remove(i);
                    try {
                        CollectionContent.getInstance().upload();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }*/
        } else if (command.equals("btnOKFormFavorites"))
        {

            /*if(MessgeEditAndFavorites.getInstance().txBoxVi.getText().length() >0&&
                    MessgeEditAndFavorites.getInstance().txBoxAnh.getText().length()>0)
            {
                int index = MessgeEditAndFavorites.getInstance().getIndexCollection();
                if(index >0) // index  > 0 thì là thao tac vơi Dictionary nho hon 0 thì thao tac với Favorites
                {
                    if(MessgeEditAndFavorites.getInstance().isAdd==true)
                    {
                        Dictionary.getInstance().add(new Word(
                                MessgeEditAndFavorites.getInstance().txBoxAnh.getText(),
                                MessgeEditAndFavorites.getInstance().txBoxVi.getText()
                        ));// thêm từ
                    }
                    else {
                        Dictionary.getInstance().get(index).setWord_target(
                                MessgeEditAndFavorites.getInstance().txBoxAnh.getText()); //set tieng anh
                        Dictionary.getInstance().get(index).setWord_explain(
                                MessgeEditAndFavorites.getInstance().txBoxVi.getText()//set tieng viet
                        );
                    }
                    try {
                        CollectionContent.getInstance().upload();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else
                {
                    if(MessgeEditAndFavorites.getInstance().isAdd ==true)
                    {
                        FavoritesWordList.getInstance().add(new Word(
                                MessgeEditAndFavorites.getInstance().txBoxAnh.getText(),
                                MessgeEditAndFavorites.getInstance().txBoxVi.getText()
                        ));// thêm từ
                    }else
                    {
                        FavoritesWordList.getInstance().get(-index).setWord_target(
                                MessgeEditAndFavorites.getInstance().txBoxAnh.getText()); //set tieng anh
                        FavoritesWordList.getInstance().get(-index).setWord_explain(
                                MessgeEditAndFavorites.getInstance().txBoxVi.getText()//set tieng viet

                        );

                    }
                    ListCard.getInstance().upload();
                }

                System.out.println(MessgeEditAndFavorites.getInstance().txBoxAnh.getText()+"==> "+
                        MessgeEditAndFavorites.getInstance().txBoxVi.getText());
                MessgeEditAndFavorites.getInstance().resetAnhViet();
                MessgeEditAndFavorites.getInstance().setVisible(false);
                // update phan layout nưa nhé  chưa code :D
            }*/
        }
    }
}
