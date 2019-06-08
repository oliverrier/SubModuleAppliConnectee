/**
 * 
 */
package laboCrudJavaFx.view.add;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import laboCrudJavaFx.LaboCrudJavaFx;
import laboCrudJavaFx.model.Poney;

/**
 * @author antoi
 *
 */
public class AddController {

	@FXML
	private TextField FieldName;

	public void add() {
		LaboCrudJavaFx.instance.PoneyRepository.addOrUpdate(new Poney(FieldName.getText()));
	}

	public void back() {
		LaboCrudJavaFx.instance.changePage("view/home/HomeView.fxml");
	}

}
