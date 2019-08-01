package app;


import java.sql.*;
public class MySql{
//    Controller cont;
//    private ResultSet resultSet = null;
//    public  void setDatabase()throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//       Connection connect = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/primary_school","root","28oct1999");
//        Statement statement = connect.createStatement();
//        ResultSet resultSet = statement
//                .executeQuery("select * from Details");
//        PreparedStatement  preparedStatement = connect.prepareStatement("insert into MDM values (sql)");
        static Connection con;
        static
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/primary_school","root","28oct1999");
            }
            catch(Exception e)
            {
                System.out.println("Error Occur "+e);
            }
        }
//        preparedStatement.setString(1,cont.sql);
    }

//public class MySql {
//
//    // private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;

//    public static void setDatabase(Data data,EmailMethods methods)throws ClassNotFoundException, SQLException {
//
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connect = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/emailapplication","root","28oct1999");
//        Statement statement = connect.createStatement();
//        ResultSet resultSet = statement
//                .executeQuery("select * from Details");
//
//
//
//        // PreparedStatements can use variables and are more efficient
//        PreparedStatement  preparedStatement = connect
//                .prepareStatement("insert into Details values (?, ?, ?, ?)");
//        // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//        // Parameters start with 1
//        preparedStatement.setString(1, data.getFirstName());
//        preparedStatement.setString(2, data.getLastName());
//        preparedStatement.setString(3, methods.getEmail(data));
//        preparedStatement.setString(4, data.getPassword());
//        preparedStatement.executeUpdate();
//
//        preparedStatement = connect
//                .prepareStatement("SELECT * from Details");
//        resultSet = preparedStatement.executeQuery();
//
//    }
//
//}
