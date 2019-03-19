package databaseConnectivity;
import java.sql.*;
public class DatabaseConnectivityCodeUsingJDBC {
	
public static void main(String[] args) throws ReflectiveOperationException, SQLException {
	
	String Query="Select * from student where rollno=2";
	
	
	Class.forName("com.mysql.jdbc.Driver");
	
	
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata","root","root");

	
	Statement st=con.createStatement();
ResultSet rs=st.executeQuery(Query);
rs.next();
String sname=rs.getString(2);
System.out.println(sname);


//con.close();

}
}
