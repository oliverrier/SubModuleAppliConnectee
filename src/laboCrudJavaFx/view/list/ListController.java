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
	private TableView<Poney> table;

	public void initialize() {
		table.getColumns().clear();

		TableColumn<Poney, Integer> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<Poney, String> columnName = new TableColumn<>("Nom");
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Poney, String> columnWeapon = new TableColumn<>("Arme");
		columnWeapon.setCellValueFactory(new PropertyValueFactory<>("weapon"));

		table.getColumns().addAll(columnId, columnName, columnWeapon);

		table.setItems(FXCollections.observableArrayList(LaboCrudJavaFx.instance.PoneyRepository.getAll()));

	}

	public void back() {
		LaboCrudJavaFx.instance.changePage("view/home/HomeView.fxml");
	}
}