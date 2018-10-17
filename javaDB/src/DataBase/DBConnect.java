package DataBase;
import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
    private static DBConnect instance =null;
    public static DBConnect getInstance()
    {
        if(instance == null)
        {
            instance = new DBConnect("eng-viet_dictionary");
            return instance;
        }else
            return instance;
    }

    private Connection con;
    private Statement st;
    private PreparedStatement preSt;
    private ResultSet rs;
    public DBConnect(String DataBaseName)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DataBaseName,"root","");
            //st= con.createStatement();
            //con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void closeConnection() throws SQLException {
        if(st!=null) st.close();
        if(preSt!=null) preSt.close();
        if(rs!=null) rs.close();
        if(con!=null) con.close();
    }

    public ArrayList<String> Lookup(String words) throws SQLException {
        ArrayList<String> WordLookup = new ArrayList<>(30);
        String query = "SELECT word FROM tbl_edict Where word like '"+words+"%'";
        preSt = con.prepareStatement(query);
        //  preSt.setString('2',words);
        rs = preSt.executeQuery();
        int i = 0;
        while (rs.next()){
            if(i >= 30) break;
            WordLookup.add(rs.getString("word"));
            i++;
        }
        //db.deletetb2(words);
        return WordLookup;
    }


    public void insertData(String query) throws SQLException {

        preSt = con.prepareStatement(query);
        preSt.executeUpdate();
        if(preSt!=null) preSt.close();
    }

    public void updateData(String query) throws SQLException {
        preSt = con.prepareStatement(query);
        preSt.execute();
        preSt.close();
    }

    public void deleteData(String query) throws SQLException {
        preSt = con.prepareStatement(query);
        preSt.execute();
        preSt.close();
    }

    public ResultSet getData(String query)
    {
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            //System.out.println("recode from database");
            return rs;
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}

