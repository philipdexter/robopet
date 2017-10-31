package dek;

import dek.api.Screen;
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class Philip implements State {
	
	/*
	 * this program detects a color and
	 * then waits for a button to be pressed
	 * 
	 * the color values are here:
	 * http://www.lejos.org/ev3/docs/constant-values.html#lejos.robotics.Color.BLACK
	 */

	@Override
	public boolean run(Runner runner) {
		EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S4);
		int id = sensor.getColorID();
		Screen.print_centered("Color " + id, 100, 20);
		sensor.close();
		
		Button.waitForAnyPress();
		
		return false;
	}

}
