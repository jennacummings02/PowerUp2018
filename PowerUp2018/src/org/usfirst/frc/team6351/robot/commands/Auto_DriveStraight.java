package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_DriveStraight extends Command {
	
	double spd, tme;
	
    public Auto_DriveStraight(double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	spd = speed;
    	tme = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setLeft(spd);
    	Robot.driveTrain.setRight((spd)*RobotMap.Curve_Reduction_Factor*(-1));
    	Timer.delay(tme);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
