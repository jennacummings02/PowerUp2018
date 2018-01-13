package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.commands.GTADrive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Left Motors
//    VictorSP frontLeft = new VictorSP(1);
    Spark Left = new Spark(2);
    //Right Motors
//    VictorSP frontRight = new VictorSP(3);
    Spark Right = new Spark(1);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GTADrive());
    }
    public void setLeft (double speed) {
    		Left.set(speed);
//    		backLeft.set(speed);
    	

    }
    public void setRight (double speed) {
    		Right.set(speed);
//    		backRight.set(speed);
    	
    }
}

