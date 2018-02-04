package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EndGame_Climb extends Command {
	
	double tme;
	
	public EndGame_Climb(double time) {
		
		// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.Pneumatics);
		button hookDeployer = Robot.m_oi.controllerRightBumper;
		time = tme;
		
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    
    	// Used to indicate 30 second period 
    	boolean endGame;
    		
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    	boolean endGame; 
    	
    		if (tme >= 120.0 && tme <= 150) {
    			endGame = true;
    			startCompressor();
        	} else {
        		endGame = false;
        	}
    		
    		// Allows right button on controller to operate hook
    		while (endGame = true) {
    			hookDeployer.whenPressed(deployHook(boolean op));
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
