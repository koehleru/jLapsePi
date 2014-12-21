package de.koehleru.jLapsePi.camera;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraHandler {

	public CameraHandler() {
		try {
			Runtime.getRuntime().exec("/usr/local/bin/gphoto2 --auto-detect").waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gphotoCamera = new Camera();
		//gphotoCamera.initialize();
	}
	
	public void capture(Integer nr, Integer all) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String filename = "--filename=/mnt/usbstick/timelapse_" + df.format(date) + "_" + nr + "of" + all + ".jpg";
		try {
			Runtime.getRuntime().exec("/usr/local/bin/gphoto2 --capture-image-and-download " + filename).waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//if (!gphotoCamera.isInitialized()) {
		//	gphotoCamera.initialize();
		//}
		//CameraFile file = gphotoCamera.captureImage();
		//file.save("/mnt/usb-stick/xxx.jpg");
	}
}
