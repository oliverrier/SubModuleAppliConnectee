package AppliPlanteConnectee.view.home;

import AppliPlanteConnectee.AppliPlanteConnectee;

public class HomeController {

	public void initialize() {
	}

	public void GoToList() {
		AppliPlanteConnectee.instance.changePage("view/list/ListView.fxml");
	}

	public void GoToAdd() {
		AppliPlanteConnectee.instance.changePage("view/add/AddView.fxml");
	}
}