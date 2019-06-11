package AppliPlanteConnectee.repository.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import AppliPlanteConnectee.model.Pictures;
import AppliPlanteConnectee.repository.Repository;

public class PicturesRepository implements Repository<Pictures>{
	
	List<Pictures> pictures;
	
	Connection conn = null;
	
public PicturesRepository() {

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
public void addOrUpdate(Pictures item) {
	Statement statement = null;
	try {
        statement = conn.createStatement();
        int id = item.getId();
        String picture = item.getPicture();
        int idFlowerSpecies = item.getIdFlowerSpecies();
        
        
        String add = "INSERT INTO Pictures(id, picture, idFlowerSpecies)" 
        + "VALUES ( ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(add);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, picture);
        preparedStatement.setInt(1, idFlowerSpecies);
        
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
public List<Pictures> getAll() {
	Statement statement = null;
	Pictures picture = new Pictures();
	try {
        statement = conn.createStatement();
        
        
        String getAll = "SELECT * FROM Pictures;" ;
        PreparedStatement preparedStatement = conn.prepareStatement(getAll);
        
        preparedStatement.executeUpdate();
        ResultSet resultat = statement.getGeneratedKeys();
        while (resultat.next()) {

        	picture.setId(resultat.getInt(1));
        	picture.setPicture(resultat.getString(2));
        	pictures.add(picture);
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
	return pictures;
}

@Override
public Pictures get(int id) {
	Statement statement = null;
	Pictures picture = new Pictures();
	try {
        statement = conn.createStatement();
        
        
        String get = "SELECT * FROM Pictures WHERE id = " + id  +";" ;
        PreparedStatement preparedStatement = conn.prepareStatement(get);
        
        preparedStatement.executeUpdate();
        ResultSet resultat = statement.getGeneratedKeys();
        while (resultat.next()) {
        	picture.setId(resultat.getInt(1));
        	picture.setPicture(resultat.getString(2));
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
	return picture;
}

@Override
public void remove(Pictures item) {
	Statement statement = null;
	try {
        statement = conn.createStatement();
        
        
        String remove = "DELETE FROM Pictures WHERE id = " + item.getId()  +";" ;
        PreparedStatement preparedStatement = conn.prepareStatement(remove);
        
        preparedStatement.executeUpdate();
        pictures.remove(item);

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
