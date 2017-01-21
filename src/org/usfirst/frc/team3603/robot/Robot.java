/****************************************
 * 
 * 
 ****************************************/
package org.usfirst.frc.team3603.robot;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	Victor frontLeft = new Victor(0); // Drive Motor Front Left
	Victor frontRight = new Victor(1);
	Victor backLeft = new Victor(2);
	Victor backRight = new Victor(3);
	RobotDrive mainDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
	
	Joystick joystick = new Joystick(0); // Driver Controller
	Joystick xbox = new Joystick(1); // Secondary Controller
    public void robotInit() {
    	
    }
	public void autonomousInit() {
    }
    public void autonomousPeriodic() {
    }
    
	public void teleopPeriodic() {
		while(isEnabled() && isOperatorControl()){
			double x = joystick.getRawAxis(0); // Move Left and Right
			double y = joystick.getRawAxis(1); // Move Forward and Back
		}
    }
    public void testPeriodic() {
    }
}