package de.koehleru.jLapsePi;

import de.koehleru.jLapsePi.motor.MotorHandler;
import javafx.stage.Stage;

public class AbstractController {

	private Stage mainStage;
	
	private DataModel dataModel;

	private MotorHandler motorHandler;

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

	public MotorHandler getMotorHandler() {
		return motorHandler;
	}

	public void setMotorHandler(MotorHandler motorHandler) {
		this.motorHandler = motorHandler;
	}
	
}
