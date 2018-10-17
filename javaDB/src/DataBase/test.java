package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws SQLException {
        DBConnect.getInstance();

        ArrayList<String> res =DBConnect.getInstance().Lookup("a");
        for(int i =0; i< res.size(); i++)
        {
            System.out.println(res.get(i));
        }
    }
}
