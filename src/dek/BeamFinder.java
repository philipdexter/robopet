package dek;
import dek.api.Screen;
import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;



public class BeamFinder {
	
	SensorMode retValueIR;
	int sampleSize;
	RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	
	public void finder() {
		EV3IRSensor sensor = new EV3IRSensor(SensorPort.S3);
		sensor.setCurrentMode(1);
		
		int mode = sensor.getCurrentMode();
		SensorMode sensorMode = sensor.getMode(mode);
		
		Screen.print_centered("Current mode " + sensorMode.getName() , 90, 20);
		
		while(true) {
		retValueIR=sensor.getSeekMode();
		
		sampleSize= retValueIR.sampleSize();
		float[] sample= new float[sampleSize];
		
		followTheBeacon(sample);
		
		if (0 != Button.getButtons()) {
			leftMotor.stop();
			rightMotor.stop();
			break;
		}
		}
	}
	
	
	void followTheBeacon(float[] sample) {
		
		retValueIR.fetchSample(sample, 0);
		
		float angle = sample[0];
		float dist = sample[1];
				
		Screen.print_centered("Angle " + angle, 100, 50);
		Screen.print_centered("Distance " + dist, 100, 70);
		
		if (dist > 70) {
			leftMotor.stop();
			rightMotor.stop();
		} else if (dist >= 5) {	
			
			int speed = setSpeed(dist);
			
			if (angle > 2) {
				leftMotor.setSpeed(speed);
				rightMotor.setSpeed(speed/2);
			} else if (angle < -2) {
				leftMotor.setSpeed(speed/2);
				rightMotor.setSpeed(speed);
			} else {
				leftMotor.setSpeed(speed);
				rightMotor.setSpeed(speed);
			}
			leftMotor.forward();
			rightMotor.forward();
			
		} else if (dist >= 3) {
			leftMotor.stop();
			rightMotor.stop();
		}
		else if (dist >= 1){
			
			leftMotor.setSpeed(200);
			rightMotor.setSpeed(200);
			
			if (angle > 2) {
				leftMotor.stop();
				rightMotor.backward();
			} else if (angle < -2) {
				leftMotor.backward();
				rightMotor.stop();
			} else {
				leftMotor.backward();
				rightMotor.backward();
				}
		} else {
			leftMotor.stop();
			rightMotor.stop();
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Screen.clear();
		
	}
	
	int setSpeed(float dist) {
		return (int) ((dist - 5)* 540/ 65 + 200);
	}
	
	
	public static void main(String[] args) {

		BeamFinder sample = new BeamFinder();

		//Robot will start when you press a button
			sample.finder();
		}
	
}
