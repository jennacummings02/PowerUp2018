package org.usfirst.frc.team6351.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UpperArm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Spark motor = new Spark(5);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setMotorSpeed(double speed) {
    	motor.set(speed);
    }
}

