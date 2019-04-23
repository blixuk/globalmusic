import java.sql.*;

public class DB
{
	private static java.sql.Connection sqlConnection;
	
	private static java.sql.Connection getConnection() throws java.sql.SQLException, java.lang.ClassNotFoundException {
		if(sqlConnection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			sqlConnection = DriverManager.getConnection("jdbc:mysql://" + Config.getHost(), Config.getUser(), Config.getPass());
		}
		return sqlConnection;
	}
	
	private static boolean createDatabase() throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		statement.execute("CREATE DATABASE IF NOT EXISTS " + Config.getName());
		Logging.log("DB: Database Created");
		statement.close();
		return true;
	}

	private static boolean createTable(String data) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		statement.execute("CREATE TABLE IF NOT EXISTS " + Config.getName() + "." + data);
		Logging.log("DB: Table Created: " + data);
		statement.close();
		return true;
	}

	private static int getCount(String table) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		int count = 0;
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT COUNT(ID) as RowNum FROM " + Config.getName() + "." + table);
		rs.next();
		count = rs.getInt("RowNum");
		rs.close();
		statement.close();
		return count;
	}

	private static boolean deleteID(String table, int id) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		statement.execute("DELETE FROM " + Config.getName() + "." + table + " where ID =" + id);
		Logging.log("DB: ID Deleted: " + table + ": " + id);
		statement.close();
		return true;
	}

}
