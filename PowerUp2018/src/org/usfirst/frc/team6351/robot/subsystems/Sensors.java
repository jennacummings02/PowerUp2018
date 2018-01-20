package org.usfirst.frc.team6351.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DriverStation;

public class Sensors extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Gyro gyro;
	public Accelerometer accel;
	public AnalogInput ultrasonic;
	
	public Sensors() {
		
		gyro = new ADXRS450_Gyro();
		accel = new BuiltInAccelerometer();
		ultrasonic = new AnalogInput(0);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getGyroAngle() {
    	return gyro.getAngle();
    }
    public double getXAccel() {
    	return accel.getX();
    }
    public double getYAccel() {
    	return accel.getY();
    }
    public double getUltrasonicDistance() {
    	// Convert the volts from the function to millivolts
    double voltstomilivolts = ultrasonic.getVoltage() * 1000;
    // Convert to mm using scaling factor 4.88mV/5mm
    double distance = (voltstomilivolts/4.88)*5;
    	return distance;
    }
}

