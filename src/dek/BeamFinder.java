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
		sensor.setCurrentMode(1);
		
		int mode = sensor.getCurrentMode();
		SensorMode sensorMode = sensor.getMode(mode);
		
		Screen.print_centered("Current mode " + sensorMode.getName() , 90, 20);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
				
		Screen.print_centered("1st " + (int)sample[0]*100 + 
				" 2nd " + (int)sample[1] *100, 100, 50);
		Screen.print_centered("3rd " + (int)sample[2]*100 + 
				" 4th " + (int)sample[3] *100, 100, 70);
		Screen.print_centered("5th " + (int)sample[4]*100 + 
				" 6th " + (int)sample[5] *100, 100, 90);
		Screen.print_centered("7th " + (int)sample[6]*100 + 
				" 8th " + (int)sample[7] *100, 100, 110);
		
		Button.waitForAnyPress();
		
	}
	
	
	public static void main(String[] args) {

		BeamFinder sample = new BeamFinder();

		//Robot will start when you press a button
			sample.finder();
		}
	
}
