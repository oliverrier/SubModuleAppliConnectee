/**
 * 
 */
package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import AppliPlanteConnectee.model.Category;
import AppliPlanteConnectee.model.ConnectedFlower;
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
		try {
            statement = conn.createStatement();
            
            
            String getAll = "SELECT * FROM ConnectedFlower;" ;
            PreparedStatement preparedStatement = conn.prepareStatement(getAll);
            
            preparedStatement.executeUpdate();
            for (ConnectedFlower connectedFlower : preparedStatement) {
            	connectedFlowers.add(connectedFlower);
			}
//            rs = statement.executeQuery(add);
//            while (rs.next()) {
//            System.out.println(rs.getString(""));    
//            }
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
	public ConnectedFlower get(int id) {
		Statement statement = null;
		try {
            statement = conn.createStatement();
            
            
            String get = "SELECT * FROM ConnectedFlower WHERE id = " + id  +";" ;
            PreparedStatement preparedStatement = conn.prepareStatement(get);
            
            preparedStatement.executeUpdate();
            connectedFlowers.add(item);

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
