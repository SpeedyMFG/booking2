import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DbHelper;

public class SAdmin {

	private int filmID;
	private String filmName;
	private String filmType;
	private String filmDirector;
	private String filmSalon;
	private String filmSeans;

	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;

	public SAdmin() {

	}

	public SAdmin(int filmID, String filmName, String filmType, String filmDirector, String filmSalon,
			String filmSeans) {
		this.filmID = filmID;
		this.filmName = filmName;
		this.filmType = filmType;
		this.filmDirector = filmDirector;
		this.filmSalon = filmSalon;
		this.filmSeans = filmSeans;
	}

	public ArrayList<SAdmin> cinemaList() throws SQLException {
		ArrayList<SAdmin> filmList = new ArrayList<>();
		try {
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM booking.cinema");
			SAdmin sAdmin;
			while (result.next()) {
				sAdmin = new SAdmin(result.getInt("filmID"), result.getString("filmName"), result.getString("filmType"),
						result.getString("filmDirector"), result.getString("filmSalon"), result.getString("filmSeans"));
				filmList.add(sAdmin);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return filmList;
	}

	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getFilmDirector() {
		return filmDirector;
	}

	public void setFilmDirector(String filmDirector) {
		this.filmDirector = filmDirector;
	}

	public String getFilmSalon() {
		return filmSalon;
	}

	public void setFilmSalon(String filmSalon) {
		this.filmSalon = filmSalon;
	}

	public String getFilmSeans() {
		return filmSeans;
	}

	public void setFilmSeans(String filmSeans) {
		this.filmSeans = filmSeans;
	}

}
