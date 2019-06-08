package laboCrudJavaFx.view.home;

import laboCrudJavaFx.LaboCrudJavaFx;

public class HomeController {

	public void initialize() {
	}

	public void GoToList() {
		LaboCrudJavaFx.instance.changePage("view/list/ListView.fxml");
	}

	public void GoToAdd() {
		LaboCrudJavaFx.instance.changePage("view/add/AddView.fxml");
	}
}