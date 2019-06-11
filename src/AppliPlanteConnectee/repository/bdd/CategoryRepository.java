package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AppliPlanteConnectee.model.Category;
import AppliPlanteConnectee.repository.Repository;

public class CategoryRepository implements Repository<Category> {
	
	Connection conn = null;
	public List<Category> categories = new ArrayList<>();

	
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
		Statement statement = null;
		try {
            statement = conn.createStatement();
            int id = item.getId();
            String categoryFlower = item.getCategoryFlower();
            
            
            String add = "INSERT INTO Category(id, categoryFlower)" 
            + "VALUES ( ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(add);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, categoryFlower);
            
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
	public List<Category> getAll() {
		Statement statement = null;
		try {
            statement = conn.createStatement();
            
            
            String getAll = "SELECT * FROM Category;" ;
            PreparedStatement preparedStatement = conn.prepareStatement(getAll, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.executeUpdate();
            ResultSet resultat = statement.getGeneratedKeys();
            while (resultat.next()) {
            	Category category = new Category();
            	category.setId(resultat.getInt(1));
            	category.setCategoryFlower(resultat.getString(2));
            	categories.add(category);
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
        return categories;
	}

	@Override
	public Category get(int id) {
		Statement statement = null;
		try {
            statement = conn.createStatement();
            
            
            String get = "SELECT * FROM Category WHERE id = " + id  +";" ;
            PreparedStatement preparedStatement = conn.prepareStatement(get, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.executeUpdate();
            ResultSet resultat = statement.getGeneratedKeys();
            while (resultat.next()) {
            	Category category = new Category();
            	category.setId(resultat.getInt(1));
            	category.setCategoryFlower(resultat.getString(2));
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
		return category;
	}

	@Override
	public void remove(Category item) {
		Statement statement = null;
		try {
            statement = conn.createStatement();
            
            
            String remove = "DELETE FROM Category WHERE id = " + item.getId()  +";" ;
            PreparedStatement preparedStatement = conn.prepareStatement(remove);
            
            preparedStatement.executeUpdate();
            categories.remove(item);

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
