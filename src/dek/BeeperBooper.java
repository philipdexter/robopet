package dek;

import dek.api.Wheels;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;

public class BeeperBooper implements State {
	@Override
	public boolean run(Runner runner) {
		EV3TouchSensor sensor = new EV3TouchSensor(SensorPort.S2);
		
		Wheels.setSpeed(100);
		Wheels.go();
		
		sensor.getTouchMode();
		SensorMode touch = sensor.getTouchMode();
		float[] sample = new float[touch.sampleSize()];
		
		while (sample[0] == 0) {
			touch.fetchSample(sample, 0);
		}
		
		Sound.beepSequenceUp();
		Wheels.setSpeed(300);
		Wheels.moveBackward(2);
		
		sensor.close();
		
		return false;
	}

	public static void main(String[] args) {
		BeeperBooper beepboop = new BeeperBooper();
		beepboop.run(null);
	}
}
