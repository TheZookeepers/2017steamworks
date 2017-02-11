/****************************************
 * 
 * Team 6600
 * FRC Robot Code
 * 
 ****************************************/
package org.usfirst.frc.team6600.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

public class Robot extends IterativeRobot {
	static Victor frontLeft = new Victor(0); // Drive Motor Front Left
	static Victor frontRight = new Victor(1); // Drive Motor Front Right
	static Victor backLeft = new Victor(0); // Drive Motor Back Left
	static Victor backRight = new Victor(1); // Drive Motor Back Right
	static RobotDrive mainDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
	
	Joystick joystick = new Joystick(0); // Driver Controller
	Joystick xbox = new Joystick(1); // Driver Secondary Controller
    public void robotInit() {
    	
    }
	public void autonomousInit() {
    }
    public void autonomousPeriodic() {
    }
    
	public void teleopPeriodic() {
		while(isEnabled() && isOperatorControl()){
			double x = Math.pow(joystick.getRawAxis(0), 3); // Move Left and Right
			double y = Math.pow(joystick.getRawAxis(1), 3); // Move Forward and Back
			if (Math.abs(x)>=0.1 || Math.abs(y)>=0.1){
				mainDrive.arcadeDrive(y, x);
			}
			
			
			
		}
    }
    public void testPeriodic() {
    }
}