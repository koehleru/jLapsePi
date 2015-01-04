package de.koehleru.jLapsePi.camera;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraHandler {

	public CameraHandler() {

		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo 252 > /sys/class/gpio/export\"").waitFor();
			Runtime.getRuntime().exec("sudo sh -c \"echo 'out' > /sys/class/gpio/gpio252/direction\"").waitFor();
			Runtime.getRuntime().exec("/usr/local/bin/gphoto2 --auto-detect").waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void capture(Integer nr, Integer all) {
		switchBacklightOff();
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		String filename = "--filename=/mnt/usbstick/timelapse_" + df.format(date) + "_" + nr + "of" + all + ".jpg";
		try {
			Runtime.getRuntime().exec("/usr/local/bin/gphoto2 --capture-image-and-download " + filename).waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		switchBacklightOn();
	}
	
	
	private void switchBacklightOn() {
		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo '1' > /sys/class/gpio/gpio252/value\"").waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void switchBacklightOff() {
		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo '0' > /sys/class/gpio/gpio252/value\"").waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
