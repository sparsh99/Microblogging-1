
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class LoginAuth{

	private static final String dbClassName = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://127.0.0.1/test";	

	private static PrintStream output;
	@SuppressWarnings("unused")
	private Socket sock;
	private static Properties admin;
	private static Connection con;

	public static void main(String [] args){
		try{
				admin = new Properties();
				admin.put("user","root");
				admin.put("password","ritesh123");
				Class.forName(dbClassName);
				con = DriverManager.getConnection(CONNECTION, admin);
				PreparedStatement ps = con.prepareStatement("select * from test.test");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
					System.out.println(rs.getString("name"));
			}
		catch(Exception e){
			System.out.println("Exception");
		}
	}
		
}