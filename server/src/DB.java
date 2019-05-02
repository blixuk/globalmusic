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

	public static boolean createUser(String id, String username, String password, String fname, String lname, String email, String phone, String company, String dob, String sud, String type) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", id, username, password, fname, lname, email, phone, company, dob, sud, type);
		statement.execute("INSERT INTO `USER`(`ID`, `USERNAME`, `PASSWORD`, `FNAME`, `LNAME`, `EMAIL`, `PHONE`, `COMPANY`, `DOB`, `SUD`, `TYPE`) VALUES " + values);
		statement.close();
		return true;
	}

}
