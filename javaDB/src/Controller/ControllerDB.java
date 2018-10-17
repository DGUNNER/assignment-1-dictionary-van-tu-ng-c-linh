package Controller;

import DataBase.DBConnect;
import view.search.CollectionContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String query ="SELECT * FROM `tbl_edict` WHERE idx<30";
        ResultSet data = DBConnect.getInstance().getData(query);
        //System.out.println("day la controller");
       // System.out.println(data.next());
    return data;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
