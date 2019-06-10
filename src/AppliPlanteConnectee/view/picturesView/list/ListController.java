package AppliPlanteConnectee.view.picturesView.list;

import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.AppliPlanteConnectee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

	@FXML
	private TableView<ConnectedFlower> table;

	@SuppressWarnings("unchecked")
	public void initialize() {
		table.getColumns().clear();

		TableColumn<ConnectedFlower, Integer> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<ConnectedFlower, String> columnName = new TableColumn<>("Nom");
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<ConnectedFlower, Integer> columnActualTemperature = new TableColumn<>("Temperature Actuelle");
		columnActualTemperature.setCellValueFactory(new PropertyValueFactory<>("actualTemperature"));
		
		TableColumn<ConnectedFlower, Integer> columnActualLuminosity = new TableColumn<>("Luminositée Actuelle");
		columnActualLuminosity.setCellValueFactory(new PropertyValueFactory<>("actualLuminosity"));

		TableColumn<ConnectedFlower, Boolean> columnActualHumidity = new TableColumn<>("Humidité Actuelle");
		columnActualHumidity.setCellValueFactory(new PropertyValueFactory<>("actualHumidity"));
		
		TableColumn<ConnectedFlower, String> columnTime = new TableColumn<>("Date du dernier relevé");
		columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

		table.getColumns().addAll(columnId, columnName, columnActualTemperature, columnActualLuminosity, columnActualHumidity, columnTime);

		table.setItems(FXCollections.observableArrayList(AppliPlanteConnectee.instance.connectedFlowerRepository.getAll()));

	}

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}
}