package dek.api;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Claws {
	static RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
	
	static {
		motor.setSpeed(100);
	}
	
	public static void open(int seconds) {
		motor.backward();
		Delay.msDelay(seconds*1000);
		motor.stop();
	}
	
	public static void close(int seconds) {
		motor.forward();
		Delay.msDelay(seconds*1000);
		motor.stop();
	}
}
