package de.koehleru.jLapsePi.image;

import org.im4java.core.Info;
import org.im4java.core.InfoException;

public class ImageHandler {

	public Double getOverallBrightness(String imagePath) {
		Double result = Double.valueOf(0);
		try {
			Info info = new Info(imagePath);
			String prop = info.getProperty("Image statistics:Overall:mean");
			if (prop != null) {
				int firstIndex = prop.indexOf("(");
				int lastIndex = prop.indexOf(")");
				String strResult = prop.substring(firstIndex + 1, lastIndex);
				result = Double.valueOf(strResult);
			}
		} catch (InfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image brightness: " + result);
		return result;
	}
}
