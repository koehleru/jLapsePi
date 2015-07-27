package de.koehleru.jLapsePi.image;

import org.junit.Assert;
import org.junit.Test;

public class ImageHandlerTest {

	private ImageHandler handler = new ImageHandler();
	
	@Test
	public void testgetOverallBrightness() {
		Double result = handler.getOverallBrightness("C:\\private\\develop\\workspace\\jLapsePi\\src\\test\\resources\\test.jpg");
		Assert.assertEquals(Double.valueOf(0.506526), result);
	}
}
