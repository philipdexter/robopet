package dek.api;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Wheels {
	
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);

	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);

	static {
		leftMotor.setSpeed(400);
		rightMotor.setSpeed(400);
	}
	
	public static void setSpeed(int speed) {
		leftMotor.setSpeed(speed);
		rightMotor.setSpeed(speed);
	}
	
	public static void moveForward(int seconds) {
		leftMotor.forward();
		rightMotor.forward();
		Delay.msDelay(seconds);
		leftMotor.stop();
		rightMotor.stop();
	}

	public static void moveBackward(int seconds) {
		leftMotor.backward();
		rightMotor.backward();
		Delay.msDelay(seconds);
		leftMotor.stop();
		rightMotor.stop();
	}

	public void moveLeft(int seconds) {

	}

	public void moveRight(int seconds) {

	}
}
