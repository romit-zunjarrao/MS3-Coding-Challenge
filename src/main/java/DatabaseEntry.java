import java.sql.*;

/*
 this class in created to handle database operation

 */
public class DatabaseEntry {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";

    //variable used to have a instance reference to Database Connection object
    private Connection conn ;

    //create database Connection  is the method called from any other class who wants to connect to tha database
    //this method further call's  createDatabaseNTable()
    public void createDatabaseConnection()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            createDatabaseNTable();

        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    //this method is used to create a database named codingchallenge if it doesnot exist
    //it also delete the table userinfo every time the program in runned in order to erase the previous data and add new.
    public void createDatabaseNTable()
    {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("create database IF NOT EXISTS CodingChallenge");
            stmt.execute("use CodingChallenge");
            stmt.execute("drop table IF EXISTS UserInfo");
            stmt.execute("create table  UserInfo(A VARCHAR(15),B VARCHAR(20),C VARCHAR(40),D VARCHAR(20),E VARCHAR(10000), F VARCHAR(40),G VARCHAR(6),H VARCHAR(6),I VARCHAR(25),J VARCHAR(40))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //this method takes an user object and add's it to the database by using Prepared Statement.
    public void insertIntoDatabase(User user)
    {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into codingchallenge.userinfo values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,user.firstName);
            ps.setString(2,user.lastName);
            ps.setString(3,user.email);
            ps.setString(4,user.gender);
            ps.setString(5,user.image);
            ps.setString(6,user.cardType);
            ps.setString(7,user.cost);
            ps.setString(8,user.bolValue1);
            ps.setString(9,user.bolValue2);
            ps.setString(10,user.place);
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
