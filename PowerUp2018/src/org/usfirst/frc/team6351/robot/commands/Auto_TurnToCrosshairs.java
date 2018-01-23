package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_TurnToCrosshairs extends Command {

	double targetX;
	double targetsVisible;
	
    public Auto_TurnToCrosshairs() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetX = Robot.targetX;
    	targetsVisible = Robot.targetsVisible;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       	targetX = Robot.targetX;
       	targetsVisible = Robot.targetsVisible;
       	
       	if (targetsVisible == 1) {
    	double error = Math.abs(targetX);
    	double kP;
    	if (error < 10.0) {
    		kP = Math.pow((0.10*error), 2)+0.2;
    	} else {
    		kP = 1;
    	}
    	if (targetX < -3){
    		Robot.driveTrain.setLeft(RobotMap.Drive_Scaling_Auto*(-1)*kP);
    		Robot.driveTrain.setRight(RobotMap.Drive_Scaling_Auto*(-1)*kP);
    	} else if (targetX > 3) {
    		Robot.driveTrain.setLeft(RobotMap.Drive_Scaling_Auto*kP);
    		Robot.driveTrain.setRight(RobotMap.Drive_Scaling_Auto*kP);
    	}
       	} else {
       		DriverStation.reportError("Vision Auto: No Targets Found", false);
       	}
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
