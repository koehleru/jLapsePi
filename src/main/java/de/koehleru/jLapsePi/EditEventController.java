package de.koehleru.jLapsePi;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class EditEventController extends AbstractController {

	private Scene editScene;
	
	@FXML
	private Label intervalLabel;
	
	@FXML
	private Label framesLabel;
	
	
	@FXML
	public void handleOKButtonAction(ActionEvent event) {
		getMainStage().setScene(getMainScene());
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
		try {
		    FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(EventController.class.getResource("views/LapseEditNum.fxml"));
		    AnchorPane pane = (AnchorPane) loader.load();
		    EditNumEventController eneController = loader.getController();
		    eneController.setEeController(this);
		    
            Scene editNumScene = new Scene(pane);

            eneController.setEditNumScene(editNumScene);
            eneController.setEditScene(getMainStage().getScene());
            eneController.setMainStage(getMainStage());
            eneController.setDataModel(getDataModel());
            eneController.setMode(EditNumEventController.FRAMES);
            eneController.getNumTextField().setText("" + getDataModel().getFrames());
            
            getMainStage().setScene(editNumScene);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@FXML
	public void hanldeEditInterval(ActionEvent event) {
		try {
		    FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(EventController.class.getResource("views/LapseEditNum.fxml"));
		    AnchorPane pane = (AnchorPane) loader.load();
		    EditNumEventController eneController = loader.getController();
		    eneController.setEeController(this);
		    
            Scene editNumScene = new Scene(pane);

            eneController.setEditNumScene(editNumScene);
            eneController.setEditScene(getMainStage().getScene());
            eneController.setMainStage(getMainStage());
            eneController.setDataModel(getDataModel());
            eneController.setMode(EditNumEventController.INTERVAL);
            eneController.getNumTextField().setText("" + getDataModel().getInterval());

            getMainStage().setScene(editNumScene);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Scene getEditScene() {
		return editScene;
	}

	public void setEditScene(Scene editScene) {
		this.editScene = editScene;
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
