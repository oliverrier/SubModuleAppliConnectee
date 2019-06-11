package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

import AppliPlanteConnectee.model.FlowerSummary;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSummaryRepository implements Repository<FlowerSummary>{
	
	Connection conn = null;
	List<FlowerSummary> flowerSummarys;
	
public FlowerSummaryRepository() {
		

		try {
			// db parameters
			
			String username ="qlp";
			String password ="qlp";
			String url = "jdbc:mysql://192.168.43.23:3306/connectedFlower";
			// create a connection to the database
			conn = DriverManager.getConnection(url, username, password);

			System.out.println("Connection to MySQL has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

@Override
public void addOrUpdate(FlowerSummary item) {
	Statement statement = null;

	
	try {
        statement = conn.createStatement();
        int id = item.getId();
        int athmosphericTemperature = item.getAthmosphericTemperature();
        int luminosity = item.getLuminosity();
        boolean humidity = item.isHumidity();
        Date dateHour = item.getDateHour();
        int idConnectedFlower = item.getIdConnectedFlower();
        
        
        String add = "INSERT INTO FlowerSummary(id, athmosphericTemperature, luminosity, humidity, dateHour, idConnectedFLower)" 
        + "VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(add);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, athmosphericTemperature);
        preparedStatement.setInt(3, luminosity);
        preparedStatement.setBoolean(4, humidity);
        preparedStatement.setDate(4, (java.sql.Date) dateHour);
        preparedStatement.setInt(5, idConnectedFlower);
        
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
public List<FlowerSummary> getAll() {
	FlowerSummary flowerSummary = new FlowerSummary();
	try {
        
        
        String getAll = "SELECT * FROM FlowerSummary;" ;
        PreparedStatement preparedStatement = conn.prepareStatement(getAll, Statement.RETURN_GENERATED_KEYS);
        
        preparedStatement.executeUpdate();
        System.out.println(preparedStatement);
        ResultSet resultat = preparedStatement.getGeneratedKeys();
        System.out.println(resultat.next());
        while (!resultat.next()) {

        	flowerSummary.setId(resultat.getInt(1));
        	flowerSummary.setAthmosphericTemperature(resultat.getInt(2));
        	flowerSummary.setLuminosity(resultat.getInt(3));
        	flowerSummary.setHumidity(resultat.getBoolean(4));
        	flowerSummary.setDateHour(resultat.getDate(5));
        	flowerSummary.setIdConnectedFlower(resultat.getInt(6));
        	flowerSummarys.add(flowerSummary);
		}
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }   
	return flowerSummarys;
}

@Override
public FlowerSummary get(int id) {
	Statement statement = null;
	FlowerSummary flowerSummary = new FlowerSummary();
	try {
        statement = conn.createStatement();
        
        
        String get = "SELECT * FROM FlowerSummary WHERE id = " + id  +";" ;
        PreparedStatement preparedStatement = conn.prepareStatement(get, Statement.RETURN_GENERATED_KEYS);
        
        preparedStatement.executeUpdate();
        ResultSet resultat = statement.getGeneratedKeys();
        while (resultat.next()) {

        	flowerSummary.setId(resultat.getInt(1));
        	flowerSummary.setAthmosphericTemperature(resultat.getInt(2));
        	flowerSummary.setLuminosity(resultat.getInt(3));
        	flowerSummary.setHumidity(resultat.getBoolean(4));
        	flowerSummary.setDateHour(resultat.getDate(5));
        	flowerSummary.setIdConnectedFlower(resultat.getInt(6));
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
	return flowerSummary;
}

public FlowerSummary getSummaryFromFlower(int id) {
	Statement statement = null;
	FlowerSummary flowerSummary = new FlowerSummary();
	try {
        statement = conn.createStatement();

        
        
        String get = "SELECT * FROM FlowerSummary JOIN ConnectedFlower ON FlowerSummary.idConnectedFlower = ConnectedFlower.id WHERE ConnectedFlower.id = " + id + ";" ;
        PreparedStatement preparedStatement = conn.prepareStatement(get, Statement.RETURN_GENERATED_KEYS);
        
        preparedStatement.executeUpdate();
        ResultSet resultat = statement.getGeneratedKeys();
        while (resultat.next()) {

        	flowerSummary.setId(resultat.getInt(1));
        	flowerSummary.setAthmosphericTemperature(resultat.getInt(2));
        	flowerSummary.setLuminosity(resultat.getInt(3));
        	flowerSummary.setHumidity(resultat.getBoolean(4));
        	flowerSummary.setDateHour(resultat.getDate(5));
        	flowerSummary.setIdConnectedFlower(resultat.getInt(6));
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
	return flowerSummary;
}

@Override
public void remove(FlowerSummary item) {
	Statement statement = null;
	try {
        statement = conn.createStatement();
        
        
        String remove = "DELETE FROM FlowerSummary WHERE id = " + item.getId()  +";" ;
        PreparedStatement preparedStatement = conn.prepareStatement(remove);
        
        preparedStatement.executeUpdate();
        flowerSummarys.remove(item);

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

