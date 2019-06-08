package laboCrudJavaFx.view.list;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import laboCrudJavaFx.LaboCrudJavaFx;
import laboCrudJavaFx.model.Poney;

public class ListController {

	@FXML
	private TableView<Flower> table;

	public void initialize() {
		table.getColumns().clear();

		TableColumn<Flower, Integer> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<Flower, String> columnName = new TableColumn<>("Nom");
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Flower, Integer> columnActualTemperature = new TableColumn<>("Temperature Actuelle");
		columnId.setCellValueFactory(new PropertyValueFactory<>("actualTemperature"));
		
		TableColumn<Flower, Integer> columnActualLuminosity = new TableColumn<>("Luminositée Actuelle");
		columnId.setCellValueFactory(new PropertyValueFactory<>("actualLuminosity"));

		TableColumn<Flower, Boolean> columnActualHumidity = new TableColumn<>("Humidité Actuelle");
		columnId.setCellValueFactory(new PropertyValueFactory<>("actualHumidity"));
		
		TableColumn<Flower, Date> columnTime = new TableColumn<>("Date du dernier relevé");
		columnId.setCellValueFactory(new PropertyValueFactory<>("time"));

		table.getColumns().addAll(columnId, columnName, columnActualTemperature, columnActualLuminosity, columnActualHumidity, columnTime);

		table.setItems(FXCollections.observableArrayList(LaboCrudJavaFx.instance.FlowerRepository.getAll()));

	}

	public void back() {
		LaboCrudJavaFx.instance.changePage("view/home/HomeView.fxml");
	}
}