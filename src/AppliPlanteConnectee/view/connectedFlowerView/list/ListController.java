package AppliPlanteConnectee.view.connectedFlowerView.list;

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


		table.getColumns().addAll(columnId, columnName);

		table.setItems(FXCollections.observableArrayList(AppliPlanteConnectee.instance.connectedFlowerRepository.getAll()));

	}

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}
}