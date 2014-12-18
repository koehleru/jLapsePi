package de.koehleru.jLapsePi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditEventController {

	private Stage mainStage;
	private Stage editStage;
	
	private DataModel dataModel;

	@FXML
	public void handleOKButtonAction(ActionEvent event) {
		editStage.close();
		mainStage.show();
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

	public Stage getEditStage() {
		return editStage;
	}

	public void setEditStage(Stage editStage) {
		this.editStage = editStage;
	}

}
