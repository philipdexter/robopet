package dek;

import dek.api.Screen;
import dek.api.Wheels;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class Philip implements State {
	
	/*
	 * go forward until we find yellow
	 * 
	 * the color ids are here:
	 * http://www.lejos.org/ev3/docs/constant-values.html#lejos.robotics.Color.BLACK
	 */

	@Override
	public boolean run(Runner runner) {
		EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S4);
		Wheels.setSpeed(100);
		Wheels.go();
		while (true) {
			int id = sensor.getColorID();
			Screen.print_centered("Color " + id, 100, 20);
			
			if (id == 3) break;
		}
		Wheels.stop();
		
		sensor.close();
		
		return false;
	}

}
