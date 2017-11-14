package dek;

import dek.api.Screen;
import dek.api.Wheels;
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class ColorFinder implements State {
	
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
		int last_color = 0;
		while (true) {
			int id = sensor.getColorID();
			if (last_color != id) {
				Screen.clear();
				Screen.print_centered("Color " + id, 100, 20);
			}
			last_color = id;
			if (id == Color.WHITE) {
				Wheels.go();
			} else {
				Wheels.stop();
			}
			if (0 != Button.getButtons()) {
				break;
			}
		}
		Wheels.stop();
		
		sensor.close();
		
		return false;
	}
	
	public static void main(String[] args) {
		ColorFinder cf = new ColorFinder();
		cf.run(null);
	}

}
