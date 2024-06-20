package jdbc;

import java.sql.*; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Scanner;

public class UserAutgentication2 {
		 private static Connection connect() { 
		  String url = "jdbc:mysql://localhost:3306/database1"; 
		  String user = "root"; 
		  String password = "root"; 
		  Connection conn = null; 
		  try { 
		   conn = DriverManager.getConnection(url, user, password); 
		  } catch (SQLException e) { 
		   System.out.println(e.getMessage()); 
		  } 
		  return conn; 
		 } 
		 private static String hashPassword(String password) { 
		  try { 
		   MessageDigest md = MessageDigest.getInstance("SHA-256"); 
		   byte[] hash = md.digest(password.getBytes()); 
		   StringBuilder hexString = new StringBuilder(); 
		   for (byte b : hash) { 
		    hexString.append(String.format("%02x", b)); 
		   } 
		   return hexString.toString(); 
		  } catch (NoSuchAlgorithmException e) { 
		   throw new RuntimeException(e); 
		  } 
		 } 
		 private static void createNewTable() { 
		  String sql = "CREATE TABLE IF NOT EXISTS User (\n" + " UserID 
		VARCHAR(50) PRIMARY KEY,\n" 
		    + " Password VARCHAR(64) NOT NULL\n" + ");"; 
		 
		  try (Connection conn = connect(); Statement stmt = 
		conn.createStatement()) { 
		   stmt.execute(sql); 
		  } catch (SQLException e) { 
		   System.out.println(e.getMessage()); 
		  } 
		 } 
		 
		 private static void insertUser(String userID, String password) { 
		  String sql = "INSERT INTO User(UserID, Password) VALUES(?, ?)"; 
		 
		  try (Connection conn = connect(); PreparedStatement pstmt = 
		conn.prepareStatement(sql)) { 
		   pstmt.setString(1, userID); 
		   pstmt.setString(2, hashPassword(password)); 
		   pstmt.executeUpdate(); 
		  } catch (SQLException e) { 
		   System.out.println(e.getMessage()); 
		  } 
		 } 
		 
		 private static boolean authenticateUser(String userID, String password) { 
		  String sql = "SELECT * FROM User WHERE UserID = ? AND Password = ?"; 
		 
		  try (Connection conn = connect(); PreparedStatement pstmt = 
		conn.prepareStatement(sql)) { 
		   pstmt.setString(1, userID); 
		   pstmt.setString(2, hashPassword(password)); 
		   ResultSet rs = pstmt.executeQuery(); 
		   return rs.next(); 
		  } catch (SQLException e) { 
		   System.out.println(e.getMessage()); 
		   return false; 
		  } 
		 } 
		 
		 public static void main(String[] args) { 
		  createNewTable(); 
		 
		  Scanner scanner = new Scanner(System.in); 
		  System.out.println("Enter UserID:"); 
		  String userID = scanner.nextLine(); 
		  System.out.println("Enter Password:"); 
		  String password = scanner.nextLine(); 
		 
		  insertUser(userID, password); 
		 
		  System.out.println("Enter UserID to authenticate:"); 
		  String authUserID = scanner.nextLine(); 
		  System.out.println("Enter Password to authenticate:"); 
		  String authPassword = scanner.nextLine(); 
		 
		  if (authenticateUser(authUserID, authPassword)) { 
		   System.out.println("User authenticated successfully."); 
		  } else { 
		   System.out.println("Authentication failed."); 
		  } 
		  scanner.close(); 
	 } 
} 

