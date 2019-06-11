/**
 * 
 */
package AppliPlanteConnectee.view.flowerSpeciesView.add;

import AppliPlanteConnectee.AppliPlanteConnectee;


import AppliPlanteConnectee.model.FlowerSpecies;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author antoi
 *
 */
public class AddController {

	@FXML
	// Text fields
	
	TextField addId = new TextField();
//	addId.setPromptText("Id");
	
	@FXML
	TextField addName = new TextField();
//	addName.setPromptText("Nom");
	
	@FXML
	TextField addDescription = new TextField();
//	addDescription.setPromptText("Description");
	
	@FXML
	TextField addTemperature = new TextField();
//	addTemperature.setPromptText("Température");
	
	@FXML
	TextField addLuminosity = new TextField();
//	addLuminosity.setPromptText("Luminosité");
	
	@FXML
	TextField addHumidity = new TextField();
//	addHumidity.setPromptText("Humidité");
	
	@FXML
	TextField addBlossomingPeriodStart = new TextField();
//	addBlossomingPeriodStart.setPromptText("Début de la période de floraison");
	
	@FXML
	TextField addBlossomingPeriodEnd = new TextField();
//	addBlossomingPeriodEnd.setPromptText("Fin de la période de floraison");
	
	@FXML
	Button addButton = new Button("Add");

	public void add() {
		AppliPlanteConnectee.instance.flowerSpeciesRepository.addOrUpdate(new FlowerSpecies(
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

	public void back() {
		AppliPlanteConnectee.instance.changePage("view/home/HomeView.fxml");
	}

}
