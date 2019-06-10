package AppliPlanteConnectee.view.home;

import AppliPlanteConnectee.AppliPlanteConnectee;

public class HomeController {

	public void initialize() {
	}

	public void goToList() {
		AppliPlanteConnectee.instance.changePage("view/connectedFlowerView/list/ListView.fxml");
	}

	public void goToFlowerSpeciesList() {
		AppliPlanteConnectee.instance.changePage("view/flowerSpeciesView/list/ListView.fxml");
	}
}