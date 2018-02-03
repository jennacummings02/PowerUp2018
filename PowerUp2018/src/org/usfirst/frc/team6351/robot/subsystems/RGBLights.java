package org.usfirst.frc.team6351.robot.subsystems;

import com.mindsensors.CANLight;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RGBLights extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//Verify CAN ID Number
	CANLight lights = new CANLight(3);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void blinkPCB_LED() {
    		//Meant for debugging purposes
    		lights.blinkLED(10);
    }
    public void setToColor(int red, int green, int blue) {
		lights.showRGB(red, green, blue);
    }
    public void setRainbowFade() {
    		lights.reset();
		lights.fade(0,7);
    }
    public void setToAllianceColor() {
    		DriverStation ds = DriverStation.getInstance();
    		if (ds.getAlliance() == DriverStation.Alliance.Red) {
    			lights.showRGB(255, 51, 0);
        } else if (ds.getAlliance() == DriverStation.Alliance.Blue) {
        		lights.showRGB(0, 102, 255);
        } else if (ds.getAlliance() == DriverStation.Alliance.Invalid) {
        		lights.showRGB(255, 200, 0); // yellow
        }
    }
    public void setToEndMatchFlash() {
    		//Flash between red and blue near end of match
		lights.writeRegister(0, 0.25, 0, 102, 255);
		lights.writeRegister(1, 0.25, 255, 51, 0);
		lights.cycle(0, 1);
    }	
    
}

