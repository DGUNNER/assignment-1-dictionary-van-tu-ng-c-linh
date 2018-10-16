package DataBase;
import java.sql.*;

public class DBConnect {
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

