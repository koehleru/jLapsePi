package de.koehleru.jLapsePi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditNumEventController extends EditEventController {

	private Stage editNumStage;
	
	@FXML
	public void handleOKButtonAction(ActionEvent event) {
		getEditNumStage().close();
		getEditStage().show();
	}

	public Stage getEditNumStage() {
		return editNumStage;
	}

	public void setEditNumStage(Stage editNumStage) {
		this.editNumStage = editNumStage;
	}

	@FXML
	public void handle0ButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	public void handle1ButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	public void handle2ButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	public void handle3ButtonAction(ActionEvent event) {
		
	}
	@FXML
	public void handle4ButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	public void handle5ButtonAction(ActionEvent event) {
		
	}	
	
	@FXML
	public void handle6ButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	public void handle7ButtonAction(ActionEvent event) {
		
	}
	@FXML
	public void handle8ButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	public void handle9ButtonAction(ActionEvent event) {
		
	}		
}
