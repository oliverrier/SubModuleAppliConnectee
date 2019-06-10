/**
 * 
 */
package AppliPlanteConnectee;

import java.io.IOException;

import AppliPlanteConnectee.repository.bdd.ConnectedFlowerRepository;
import AppliPlanteConnectee.repository.offline.ConnectedFlowerOfflineRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.repository.Repository;
import AppliPlanteConnectee.repository.bdd.ConnectedFlowerRepository;

/**
 * @author sebbo
 *
 */
public class AppliPlanteConnectee extends Application {

	public static AppliPlanteConnectee instance;

	private Stage primaryStage;

	public Repository<ConnectedFlower> connectedFlowerRepository = new ConnectedFlowerOfflineRepository();

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
