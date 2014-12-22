package de.koehleru.jLapsePi;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditEventController extends AbstractController {

	private Stage editStage;
	
	@FXML
	private Label intervalLabel;
	
	@FXML
	private Label framesLabel;
	
	
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
	
	@FXML
	public void hanldeEditFrames(ActionEvent event) {
		Stage editNumStage = new Stage();
		try {
		    FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(EventController.class.getResource("views/LapseEditNum.fxml"));
		    AnchorPane pane = (AnchorPane) loader.load();
		    EditNumEventController eneController = loader.getController();
		    eneController.setEeController(this);
		    
            Scene scene = new Scene(pane);

            editNumStage.setScene(scene);
            eneController.setEditNumStage(editNumStage);
            eneController.setEditStage(getEditStage());
            eneController.setDataModel(getDataModel());
            eneController.setMode(EditNumEventController.FRAMES);
            eneController.getNumTextField().setText("" + getDataModel().getFrames());

            getEditStage().close();
            editNumStage.show();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@FXML
	public void hanldeEditInterval(ActionEvent event) {
		Stage editNumStage = new Stage();
		try {
		    FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(EventController.class.getResource("views/LapseEditNum.fxml"));
		    AnchorPane pane = (AnchorPane) loader.load();
		    EditNumEventController eneController = loader.getController();
		    eneController.setEeController(this);
		    
            Scene scene = new Scene(pane);

            editNumStage.setScene(scene);
            eneController.setEditNumStage(editNumStage);
            eneController.setEditStage(getEditStage());
            eneController.setDataModel(getDataModel());
            eneController.setMode(EditNumEventController.INTERVAL);
            eneController.getNumTextField().setText("" + getDataModel().getInterval());

            getEditStage().close();
            editNumStage.show();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Stage getEditStage() {
		return editStage;
	}

	public void setEditStage(Stage editStage) {
		this.editStage = editStage;
	}

	public Label getIntervalLabel() {
		return intervalLabel;
	}

	public void setIntervalLabel(Label intervalLabel) {
		this.intervalLabel = intervalLabel;
	}

	public Label getFramesLabel() {
		return framesLabel;
	}

	public void setFramesLabel(Label framesLabel) {
		this.framesLabel = framesLabel;
	}

}
