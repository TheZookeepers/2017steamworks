/****************************************
 * 
 *	THOMAS 2
 *	@author CyberCoyotes
 *
 ****************************************/
package org.usfirst.frc.team3603.robot;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
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
	final String defaultAuto = "Default";
	final String redAuton = "redAuton";
	final String blueAuton = "blueAuton";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	
	Joystick joy1 = new Joystick(0);
	Joystick joy2 = new Joystick(1);
	
    Victor backLeft = new Victor(0);
    Victor backRight = new Victor(1);
    Victor frontLeft = new Victor(2);
    Victor frontRight = new Victor(3);
    Victor shoot = new Victor(4);
    
    RobotDrive mainDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    
    ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    ADXL362 accel = new ADXL362(Range.k8G);
    Timer timer = new Timer();
    Encoder enc = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
    
    Vision2017 vision = new Vision2017();
    
    CameraServer camera = CameraServer.getInstance();
    
    public void robotInit() {
    	gyro.calibrate();
    	gyro.reset();
    	chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("Red Autonomous Code", redAuton);
		chooser.addObject("Blue Autonomous Code", blueAuton);
		SmartDashboard.putData("Auto choices", chooser);
		
		camera.startAutomaticCapture("cam0", 0);
    }
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
    }
    public void autonomousPeriodic() {
    	timer.start();
    	while(isEnabled() && isAutonomous()) {
	    	switch (autoSelected) {
			case defaultAuto:
				DefaultAuto();
				break;
	
			case redAuton:
				//RedAuton();
				break;
			
			case blueAuton:
				//BlueAuton();
				break;
			}
    	}
    }
    
	public void teleopPeriodic() {
    	while(isOperatorControl() && isEnabled()) {
    		if(joy1.getRawButton(1) || joy1.getRawButton(2) || joy1.getRawButton(3) || joy1.getRawButton(4) || joy1.getRawButton(5) || joy1.getRawButton(6) || joy1.getRawButton(7) || joy1.getRawButton(8) || joy1.getRawButton(9) || joy1.getRawButton(10) ||  joy2.getRawButton(1) || joy2.getRawButton(2) || joy2.getRawButton(3) || joy2.getRawButton(4) || joy2.getRawButton(5) || joy2.getRawButton(6) || joy2.getRawButton(7) || joy2.getRawButton(8) || joy2.getRawButton(9) || joy2.getRawButton(10) || joy1.getRawAxis(0) >= 0.05 || joy1.getRawAxis(1) >= 0.05 || joy1.getRawAxis(2) >= 0.05 || joy1.getRawAxis(3) >= 0.05 || joy1.getRawAxis(4) >= 0.05 || joy1.getRawAxis(5) >= 0.05 || joy1.getRawAxis(6) >= 0.05 || joy2.getRawAxis(0) >= 0.05 || joy2.getRawAxis(1) >= 0.05 || joy2.getRawAxis(2) >= 0.05 || joy2.getRawAxis(3) >= 0.05 || joy2.getRawAxis(4) >= 0.05 || joy2.getRawAxis(5) >= 0.05 || joy2.getRawAxis(6) >= 0.05 || joy1.getRawAxis(0) <= -0.05 || joy1.getRawAxis(1) <= -0.05 || joy1.getRawAxis(2) <= -0.05 || joy1.getRawAxis(3) <= -0.05 || joy1.getRawAxis(4) <= -0.05 || joy1.getRawAxis(5) <= -0.05 || joy1.getRawAxis(6) <= -0.05 || joy2.getRawAxis(0) <= -0.05 || joy2.getRawAxis(1) <= -0.05 || joy2.getRawAxis(2) <= -0.05 || joy2.getRawAxis(3) <= -0.05 || joy2.getRawAxis(4) <= -0.05 || joy2.getRawAxis(5) <= -0.05 || joy2.getRawAxis(6) <= -0.05) {
    			/***********************
	    		 *** DRIVER CONTROLS ***
	    		 ***********************/
	    		
	    		double x = Math.pow(joy1.getRawAxis(0), 3);
	    		double y = Math.pow(joy1.getRawAxis(1), 3);
	    		double rot = Math.pow(joy1.getTwist(), 3);
	    		
	    		if(Math.abs(x)>=0.1 || Math.abs(y)>=0.1 || Math.abs(rot)>=0.1) {
	    			mainDrive.mecanumDrive_Cartesian(x, y, rot, gyro.getAngle());
	    		}
    		} else {
    			mainDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
    		}
    		SmartDashboard.putNumber("Center X", vision.getContour1CenterX());
    		SmartDashboard.putNumber("Center Y", vision.getContour1CenterY());
    	}
    }
    public void testPeriodic() {
    }
    
    private void DefaultAuto() {
    	while(enc.getDistance() < 10 && timer.get() < 15) {
			mainDrive.mecanumDrive_Cartesian(0, .5, 0, gyro.getAngle());
		}
	}
    /*
    private void RedAuton() {
    	double off = 123456789;
    	timer.start();
    	while(isEnabled() && isAutonomous() && timer.get() < 15) {
    		while(timer.get() < 3 && enc.getDistance() < 8) {
    			mainDrive.mecanumDrive_Cartesian(0, 1.0, 0, gyro.getAngle());
    		}
    		while(timer.get() < 3 && gyro.getAngle() < 45) {
    			mainDrive.mecanumDrive_Cartesian(0, 0, 0.4, gyro.getAngle());
    		}
    		while(timer.get() < 9 && (off <= vision.getImageWidth()-50 || off >= vision.getImageWidth()+50) && vision.getCenterGear()!=123456789) {
    			off = vision.getCenterGear() - vision.getImageWidth();
    			if(off > vision.getImageWidth() + 50) {
    				mainDrive.mecanumDrive_Cartesian(0, 0, 0.4, gyro.getAngle());
    			}
    			if(off < vision.getImageWidth() - 50) {
    				mainDrive.mecanumDrive_Cartesian(0, 0, -0.4, gyro.getAngle());
    			}
    		}
    		while(timer.get() < 11) {
    			mainDrive.mecanumDrive_Cartesian(0, 0.4, 0, 0);
    		}
    		while(timer.get() < 15) {
    			shoot.set(1);
    		}
    	}
    	shoot.set(0);
    }
    
    private void BlueAuton() {
    	double off = 123456789;
    	timer.start();
    	while(isEnabled() && isAutonomous() && timer.get() < 15) {
    		while(timer.get() < 3 && enc.getDistance() < 8) {
    			mainDrive.mecanumDrive_Cartesian(0, 1.0, 0, gyro.getAngle());
    		}
    		while(timer.get() < 3 && gyro.getAngle() > -45) {
    			mainDrive.mecanumDrive_Cartesian(0, 0, -0.4, gyro.getAngle());
    		} 
    		while(timer.get() < 9 && (off <= vision.getImageWidth()-50 || off >= vision.getImageWidth()+50) && vision.getCenterGear()!=123456789) {
    			off = vision.getCenterGear() - vision.getImageWidth();
    			if(off > vision.getImageWidth() + 50) {
    				mainDrive.mecanumDrive_Cartesian(0, 0, 0.4, gyro.getAngle());
    			}
    			if(off < vision.getImageWidth() - 50) {
    				mainDrive.mecanumDrive_Cartesian(0, 0, -0.4, gyro.getAngle());
    			}
    		}
    		while(timer.get() < 11) {
    			mainDrive.mecanumDrive_Cartesian(0, 0.4, 0, 0);
    		}
    		while(timer.get() < 15) {
    			shoot.set(1);
    		}
    	}
    	shoot.set(0);
    }
    */
}