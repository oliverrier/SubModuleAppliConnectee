/**
 * 
 */
package AppliPlanteConnectee;

// Import
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// Javafx import

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Model import

import AppliPlanteConnectee.model.Category;
import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.model.FlowerSpecies;
import AppliPlanteConnectee.model.FlowerSummary;
import AppliPlanteConnectee.model.Pictures;

// Repository import

import AppliPlanteConnectee.repository.Repository;

// Online DB repository import

import AppliPlanteConnectee.repository.bdd.ConnectedFlowerRepository;
import AppliPlanteConnectee.repository.bdd.CategoryRepository;
import AppliPlanteConnectee.repository.bdd.FlowerSpeciesRepository;
import AppliPlanteConnectee.repository.bdd.FlowerSummaryRepository;
import AppliPlanteConnectee.repository.bdd.PicturesRepository;

// Offline DB repository import

import AppliPlanteConnectee.repository.offline.CategoryOfflineRepository;
import AppliPlanteConnectee.repository.offline.ConnectedFlowerOfflineRepository;
import AppliPlanteConnectee.repository.offline.FlowerSpeciesOfflineRepository;
import AppliPlanteConnectee.repository.offline.FlowerSummaryOfflineRepository;
import AppliPlanteConnectee.repository.offline.PicturesOfflineRepository;





/**
 * @author sebbo
 *
 */
public class AppliPlanteConnectee extends Application{

	public static AppliPlanteConnectee instance;

	private Stage primaryStage;
	
	// Repository creation

	public Repository<ConnectedFlower> connectedFlowerRepository = new ConnectedFlowerOfflineRepository();
	public Repository<FlowerSpecies> flowerSpeciesRepository = new FlowerSpeciesOfflineRepository();
	public Repository<FlowerSummary> flowerSummaryRepository = new FlowerSummaryRepository();
	public Repository<Category> categoryRepository = new CategoryOfflineRepository();
	public Repository<Pictures> picturesRepository = new PicturesOfflineRepository();

	@Override
	public void start(Stage primaryStage) throws Exception {
		instance = this;
		this.primaryStage = primaryStage;

		changePage("view/home/HomeView.fxml");

		primaryStage.setTitle("Plante connectée");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
		
	}

	public void changePage(String page) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(page));
			primaryStage.setScene(new Scene(root, 800, 600));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
