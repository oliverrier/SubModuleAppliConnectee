/**
 * 
 */
package AppliPlanteConnectee.view.flowerSpeciesView.add;

import AppliPlanteConnectee.AppliPlanteConnectee;


import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.model.FlowerSpecies;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * @author antoi
 *
 */
public class AddController {

	@FXML
	// Text fields
	
	TextField addId = new TextField();
//	addId.setPromptText("Id");

	TextField addName = new TextField();
//	addName.setPromptText("Nom");

	TextField addDescription = new TextField();
//	addDescription.setPromptText("Description");

	TextField addTemperature = new TextField();
//	addTemperature.setPromptText("Température");

	TextField addLuminosity = new TextField();
//	addLuminosity.setPromptText("Luminosité");

	TextField addHumidity = new TextField();
//	addHumidity.setPromptText("Humidité");

	TextField addBlossomingPeriodStart = new TextField();
//	addBlossomingPeriodStart.setPromptText("Début de la période de floraison");

	TextField addBlossomingPeriodEnd = new TextField();
//	addBlossomingPeriodEnd.setPromptText("Fin de la période de floraison");
	
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
