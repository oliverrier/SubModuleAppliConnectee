/**
 * 
 */
package AppliPlanteConnectee.view.add;

import AppliPlanteConnectee.AppliPlanteConnectee;

import AppliPlanteConnectee.model.Flower;
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
		AppliPlanteConnectee.instance.FlowerRepository.addOrUpdate(new Flower(FieldName.getText()));
	}

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}

}
