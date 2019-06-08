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
public class FlowerRepository implements Repository<Flower> {

	public FlwoerRepository() {
		
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
	public void addOrUpdate(Flower item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Flower> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flower get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Flower item) {
		// TODO Auto-generated method stub

	}

}
