package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import AppliPlanteConnectee.model.FlowerSpecies;
import AppliPlanteConnectee.model.FlowerSummary;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSummaryRepository implements Repository<FlowerSummaryRepository>{
	
	Connection conn = null;
	List<FlowerSummary> flowerSummarys;
	
public FlowerSummaryRepository() {
		

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
public void addOrUpdate(FlowerSummary item) {
	Statement statement = null;

	
	try {
        statement = conn.createStatement();
        int id = item.getId();
        int athmosphericTemperature = item.getAthmosphericTemperature();
        int luminosity = item.getLuminosity();
        boolean humidity = item.isHumidity();
        java.util.Date dateHour = item.getDateHour();
        int idConnectedFlower = item.getIdConnectedFlower();
        
        
        String add = "INSERT INTO FlowerSummary(id, athmosphericTemperature, luminosity, humidity, dateHour, idConnectedFLower)" 
        + "VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(add);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, athmosphericTemperature);
        preparedStatement.setInt(3, luminosity);
        preparedStatement.setBoolean(4, humidity);
        preparedStatement.setDate(4, dateHour);
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
	Statement statement = null;
	try {
        statement = conn.createStatement();
        
        
        String getAll = "SELECT * FROM FlowerSummary;" ;
        PreparedStatement preparedStatement = conn.prepareStatement(getAll);
        
        preparedStatement.executeUpdate();
        for (FlowerSummary flowerSummary: preparedStatement) {

			flowerSummarys.add(flowerSummary);
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
public FlowerSummary get(int id) {
	Statement statement = null;
	try {
        statement = conn.createStatement();
        
        
        String get = "SELECT * FROM FlowerSummary WHERE id = " + id  +";" ;
        PreparedStatement preparedStatement = conn.prepareStatement(get);
        
        preparedStatement.executeUpdate();

		FlowerSummary.add(item);

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
public void remove(FlowerSummary item) {
	Statement statement = null;
	try {
        statement = conn.createStatement();
        
        
        String remove = "DELETE FROM FlowerSpummary WHERE id = " + item.getId()  +";" ;
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
