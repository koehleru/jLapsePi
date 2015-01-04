package de.koehleru.jLapsePi.timelapse;

import de.koehleru.jLapsePi.DataModel;
import de.koehleru.jLapsePi.EventController;
import de.koehleru.jLapsePi.camera.CameraHandler;
import de.koehleru.jLapsePi.motor.MotorHandler;

public class TimeLapseController implements Runnable {

	private DataModel model;
	private boolean stop = false;
	private CameraHandler cameraHandler;
	private MotorHandler motorHandler;
	private EventController eventController;
	
	public TimeLapseController(DataModel model, CameraHandler cHandler, MotorHandler mHandler, EventController eController) {
		this.model = model;
		cameraHandler = cHandler;
		motorHandler = mHandler;
		eventController = eController;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < model.getFrames(); i++) {
			if (stop) {
				return;
			}
			model.setCurrentFrame(i);
			long startTime = System.currentTimeMillis();
			cameraHandler.capture(i, model.getFrames());
			motorHandler.moveStepRight();
			long diffTime = System.currentTimeMillis() - startTime;
			
			if (diffTime < model.getInterval()) {
				try {
					Thread.sleep(model.getInterval() - diffTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			Integer remainingTime = model.getFrames() * model.getInterval();
			eventController.getRemainLabel().setText(remainingTime/1000 + "s");
		}
	}

	public void stop() {
		stop = true;
	}
	
	public void reset() {
		stop = false;
	}
}
