package AppliPlanteConnectee.view.flowerSpeciesView.list;

import AppliPlanteConnectee.model.FlowerSpecies;

import java.util.List;

import AppliPlanteConnectee.AppliPlanteConnectee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.NumberStringConverter;

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
		
		// Text fields
		
		final TextField addId = new TextField();
		addId.setPromptText("Id");
		addId.setMaxWidth(columnId.getPrefWidth());
		
		final TextField addName = new TextField();
		addName.setPromptText("Nom");
		addName.setMaxWidth(columnName.getPrefWidth());
		
		final TextField addDescription = new TextField();
		addDescription.setPromptText("Description");
		addDescription.setMaxWidth(columnDescription.getPrefWidth());

		final TextField addTemperature = new TextField();
		addTemperature.setPromptText("Température");
		addTemperature.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
		addTemperature.setMaxWidth(columnTemperature.getPrefWidth());

		final TextField addLuminosity = new TextField();
		addLuminosity.setPromptText("Luminosité");
		addLuminosity.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
		addLuminosity.setMaxWidth(columnLuminosity.getPrefWidth());
		
		final TextField addHumidity = new TextField();
		addHumidity.setPromptText("Humidité");
		addHumidity.setTextFormatter(new TextFormatter<>(new BooleanStringConverter()));
		addHumidity.setMaxWidth(columnHumidity.getPrefWidth());
		
		final TextField addBlossomingPeriodStart = new TextField();
		addBlossomingPeriodStart.setPromptText("Début de la période de floraison");
		addBlossomingPeriodStart.setMaxWidth(columnBlossomingPeriodStart.getPrefWidth());
		
		final TextField addBlossomingPeriodEnd = new TextField();
		addBlossomingPeriodEnd.setPromptText("Fin de la période de floraison");
		addBlossomingPeriodEnd.setMaxWidth(columnBlossomingPeriodEnd.getPrefWidth());
		
		final Button addButton = new Button("Add");
		
		addButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		        table.getItems().add(new FlowerSpecies(
		        	Integer.parseInt(addId.getText()),
		            addName.getText(),
		            addDescription.getText(),
		            Integer.parseInt(addTemperature.getText()),
		            Integer.parseInt(addLuminosity.getText()),
		            Boolean.parseBoolean(addHumidity.getText()),
		            addBlossomingPeriodStart.getText(),
		            addBlossomingPeriodEnd.getText(),
		            1
		        ));
		        addId.clear();
		        addName.clear();
		        addDescription.clear();
		        addTemperature.clear();
		        addLuminosity.clear();
		        addHumidity.clear();
		        addBlossomingPeriodStart.clear();
		        addBlossomingPeriodEnd.clear();
		    }
		});
		
		

		
		table.setItems(FXCollections.observableArrayList(AppliPlanteConnectee.instance.flowerSpeciesRepository.getAll()));

	}
	
	

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}
}