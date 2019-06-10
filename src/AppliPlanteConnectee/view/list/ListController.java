package AppliPlanteConnectee.view.list;

import AppliPlanteConnectee.model.Flower;
import AppliPlanteConnectee.AppliPlanteConnectee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

	@FXML
	private TableView<Flower> table;

	@SuppressWarnings("unchecked")
	public void initialize() {
		table.getColumns().clear();

		TableColumn<Flower, Integer> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<Flower, String> columnName = new TableColumn<>("Nom");
		columnName.setCellValueFactory(new PropertyValueFactory<>("flowerName"));

		TableColumn<Flower, Integer> columnActualTemperature = new TableColumn<>("Temperature Actuelle");
		columnActualTemperature.setCellValueFactory(new PropertyValueFactory<>("actualTemperature"));
		
		TableColumn<Flower, Integer> columnActualLuminosity = new TableColumn<>("Luminositée Actuelle");
		columnActualLuminosity.setCellValueFactory(new PropertyValueFactory<>("actualLuminosity"));

		TableColumn<Flower, Boolean> columnActualHumidity = new TableColumn<>("Humidité Actuelle");
		columnActualHumidity.setCellValueFactory(new PropertyValueFactory<>("actualHumidity"));
		
		TableColumn<Flower, String> columnTime = new TableColumn<>("Date du dernier relevé");
		columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

		table.getColumns().addAll(columnId, columnName, columnActualTemperature, columnActualLuminosity, columnActualHumidity, columnTime);

		table.setItems(FXCollections.observableArrayList(AppliPlanteConnectee.instance.FlowerRepository.getAll()));

	}

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}
}