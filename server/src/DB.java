import java.sql.*;

public class DB
{
	private static java.sql.Connection sqlConnection;
	
	private static java.sql.Connection getConnection() throws java.sql.SQLException, java.lang.ClassNotFoundException {
		if(sqlConnection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			sqlConnection = DriverManager.getConnection("jdbc:mysql://" + Config.getHost() + "/" + Config.getName(), Config.getUser(), Config.getPass());
		}
		return sqlConnection;
	}

	public static boolean createUser(String id, String username, String password, String fname, String lname, String email, String phone, String company, String dob, String sud, String type) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,'%s','%s','%s','%s','%s',%s,'%s','%s','%s',%s);", id, username, password, fname, lname, email, phone, company, dob, sud, type);
		statement.execute("INSERT INTO `USER`(`ID`, `USERNAME`, `PASSWORD`, `FNAME`, `LNAME`, `EMAIL`, `PHONE`, `COMPANY`, `DOB`, `SUD`, `TYPE`) VALUES " + values);
		statement.close();
		return true;
	}

	public static boolean createTicket(String id, String uid, String ufname, String ulname, String ucompany, String eid, String ename, String eprice, String evenue, String edate, String etime, String amount) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,%s,'%s','%s','%s',%s,'%s',%s,'%s','%s','%s',%s);", id, uid, ufname, ulname, ucompany, eid, ename, eprice, evenue, edate, etime, amount);
		statement.execute("INSERT INTO `ticket`(`ID`, `UID`, `UFNAME`, `ULNAME`, `UCOMPANY`, `EID`, `ENAME`, `EPRICE`, `EVENUE`, `EDATE`, `ETIME`, `AMOUNT`) VALUES " + values);
		statement.close();
		return true;
	}

	public static boolean createInvoice(String id, String uid, String ucompany, String eid, String ename, String eprice, String eamount, String edate, String etime, String dop) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,%s,'%s',%s,'%s',%s,%s,'%s','%s','%s');", id, uid, ucompany, eid, ename, eprice, eamount, edate, etime, dop);
		statement.execute("INSERT INTO `invoice`(`ID`, `UID`, `UCOMPANY`, `EDI`, `ENAME`, `EPRICE`, `EAMOUNT`, `EDATE`, `ETIME`, `DOP`) VALUES " + values);
		statement.close();
		return true;
	}

	public static boolean createEvent(String id, String name, String vid, String vname, String vaddress, String vcapacity, String date, String time, String bid, String bname, String price) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,'%s',%s,'%s','%s',%s,'%s','%s',%s,'%s',%s);", id, name, vid, vname, vaddress, vcapacity, date, time, bid, bname, price); 
		statement.execute("INSERT INTO `event`(`ID`, `NAME`, `vid`, `VNAME`, `VADDRESS`, `VCAPACITY`, `DATE`, `TIME`, `BID`, `BNAME`, `PRICE`) VALUES " + values);
		statement.close();
		return true;
	}

	public static boolean createBand(String id, String name, String bio, String genre, String members, String amount, String url, String image) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,'%s','%s','%s','%s',%s,'%s','%s');", id, name, bio, genre, members, amount, url, image);
		statement.execute("INSERT INTO `band`(`ID`, `NAME`, `bio`, `genre`, `members`, `amount`, `url`, `image`) VALUES " + values);
		statement.close();
		return true;
	}

	public static boolean createVenue(String id, String name, String address, String capacity) throws java.sql.SQLException, java.lang.ClassNotFoundException {
		Connection connection = getConnection();
		java.sql.Statement statement = connection.createStatement();
		String values = String.format("(%s,'%s','%s',%s);", id, name, address, capacity);
		statement.execute("INSERT INTO `venue`(`ID`, `NAME`, `ADDRESS`, `CAPACITY`) VALUES " + values);
		statement.close();
		return true;
	}
	
}
