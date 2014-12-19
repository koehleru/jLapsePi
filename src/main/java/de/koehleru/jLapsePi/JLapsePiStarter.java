package de.koehleru.jLapsePi;

import java.io.IOException;

import de.koehleru.jLapsePi.motor.MotorHandler;
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
            //controller.setMotorHandler(new MotorHandler());
            controller.setMainStage(arg0);
            controller.setDataModel(new DataModel());
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            arg0.setScene(scene);
            arg0.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
