package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_DriveToCrosshairs extends Command {

	double targetX;
	double targetY;
	double targetArea;
	double targetsVisible;
   	double leftMotors;
   	double rightMotors;
   	
   	double xChange;
   	double yChange;
	
    public Auto_DriveToCrosshairs() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetX = Robot.targetX;
    	targetY = Robot.targetY;
    	targetArea = Robot.targetArea;
    	targetsVisible = Robot.targetsVisible;
    	
       	leftMotors = 0;
       	rightMotors = 0;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       	targetX = Robot.targetX;
       	targetY = Robot.targetY;
       	targetsVisible = Robot.targetsVisible;
       	
    	double error = Math.abs(targetX);
    	double kP;
    	if (error < 3.0) {
    		kP = Math.pow((0.10*error), 2)+0.2;
    	} else {
    		kP = 1;
    	}
       	
       	if (targetsVisible == 1) {
       		if (targetY < -2) {
       			//Too Close. Go Backwards
        		yChange =+ RobotMap.Drive_Scaling_Auto*(-1);
       		} else if (targetY > 2) {
       			//Too Far. Go Forwards
       			yChange =+ RobotMap.Drive_Scaling_Auto;
       		} else {
       		}
       		
       		if (targetX < -5) {
       			//Turn Right
        		rightMotors =+ 0.2*(-1);
       			
       			
       		} else if (targetX > 5) {
       			//Turn Left
       			leftMotors =+ 0.2;
       			
       		}
       	} else {
       		DriverStation.reportError("Vision Auto: No Targets Found", false);
       	}
       	
       	Robot.driveTrain.setLeft(leftMotors);
       	Robot.driveTrain.setRight(rightMotors);
       	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
