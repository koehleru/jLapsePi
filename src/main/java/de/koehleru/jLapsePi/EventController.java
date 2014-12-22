package de.koehleru.jLapsePi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EventController extends AbstractController implements Initializable  {

	@FXML
	private void handleStartButtonAction(ActionEvent event) {
		getCameraHandler().capture(1,1);
	}
	
	@FXML
	private void handleStopButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	private void handleEditButtonAction(ActionEvent event) {
		Stage editStage = new Stage();
		try {
			
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EventController.class.getResource("views/LapseEdit.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            EditEventController eeController = loader.getController();
            eeController.setDataModel(getDataModel());
            eeController.setEditStage(editStage);
            eeController.setMainStage(getMainStage());
            eeController.setMotorHandler(getMotorHandler());
            eeController.setCameraHandler(getCameraHandler());
            eeController.getFramesLabel().setText(getDataModel().getFrames() + "");
            eeController.getIntervalLabel().setText(getDataModel().getInterval() + "");
            
            Scene scene = new Scene(pane);
			editStage.setScene(scene);
			
			getMainStage().close();
			editStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleExitButtonAction(ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
