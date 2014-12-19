package de.koehleru.jLapsePi.motor;

import com.pi4j.component.motor.impl.GpioStepperMotorComponent;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class MotorHandler {

	private GpioController gpioController = GpioFactory.getInstance();
	private GpioStepperMotorComponent motor;
	private byte[] single_step_sequence = new byte[4];
	
	public MotorHandler() {
		GpioPinDigitalOutput[] pins = {gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.LOW),
									   gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.LOW),
									   gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.LOW),
									   gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.LOW)};
		
		gpioController.setShutdownOptions(true, PinState.LOW, pins);
		motor = new GpioStepperMotorComponent(pins);
		
		single_step_sequence[0] = (byte) 0b0001;  
		single_step_sequence[1] = (byte) 0b0010;
		single_step_sequence[2] = (byte) 0b0100;
		single_step_sequence[3] = (byte) 0b1000;

		motor.setStepInterval(2);  
        motor.setStepSequence(single_step_sequence);
	}
	
	
	public void moveStepLeft() {
		motor.step(2);
	}
	
	public void moveStepRight() {
		motor.step(-2);
	}
	
}
