package de.koehleru.jLapsePi;

import de.koehleru.jLapsePi.camera.CameraHandler;
import de.koehleru.jLapsePi.motor.MotorHandler;
import javafx.stage.Stage;

public class AbstractController {

	private Stage mainStage;
	
	private DataModel dataModel;

	private MotorHandler motorHandler;
	
	private CameraHandler cameraHandler;

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

	public CameraHandler getCameraHandler() {
		return cameraHandler;
	}

	public void setCameraHandler(CameraHandler cameraHandler) {
		this.cameraHandler = cameraHandler;
	}
	
}
