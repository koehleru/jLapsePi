package de.koehleru.jLapsePi.camera;

import org.gphoto2.Camera;
import org.gphoto2.CameraFile;

public class CameraHandler {

	private Camera gphotoCamera; 
	
	public CameraHandler() {
		gphotoCamera = new Camera();
	}
	
	public void capture() {
		CameraFile file = gphotoCamera.captureImage();
		file.save("/mnt/usb-stick/xxx.jpg");
	}
}
