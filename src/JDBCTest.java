import java.sql.*;

public class JDBCTest {

	public static void main(String args[]) throws SQLException {
		String URL = "jdbc:derby://localhost:1527/java";
		Connection conn = DriverManager.getConnection(URL);
		
		String sqltxt;
		sqltxt = "SELECT ID, FIRSTNAME, LASTNAME, FROM EMPLOYEE";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sqltxt);
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
		rs.close();
		
		sqltxt = "UPDATE EMPLOYEE SET LASTNAME = 'Smithers' " + " WHERE id = 9883";
		int uc = stmt.executeUpdate(sqltxt);
		System.out.println("/n" + uc + " row(s) updated.");
		
		stmt.close();
		conn.close();
	}
}
