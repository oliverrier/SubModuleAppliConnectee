/**
 * 
 */
package AppliPlanteConnectee.view.flowerSummaryView.add;

import AppliPlanteConnectee.AppliPlanteConnectee;

import AppliPlanteConnectee.model.ConnectedFlower;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @author antoi
 *
 */
public class AddController {

	@FXML
	private TextField FieldName;

	public void add() {
		AppliPlanteConnectee.instance.connectedFlowerRepository.addOrUpdate(new ConnectedFlower(FieldName.getText()));
	}

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}

}
