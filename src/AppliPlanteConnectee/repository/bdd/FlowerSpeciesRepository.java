package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.model.FlowerSpecies;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSpeciesRepository implements Repository<FlowerSpecies>{
	
	Connection conn = null;
	List<FlowerSpecies> listFlowerSpecies;
	
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
	public void addOrUpdate(FlowerSpecies item) {
		Statement statement = null;
	
		
		try {
	        statement = conn.createStatement();
	        int id = item.getId();
	        String name = item.getName();
	        String description = item.getDescription();
	        int temperature = item.getTemperature();
	        int luminosity = item.getLuminosity();
	        boolean humidity = item.isHumidity();
	        String blossomingPeriodStart = item.getBlossomingPeriodStart();
	        String blossomingPeriodEnd = item.getBlossomingPeriodEnd();
	        int idCategory = item.getIdCategory();
	        
	        
	        String add = "INSERT INTO FlowerSpecies(id, name, description, temperature, luminosity, humidity, blossomingPeriodStart, blossomingPeriodEnd, idCategory)" 
	        + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = conn.prepareStatement(add);
	        preparedStatement.setInt(1, id);
	        preparedStatement.setString(2, name);
	        preparedStatement.setString(3, description);
	        preparedStatement.setInt(4, temperature);
	        preparedStatement.setInt(5, luminosity);
	        preparedStatement.setBoolean(6, humidity);
	        preparedStatement.setString(7, blossomingPeriodStart);
	        preparedStatement.setString(8, blossomingPeriodEnd);
	        preparedStatement.setInt(9, idCategory);
	        
	        preparedStatement.executeUpdate();
	
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }    
	    }
	}
	
	
	@Override
	public List<FlowerSpecies> getAll() {
		Statement statement = null;
		try {
	        statement = conn.createStatement();
	        
	        
	        String getAll = "SELECT * FROM FlowerSpecies;" ;
	        PreparedStatement preparedStatement = conn.prepareStatement(getAll);
	        
	        preparedStatement.executeUpdate();
	        for (FlowerSpecies flowerSpecies : preparedStatement) {
	        	listFlowerSpecies.add(flowerSpecies);
			}
	//        rs = statement.executeQuery(add);
	//        while (rs.next()) {
	//        System.out.println(rs.getString(""));    
	//        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }    
	    }
	}
	
	@Override
	public FlowerSpecies get(int id) {
		Statement statement = null;
		try {
	        statement = conn.createStatement();
	        
	        
	        String get = "SELECT * FROM ConnectedFlower WHERE id = " + id  +";" ;
	        PreparedStatement preparedStatement = conn.prepareStatement(get);
	        
	        preparedStatement.executeUpdate();
	
			FlowerSpecies.add(item);
	
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }    
	    }
	}
	
	@Override
	public void remove(FlowerSpecies item) {
		Statement statement = null;
		try {
	        statement = conn.createStatement();
	        
	        
	        String remove = "DELETE FROM FlowerSpecies WHERE id = " + item.getId()  +";" ;
	        PreparedStatement preparedStatement = conn.prepareStatement(remove);
	        
	        preparedStatement.executeUpdate();
	        listFlowerSpecies.remove(item);
	
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }    
	    }
	
	}

}
