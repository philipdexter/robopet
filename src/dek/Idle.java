package dek;

import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.GraphicsLCD;

public class Idle implements State {
	GraphicsLCD LCD = BrickFinder.getDefault().getGraphicsLCD();
	
	public void run(Runner runner) {
		LCD.drawString("Current state is Idle", 100, 20, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
	}
}
