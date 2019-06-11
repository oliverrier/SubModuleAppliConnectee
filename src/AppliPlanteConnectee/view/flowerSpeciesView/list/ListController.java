package AppliPlanteConnectee.view.flowerSpeciesView.list;

import AppliPlanteConnectee.model.FlowerSpecies;

import AppliPlanteConnectee.AppliPlanteConnectee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

	@FXML
	private TableView<FlowerSpecies> table;

	@SuppressWarnings("unchecked")
	public void initialize() {
		table.getColumns().clear();
		
		// Table Columns

		TableColumn<FlowerSpecies, Integer> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<FlowerSpecies, String> columnName = new TableColumn<>("Nom");
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<FlowerSpecies, String> columnDescription = new TableColumn<>("Description");
		columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

		TableColumn<FlowerSpecies, Integer> columnTemperature = new TableColumn<>("Temperature Idéale");
		columnTemperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
		
		TableColumn<FlowerSpecies, Integer> columnLuminosity = new TableColumn<>("Luminositée Idéale");
		columnLuminosity.setCellValueFactory(new PropertyValueFactory<>("luminosity"));

		TableColumn<FlowerSpecies, Boolean> columnHumidity = new TableColumn<>("Humidité Idéale");
		columnHumidity.setCellValueFactory(new PropertyValueFactory<>("humidity"));
		
		TableColumn<FlowerSpecies, String> columnBlossomingPeriodStart = new TableColumn<>("Début de la période de floraison");
		columnBlossomingPeriodStart.setCellValueFactory(new PropertyValueFactory<>("blossomingPeriodStart"));
		
		TableColumn<FlowerSpecies, String> columnBlossomingPeriodEnd = new TableColumn<>("Fin de la période de floraison");
		columnBlossomingPeriodEnd.setCellValueFactory(new PropertyValueFactory<>("blossomingPeriodEnd"));
		
		table.getColumns().addAll(columnId, columnName, columnDescription, columnTemperature, columnLuminosity, columnHumidity, columnBlossomingPeriodStart, columnBlossomingPeriodEnd);

		
		table.setItems(FXCollections.observableArrayList(AppliPlanteConnectee.instance.flowerSpeciesRepository.getAll()));

	}
	
	public void add() {
		AppliPlanteConnectee.instance.changePage("view/flowerSpeciesView/add/AddView.fxml");
	}

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}
}