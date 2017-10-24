package dek.api;

import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.GraphicsLCD;

public class Screen {
	static GraphicsLCD LCD = BrickFinder.getDefault().getGraphicsLCD();
	
	public static void print_centered(String message, int x, int y) {
		LCD.drawString(message, x, y, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
	}
}
