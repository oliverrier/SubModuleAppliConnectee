package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import AppliPlanteConnectee.model.FlowerSpecies;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSpeciesRepository implements Repository<FlowerSpecies>{
	
	Connection conn = null;
	private List<FlowerSpecies> listFlowerSpecies = new ArrayList<>();
	
public FlowerSpeciesRepository() {
    

		

		try {
			// db parameters
			String username ="qlp";
			String password ="qlp";
			String url = "jdbc:mysql://192.168.43.23:3306/connectedFlower?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=UTF-8";
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
		FlowerSpecies flowerSpecies = new FlowerSpecies();
		listFlowerSpecies.clear();
		try {
	        statement = conn.createStatement();
	        
	        
	        String getAll = "SELECT * FROM FlowerSpecies;" ;
	        PreparedStatement preparedStatement = conn.prepareStatement(getAll, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.executeUpdate();
	        ResultSet resultat = statement.getGeneratedKeys();
	        while (resultat.next()) {

	        	flowerSpecies.setId(resultat.getInt(1));
	        	flowerSpecies.setName(resultat.getString(2));
	        	flowerSpecies.setDescription(resultat.getString(3));
	        	flowerSpecies.setTemperature(resultat.getInt(4));
	        	flowerSpecies.setLuminosity(resultat.getInt(5));
	        	flowerSpecies.setHumidity(resultat.getBoolean(6));
	        	flowerSpecies.setBlossomingPeriodStart(resultat.getString(7));
	        	flowerSpecies.setBlossomingPeriodEnd(resultat.getString(8));
	        	flowerSpecies.setIdCategory(resultat.getInt(9));

	        	listFlowerSpecies.add(flowerSpecies);
			}
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
		return listFlowerSpecies;
	}
	
	@Override
	public FlowerSpecies get(int id) {
		Statement statement = null;
		FlowerSpecies flowerSpecies = new FlowerSpecies();
		try {
	        statement = conn.createStatement();
	        
	        
	        String get = "SELECT * FROM ConnectedFlower WHERE id = " + id  +";" ;
	        PreparedStatement preparedStatement = conn.prepareStatement(get);
	        
	        preparedStatement.executeUpdate();
	        ResultSet resultat = statement.getGeneratedKeys();
	        while (resultat.next()) {

	        	flowerSpecies.setId(resultat.getInt(1));
	        	flowerSpecies.setName(resultat.getString(2));
	        	flowerSpecies.setDescription(resultat.getString(3));
	        	flowerSpecies.setTemperature(resultat.getInt(4));
	        	flowerSpecies.setLuminosity(resultat.getInt(5));
	        	flowerSpecies.setHumidity(resultat.getBoolean(6));
	        	flowerSpecies.setBlossomingPeriodStart(resultat.getString(7));
	        	flowerSpecies.setBlossomingPeriodEnd(resultat.getString(8));
	        	flowerSpecies.setIdCategory(resultat.getInt(9));
			}
	
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
		return flowerSpecies;
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
