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

public class EventController implements Initializable  {

	private Stage mainStage;
	
	private DataModel dataModel;
	

	@FXML
	private void handleStartButtonAction(ActionEvent event) {
		
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
            eeController.setMainStage(mainStage);
            
            Scene scene = new Scene(pane);
			editStage.setScene(scene);
			
			mainStage.close();
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

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}
}
