package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSpeciesRepository implements Repository<ConnectedFlower>{
	
	Connection conn = null;
	
public FlowerSpeciesRepository() {
		

		try {
			// db parameters
			String url = "jdbc:mysql://localhost:3306/ConnectedFlowers";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to MySQL has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addOrUpdate(ConnectedFlower item) {
		try {
			stmt = conn.createStatement();
			String nom = item.getName();
			
		}

	}

	@Override
	public List<ConnectedFlower> getAll() {



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
