package org.usfirst.frc.team3603.robot;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionP {
	
	NetworkTable table = NetworkTable.getTable("GRIP/myContoursReport");
	GRIP grip = new GRIP();
	Mat cam = new Mat();
	Timer timer = new Timer();
	long time;
	
	public VisionP(long t) {
		time = t;
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterX(int contour) {
		grip.process(cam);
		try {
			double[] x1 = table.getNumberArray("centerX");
			Thread.sleep(time);
			return x1[contour];
		} catch (Exception ex){
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterY(int contour) {
		grip.process(cam);
		try {
			double[] y1 = table.getNumberArray("centerY");
			Thread.sleep(time);
			return y1[contour];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getImageHeight() {
		grip.process(cam);
		try {
			double[] h1 = table.getNumberArray("height");
			Thread.sleep(time);
			return h1[0];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getImageWidth() {
		grip.process(cam);
		try{
			double[] w1 = table.getNumberArray("width");
			Thread.sleep(time);
			return w1[0];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	@SuppressWarnings("deprecation")
	public double getArea(int contour) {
		grip.process(cam);
		try {
			double[] a1 = table.getNumberArray("area");
			Thread.sleep(time);
			return a1[contour];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterGear() {
		grip.process(cam);
		try {
			double[] x = table.getNumberArray("centerX");
			Thread.sleep(time);
			double center = (x[0]+x[1])/2;
			return center;
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterFuel() {
		grip.process(cam);
		try {
			double[] y = table.getNumberArray("centerY");
			Thread.sleep(time);
			double center = (y[0]+y[1])/2;
			return center;
		} catch (Exception ex) {
			return 123456789;
		}
	}
	public long callibrate(int instances) {
		timer.start();
		for(int i = 0; i<=instances; i++) {
			grip.process(cam);
		}
		long time = (long) timer.get() / instances;
		return time;
	}
}
