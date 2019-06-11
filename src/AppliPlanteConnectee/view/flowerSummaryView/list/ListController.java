package AppliPlanteConnectee.view.flowerSummaryView.list;

import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.model.FlowerSummary;

import java.sql.Date;

import AppliPlanteConnectee.AppliPlanteConnectee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

	@FXML
	private TableView<FlowerSummary> table;

	@SuppressWarnings("unchecked")
	public void initialize() {
		table.getColumns().clear();

		TableColumn<FlowerSummary, Integer> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<FlowerSummary, Integer> columnAthmosphericTemperature = new TableColumn<>("Température athmosphérique");
		columnAthmosphericTemperature.setCellValueFactory(new PropertyValueFactory<>("athmosphericTemperature"));

		TableColumn<FlowerSummary, Integer> columnLuminosity = new TableColumn<>("Luminosité Actuelle");
		columnLuminosity.setCellValueFactory(new PropertyValueFactory<>("luminosity"));

		TableColumn<FlowerSummary, Boolean> columnActualHumidity = new TableColumn<>("Humidité Actuelle");
		columnActualHumidity.setCellValueFactory(new PropertyValueFactory<>("Humidity"));
		
		TableColumn<FlowerSummary, Date> columnTime = new TableColumn<>("Date du dernier relevé");
		columnTime.setCellValueFactory(new PropertyValueFactory<>("dateHour"));

		table.getColumns().addAll(columnId, columnAthmosphericTemperature, columnLuminosity, columnActualHumidity, columnTime);
		
//		FlowerSummary flowerSummary = new FlowerSummary();
//		flowerSummary = AppliPlanteConnectee.instance.;
		table.setItems(FXCollections.observableArrayList(AppliPlanteConnectee.instance.flowerSummaryRepository.getAll()));

	}
	
	public void flower() {
		AppliPlanteConnectee.instance.changePage("view/connectedFlowerView/List/ListView.fxml");
	}

	public void home() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}
}