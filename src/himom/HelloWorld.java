package himom;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class HelloWorld
{
	GraphicsLCD LCD = BrickFinder.getDefault().getGraphicsLCD();

    static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);

static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);



void moverobotfwd(){

   

    LCD.clear();

    // Display on robot screen

    LCD.drawString("Moving Forward", 100, 20, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);

    // This code will set the speed and move the robot forward for 5 seconds

    leftMotor.setSpeed(400);

    rightMotor.setSpeed(400);

    leftMotor.forward();

    rightMotor.forward();

    Delay.msDelay(5000);

    // This code will stop the motors after 5 seconds

    leftMotor.stop();

    rightMotor.stop();



    /*while (true) {

                             leftMotor.setSpeed(400);

                             rightMotor.setSpeed(400);

             leftMotor.forward();

             rightMotor.forward();

             if (Button.readButtons() != 0) {

                 leftMotor.stop();

                 rightMotor.stop();

                 System.exit(1);

             }

                 }*/



    }

    void moverobotbkw() {             

                LCD.clear();

                // Display on robot screen

                LCD.drawString("Moving Backward", 100, 20, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);

                // This code will set the speed and move the robot backward for 5 seconds        

                leftMotor.setSpeed(400);

                rightMotor.setSpeed(400);

        leftMotor.backward();

        rightMotor.backward();

        Delay.msDelay(5000);

        // This code will stop the motors after 5 seconds

        leftMotor.stop();

        rightMotor.stop();

                           

    }

    public static void main(String[] args) {

                HelloWorld sample = new HelloWorld();

                //Robot will start when you press a button

                Button.waitForAnyPress();

                sample.moverobotfwd();

                sample.moverobotbkw();

    }
}

