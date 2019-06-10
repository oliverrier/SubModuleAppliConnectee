package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import AppliPlanteConnectee.model.Category;
import AppliPlanteConnectee.repository.Repository;

public class CategoryRepository implements Repository<Category> {
	
	Connection conn = null;
	
public CategoryRepository() {
		

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
	public void addOrUpdate(Category item) {
		Statement st;
		try {
            st = conn.createStatement();
            int id = item.getId();
            
            
            String add = "INSERT INTO plant(plant_id, plant_nom, plant_catégorie, plant_description, plant_optimal_humidity, plant_optimal_temp, plant_optimal_lum, plant_periode_floraison)" 
            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(add);
            preparedStatement.setInt(1, 31);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, catégorie);
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, humidityopti);
            preparedStatement.setString(6, tempopti);
            preparedStatement.setString(7, lumopti);
            preparedStatement.setString(8, periodeflo);
            
            preparedStatement.executeUpdate();
//            rs = st.executeQuery(add);
//            while (rs.next()) {
//            System.out.println(rs.getString(""));    
//            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
//                conn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }    
        }
    }

	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Category item) {
		// TODO Auto-generated method stub

	}

}
