package databaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class ConnectivityOfdata {

	@Test
public void getdata() throws SQLException
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata","root","root");
	    //Statement stmt=con.createStatement();
	    //ResultSet s=stmt.executeQuery("select * from users where password=?");
	    String query="select * from student where password=?";
	    PreparedStatement p=con.prepareStatement(query);
	    p.setString(1,"nikita");
	    ResultSet s=p.executeQuery();
	    while(s.next()) 
	    {
	    	System.out.println(s.getString(1)+" "+s.getString(2));
	    }
	    con.close();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
