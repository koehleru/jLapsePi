package de.koehleru.jLapsePi.camera;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

public class CameraHandler {

	private GpioController gpio = GpioFactory.getInstance();
	private GpioPinPwmOutput pwmPin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01);
	
	public CameraHandler() {

		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo 'in' > /sys/class/gpio/gpio252/direction\"").waitFor();
			Runtime.getRuntime().exec("/usr/local/bin/gphoto2 --auto-detect").waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gphotoCamera = new Camera();
		//gphotoCamera.initialize();
	}
	
	public void capture(Integer nr, Integer all) {
		switchBacklightOff();
		
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
		
		switchBacklightOn();
	}
	
	
	private void switchBacklightOn() {
		pwmPin.setPwm(99);
	}
	
	private void switchBacklightOff() {
		pwmPin.setPwm(10);
	}
}
