/**
 * 
 */
package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import AppliPlanteConnectee.model.Category;
import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.model.FlowerSummary;
import AppliPlanteConnectee.repository.Repository;

/**
 * @author sebbo
 *
 */
public class ConnectedFlowerRepository implements Repository<ConnectedFlower> {

	Connection conn = null;
	List<ConnectedFlower> connectedFlowers;
	
	public ConnectedFlowerRepository() {
		

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
	public void addOrUpdate(ConnectedFlower item) {
		Statement statement = null;

    	
		try {
            statement = conn.createStatement();
            int id = item.getId();
            String name = item.getName();
            int idFlowerSpecies = item.getIdFlowerSpecies();
            
            
            String add = "INSERT INTO ConectedFlower(id, name, idFlowerSpecies)" 
            + "VALUES ( ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(add);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, idFlowerSpecies);
            
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
	public List<ConnectedFlower> getAll() {
		Statement statement = null;
		ConnectedFlower connectedFlower = new ConnectedFlower();
		try {
	        statement = conn.createStatement();
	        
	        
	        String getAll = "SELECT * FROM ConnectedFlower;" ;
	        PreparedStatement preparedStatement = conn.prepareStatement(getAll, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.executeUpdate();
	        ResultSet resultat = statement.getGeneratedKeys();
	        while (resultat.next()) {

	        	connectedFlower.setId(resultat.getInt(1));
	        	connectedFlower.setName(resultat.getString(2));
	        	connectedFlower.setIdFlowerSpecies(resultat.getInt(3));
	        	connectedFlowers.add(connectedFlower);
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
		return connectedFlowers;
	}

	@Override
	public ConnectedFlower get(int id) {
		Statement statement = null;
		ConnectedFlower connectedFlower = new ConnectedFlower();
		
		try {
            statement = conn.createStatement();
            
            
            String get = "SELECT * FROM ConnectedFlower WHERE id = " + id  +";" ;
            PreparedStatement preparedStatement = conn.prepareStatement(get);
            
            preparedStatement.executeUpdate();
            ResultSet resultat = statement.getGeneratedKeys();
            while (resultat.next()) {

            	connectedFlower.setId(resultat.getInt(1));
	        	connectedFlower.setName(resultat.getString(2));
	        	connectedFlower.setIdFlowerSpecies(resultat.getInt(3));

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
    	return connectedFlower;
	}

	@Override
	public void remove(ConnectedFlower item) {
		Statement statement = null;
		try {
            statement = conn.createStatement();
            
            
            String remove = "DELETE FROM ConnectedFlower WHERE id = " + item.getId()  +";" ;
            PreparedStatement preparedStatement = conn.prepareStatement(remove);
            
            preparedStatement.executeUpdate();
            connectedFlowers.remove(item);

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
