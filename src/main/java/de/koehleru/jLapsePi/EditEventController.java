package de.koehleru.jLapsePi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditEventController extends AbstractController {

	private Stage editStage;
	
	@FXML
	public void handleOKButtonAction(ActionEvent event) {
		editStage.close();
		getMainStage().show();
	}
	
	@FXML
	public void handleLeftButtonAction(ActionEvent event) {
		if (getMotorHandler() != null) {
			getMotorHandler().moveStepLeft();
		}
	}

	@FXML
	public void handleRightButtonAction(ActionEvent event) {
		if (getMotorHandler() != null) {
			getMotorHandler().moveStepRight();
		}
	}
	
	public Stage getEditStage() {
		return editStage;
	}

	public void setEditStage(Stage editStage) {
		this.editStage = editStage;
	}

}
