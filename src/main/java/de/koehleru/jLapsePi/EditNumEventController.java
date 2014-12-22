package de.koehleru.jLapsePi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditNumEventController extends EditEventController {

	public static Integer FRAMES = 0;
	public static Integer INTERVAL = 1;
	
	private Integer mode;
	
	private Stage editNumStage;
	
	@FXML
	private TextField numTextField;
	
	@FXML
	public void handleOKButtonAction(ActionEvent event) {
		Integer result = Integer.parseInt(numTextField.getText());
		if (mode.equals(FRAMES)) {
			getDataModel().setFrames(result);
		}
		if (mode.equals(INTERVAL)) {
			getDataModel().setInterval(result);
		}		
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
		numTextField.setText(numTextField.getText() + "0");
	}
	
	@FXML
	public void handle1ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "1");
	}
	
	@FXML
	public void handle2ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "2");
	}
	
	@FXML
	public void handle3ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "3");
	}
	
	@FXML
	public void handle4ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "4");
	}
	
	@FXML
	public void handle5ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "5");
	}	
	
	@FXML
	public void handle6ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "6");
	}
	
	@FXML
	public void handle7ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "7");
	}
	
	@FXML
	public void handle8ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "8");	
	}
	
	@FXML
	public void handle9ButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText() + "9");
	}

	@FXML
	public void handleBackButtonAction(ActionEvent event) {
		numTextField.setText(numTextField.getText().substring(0, numTextField.getText().length() -1));
	}
	
	public Integer getMode() {
		return mode;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public TextField getNumTextField() {
		return numTextField;
	}

	public void setNumTextField(TextField numTextField) {
		this.numTextField = numTextField;
	}		
}
