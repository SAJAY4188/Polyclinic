import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddUser {

	static Connection con;
	public static void main(String[] args) {
		

		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/polyclinic", "root", "root@123");
			}catch(Exception e) {
				e.getMessage();
			}
			
			try {
				
				String sql = "create table UserAccount(Id int, Uname varchar(100), Pass varchar(100))";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.executeUpdate();
				System.out.println("query executed");
			} catch (Exception e) {
				
				e.getMessage();
			}
	}

}
