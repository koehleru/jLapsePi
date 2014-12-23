package de.koehleru.jLapsePi;

import java.io.IOException;

import de.koehleru.jLapsePi.camera.CameraHandler;
import de.koehleru.jLapsePi.motor.MotorHandler;
import de.koehleru.jLapsePi.timelapse.TimeLapseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JLapsePiStarter extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		initLayout(arg0);
	}
	
	private void initLayout(Stage arg0) {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JLapsePiStarter.class.getResource("views/LapseOverview.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            
            EventController controller = loader.getController();
            
            MotorHandler mHandler = new MotorHandler();
            CameraHandler cHandler = new CameraHandler();
            DataModel model = new DataModel();
            controller.setMotorHandler(new MotorHandler());
            controller.setCameraHandler(new CameraHandler());
            
            TimeLapseController tController = new TimeLapseController(model, cHandler, mHandler);
            controller.setTimeLapseController(tController);
            
            controller.setMainStage(arg0);
            controller.setDataModel(model);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            arg0.setScene(scene);
            arg0.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
