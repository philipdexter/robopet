package dek;
import dek.api.Screen;
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;



public class BeamFinder {
	
	SensorMode retValueIR;
	int sampleSize;
	
	public void finder() {
		
		while(true) {
		EV3IRSensor sensor = new EV3IRSensor(SensorPort.S3);
		
		retValueIR=sensor.getSeekMode();
		
		sampleSize= retValueIR.sampleSize();
		
		float[] sample= new float[sampleSize];
		
		followTheBeacon(sample);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
	
	void followTheBeacon(float[] sample) {
		
		
		retValueIR.fetchSample(sample, 0);
				
		Screen.print_centered("Ist " + (int)sample[0]*100 + " 2nd" + (int)sample[1] *100, 100, 20);
		
		Button.waitForAnyPress();
		
	}
	
	
	public static void main(String[] args) {

		BeamFinder sample = new BeamFinder();

		//Robot will start when you press a button
			sample.finder();
		}
	
}
