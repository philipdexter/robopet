package dek;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;

public class Runner {
	
	GraphicsLCD LCD = BrickFinder.getDefault().getGraphicsLCD();
	
	State currentState = new Idle();
	
	public void go() {
		while(true) {
			currentState.run(this);
			if (0 != Button.waitForAnyPress(5000)) {
				break;
			}
		}
		LCD.drawString("bye", 100, 20, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public State getState() {
		return this.currentState;
	}
	
	
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.go();
	}

}
