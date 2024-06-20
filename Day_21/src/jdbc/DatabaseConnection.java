package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DatabaseConnection { 
 public static void main(String[] args) { 
  String url = "jdbc:mysql://localhost:3306/testdb"; 
  String user = "root"; 
  String password = "root"; 
 
  try (Connection conn = DriverManager.getConnection(url, user, password)) 
{ 
   if (conn != null) { 
    System.out.println("Connection to MySQL has been established."); 
    System.out.println(conn); 
   } 
  } catch (SQLException e) { 
   System.out.println(e.getMessage()); 
  } 
 } 
}

