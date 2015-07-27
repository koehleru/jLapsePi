package de.koehleru.jLapsePi.camera;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gphoto2.Camera;
import org.gphoto2.CameraFile;
import org.gphoto2.CameraWidgets;

import de.koehleru.jLapsePi.image.ImageHandler;

public class CameraHandler {

	private Camera gphotoCamera; 
	private CameraWidgets widgets;
	private ImageHandler imageHandler;
	private List<CameraConfig> configList;
	private int currentIndex = 7;

	public CameraHandler() {
		init();
		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo 508 > /sys/class/gpio/export\"").waitFor();
			Runtime.getRuntime().exec("sudo sh -c \"echo 'out' > /sys/class/gpio/gpio508/direction\"").waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		imageHandler = new ImageHandler();
		gphotoCamera = new Camera();
		gphotoCamera.initialize();
		widgets = gphotoCamera.newConfiguration();
		
	}
	
	public void capture(Integer nr, Integer all) {
		switchBacklightOff();
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		
		widgets.setValue("/imgsettings/iso", configList.get(currentIndex).iso.toString());
		widgets.setValue("/capturesettings/shutterspeed", configList.get(currentIndex).shutter.toString());
		widgets.apply();
		
		CameraFile file = gphotoCamera.captureImage();
		String fileName = "/mnt/usbstick/timelapse_" + df.format(date) + "_" + nr + "of" + all + ".jpg"; 
		file.save(fileName);
		
		Double brightness = imageHandler.getOverallBrightness(fileName);
		if (brightness > 0.5) {
			if (currentIndex > 0) {
				currentIndex = currentIndex - 1;
			}
		} else {
			if (currentIndex < configList.size()) {
				currentIndex = currentIndex + 1;
			}
		}
		switchBacklightOn();
	}
	
	
	private void switchBacklightOn() {
		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo '1' > /sys/class/gpio/gpio508/value\"").waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void switchBacklightOff() {
		try {
			Runtime.getRuntime().exec("sudo sh -c \"echo '0' > /sys/class/gpio/gpio508/value\"").waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		configList = new ArrayList<CameraHandler.CameraConfig>();
		for (int i = 0; i < 53; i++) {
			configList.add(new CameraConfig(i, 2));
		}
		configList.add(new CameraConfig(53, 3));
		configList.add(new CameraConfig(53, 4));
		configList.add(new CameraConfig(53, 5));
		configList.add(new CameraConfig(53, 6));
		configList.add(new CameraConfig(53, 7));
		configList.add(new CameraConfig(53, 8));
		configList.add(new CameraConfig(53, 9));
		configList.add(new CameraConfig(53, 10));
		configList.add(new CameraConfig(53, 11));
		configList.add(new CameraConfig(53, 12));
		configList.add(new CameraConfig(53, 13));
		configList.add(new CameraConfig(53, 14));
		configList.add(new CameraConfig(53, 15));
		configList.add(new CameraConfig(53, 16));
		configList.add(new CameraConfig(53, 17));
		configList.add(new CameraConfig(53, 18));
		configList.add(new CameraConfig(53, 19));
		configList.add(new CameraConfig(53, 20));
		configList.add(new CameraConfig(53, 21));
		configList.add(new CameraConfig(53, 22));
	}
	
	private class CameraConfig {
		Integer shutter;
		Integer iso;
		CameraConfig(Integer shutter, Integer iso) {
			this.iso = iso;
			this.shutter = shutter;
		}
	}
}
