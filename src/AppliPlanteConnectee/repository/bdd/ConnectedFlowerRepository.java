/**
 * 
 */
package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.repository.Repository;

/**
 * @author sebbo
 *
 */
public class ConnectedFlowerRepository implements Repository<ConnectedFlower> {

	public ConnectedFlowerRepository() {
		
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:D:\\Workspace\\AppliPlanteConnectee/qzdqzd.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to MySQL has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addOrUpdate(ConnectedFlower item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ConnectedFlower> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectedFlower get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ConnectedFlower item) {
		// TODO Auto-generated method stub

	}

}
