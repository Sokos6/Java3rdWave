import java.sql.SQLException;

public class SQLUtils {
	public static String formatSQLException(SQLException e) {
		StringBuilder msg = new StringBuilder("");
		if (e != null) {
			msg.append(" SQLState: " + e.getSQLState() + "\n");
			msg.append(" Code: " + e.getErrorCode() + "\n");
			msg.append(" Message: " + e.getMessage() + "\n\n");
		}
		return msg.toString();
	}

	public static String formatSQLExceptions(SQLException e) {
		String msg = "";
		while (e != null) {
			msg += formatSQLException(e);
			e = e.getNextException();
		}
		return msg;
		// Call this method from a catch handler to print nice error messages.
	}

	public static void printSQLErrors(SQLException e) {
		if (e != null) {
			System.err.println("SQL Error:\n" + formatSQLExceptions(e));
} }