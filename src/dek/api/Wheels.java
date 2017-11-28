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
	
	public static void go() {
		leftMotor.forward();
		rightMotor.forward();
	}
	
	public static void stop() {
		leftMotor.stop();
		rightMotor.stop();
	}
	
	public static void moveForwardms(int ms) {
		leftMotor.forward();
		rightMotor.forward();
		Delay.msDelay((long)ms);
		leftMotor.stop();
		rightMotor.stop();
	}
	
	public static void moveForward(double seconds) {
		leftMotor.forward();
		rightMotor.forward();
		Delay.msDelay((long)seconds*1000);
		leftMotor.stop();
		rightMotor.stop();
	}

	public static void moveBackward(double seconds) {
		leftMotor.backward();
		rightMotor.backward();
		Delay.msDelay((long)seconds*1000);
		leftMotor.stop();
		rightMotor.stop();
	}

	public static void turnLeft(double seconds) {
		rightMotor.forward();
		Delay.msDelay((long)seconds*1000);
		rightMotor.stop();
	}
	
	public static void turnRight(double seconds) {
		leftMotor.forward();
		Delay.msDelay((long)seconds*1000);
		leftMotor.stop();
	}
	
	public static void moveLeft(int seconds) {

	}

	public static void moveRight(int seconds) {

	}
	
	public static void moveBackLeft(double seconds) {
		rightMotor.backward();
		Delay.msDelay((long)seconds*1000);
		leftMotor.stop();
	}
	
	public static void moveBackRight(double seconds) {
		leftMotor.backward();
		Delay.msDelay((long)seconds*1000);
		rightMotor.stop();
	}
}
