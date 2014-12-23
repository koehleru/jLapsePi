package de.koehleru.jLapsePi;

import javafx.scene.Scene;
import javafx.stage.Stage;
import de.koehleru.jLapsePi.camera.CameraHandler;
import de.koehleru.jLapsePi.motor.MotorHandler;
import de.koehleru.jLapsePi.timelapse.TimeLapseController;

public class AbstractController {

	private Stage mainStage;
	
	private Scene mainScene;
	
	private DataModel dataModel;

	private MotorHandler motorHandler;
	
	private CameraHandler cameraHandler;
	
	private TimeLapseController timeLapseController;

	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
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

	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	public TimeLapseController getTimeLapseController() {
		return timeLapseController;
	}

	public void setTimeLapseController(TimeLapseController timeLapseController) {
		this.timeLapseController = timeLapseController;
	}
	
}
