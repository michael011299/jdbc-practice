package jdbc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements Closeable {

	private final Connection conn;

	public PetDAO(String url, String user, String pass) throws SQLException {
		super();
		this.conn = DriverManager.getConnection(url, user, pass);
	}

	public int create(String name, int age, String breed) {
		try (PreparedStatement stmnt = conn
				.prepareStatement("INSERT INTO pets_table (name, age, breed) VALUES (?, ?, ?)");) {
			stmnt.setString(1, name);
			stmnt.setInt(2, age);
			stmnt.setString(3, breed);

			return stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Pet> read() {
		List<Pet> pets = new ArrayList<>();

		try (Statement stmnt = conn.createStatement();
				ResultSet results = stmnt.executeQuery("SELECT * FROM pets_table");) {
			while (results.next()) {
				int id = results.getInt(1);
				String name = results.getString("name");
				int age = results.getInt("age");
				String breed = results.getString("breed");

				pets.add(new Pet(id, name, age, breed));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(pets);
		return pets;
	}

	public int update(int age, String name) {
		try (PreparedStatement stmnt = conn.prepareStatement("UPDATE pets_table SET age = ? WHERE name = ?");) {
			stmnt.setInt(1, age);
			stmnt.setString(2, name);

			return stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String name, int age, String breed) {
		try (PreparedStatement stmnt = conn.prepareStatement("UPDATE pets_table SET age = ? WHERE name = ?");) {
			stmnt.setInt(1, age);
			stmnt.setString(2, name);

			return stmnt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void close() throws IOException {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
