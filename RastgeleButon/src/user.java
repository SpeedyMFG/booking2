import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class user {

	private int ID;
	private String Name, Surname, Pass, TC_No, Email, Type;
	Statement statement = null;
	Connection connection = null;
	ResultSet result = null;
	PreparedStatement pStatement = null;
	private String UserName;

	DbHelper dbHelper = new DbHelper();

	public user() {

	}

	public user(int id, String name, String surname, String pass) {
		this.ID = id;
		this.Name = name;
		this.Surname = surname;
		this.Pass = pass;
	}

	public user(int id, String name, String surname, String pass, String username, String type) {
		super();
		this.ID = id;
		this.Name = name;
		this.Surname = surname;
		this.Pass = pass;
		this.UserName = username;
	}

	public user(int id, String name, String surname, String pass, String TC_No, String email, String type) {
		super();
		this.ID = id;
		this.Name = name;
		this.Surname = surname;
		this.Pass = pass;
		this.TC_No = TC_No;
		this.Email = email;
	}

	public ArrayList<user> adminList() throws SQLException {
		ArrayList<user> yoneticiList = new ArrayList<user>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.admin");
			user admin;
			while (result.next()) {
				admin = new user(result.getInt("ID"), result.getString("Name"), result.getString("Surname"),
						result.getString("Pass"));
				yoneticiList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return yoneticiList;

	}

	public boolean addSubAdmin(String Name, String Surname, String Pass, String UserName) throws SQLException {
		boolean key = false;
		try {
			String query = "INSERT INTO booking.admin (Name, Surname, Pass, UserName) VALUES (?, ?, ?, ?)";
			statement = connection.createStatement();
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, Name);
			pStatement.setString(2, Surname);
			pStatement.setString(3, Pass);
			pStatement.setString(4, "burayi_duzelt");
			pStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (key) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delSubAdmin(int ID) throws SQLException {
		boolean key;
		String query = "DELETE FROM booking.admin WHERE ID = ?";
		statement = connection.createStatement();
		pStatement = connection.prepareStatement(query);
		pStatement.setInt(1, ID);
		pStatement.executeUpdate();
		key = true;

		if (key) {
			return true;
		} else {
			return false;
		}
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getTC_No() {
		return TC_No;
	}

	public void setTC_No(String tC_No) {
		TC_No = tC_No;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return UserName;
	}

	public void setUsername(String username) {
		this.UserName = username;
	}

}