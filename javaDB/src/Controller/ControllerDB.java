package Controller;

import DataBase.DBConnect;
import view.Card.CardItem;
import view.Card.ListCard;
import view.search.CollectionContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerDB implements ActionListener
{
    private static ControllerDB instance = null;
    public static ControllerDB getInstance()
    {
        if(instance ==null)
        {
            instance = new ControllerDB();
            return instance;
        }
        else return instance;
    }
    protected ControllerDB()
    {
        init();
    }
    protected void init()
    {

    }
    public ResultSet loadDataCardToFavoritesWord()
    {
        String query="SELECT * FROM `favorites_word`";
        ResultSet res = DBConnect.getInstance().getData(query);
        return res;
    }
    public void exportCardToDataBase() throws SQLException {
        //xóa toàn bộ
        String query ="DELETE FROM `favorites_word`";
        DBConnect.getInstance().deleteData(query);
        //insert vô
        String query2;

        JPanel data = ListCard.getInstance().panel;
        for(int i = 0;i < data.getComponentCount();i++)
        {
            query2 ="INSERT INTO `favorites_word`(`id`, `word`, `explan`, `mean`) VALUES (null,'"+
                    ((CardItem)(data.getComponent(i))).getTextBtnAnh()
                    +"','"+
                    ((CardItem)(data.getComponent(i))).getTextBtnViet()
                    +"','"+
                    ((CardItem)(data.getComponent(i))).getTextBtnViet()+"')";
            DBConnect.getInstance().insertData(query2);


        }

    }

    public void insertToHitory(String word, int index) throws SQLException {
        String query ="INSERT INTO `history`(`idx`, `word`) VALUES ("+index+",'"+word+"')";
        DBConnect.getInstance().insertData(query);
    }

    public void updateToHistory(String word, int i) throws SQLException {
        String query="UPDATE `history` SET `idx`="+i+",`word`='"+word+"' WHERE idx="+i;
        DBConnect.getInstance().updateData(query);
    }

    public String SearchExplanByWordEng(String inputText) throws SQLException {
        String query ="SELECT * FROM `tbl_edict` WHERE word='"+inputText+"'";
        ResultSet data = DBConnect.getInstance().getData(query);
        String kq ="";
        while(data.next())
        {
            kq = data.getString("detail");
        }

        return kq;
    }

    public ResultSet loadDataCollectionContent() throws SQLException {
        String query ="SELECT * FROM `history`";
        ResultSet data = DBConnect.getInstance().getData(query);
        //System.out.println("day la controller");
       // System.out.println(data.next());
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
