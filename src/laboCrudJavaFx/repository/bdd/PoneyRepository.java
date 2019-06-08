/**
 * 
 */
package laboCrudJavaFx.repository.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import laboCrudJavaFx.model.Poney;
import laboCrudJavaFx.repository.Repository;

/**
 * @author sebbo
 *
 */
public class PoneyRepository implements Repository<Poney> {

	public PoneyRepository() {
		
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/Users/antoine/eclipse-workspace/LaboCrudJavaFx/qzdqzd.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addOrUpdate(Poney item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Poney> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Poney get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Poney item) {
		// TODO Auto-generated method stub

	}

}
