package org.usfirst.frc.team3603.robot;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionP {
	
	NetworkTable table = NetworkTable.getTable("GRIP/myContoursReport");
	GRIP grip = new GRIP();
	Mat cam = new Mat();
	public VisionP() {
		
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterX(int contour) {
		try {
			double[] x1 = table.getNumberArray("centerX");
			return x1[contour];
		} catch (Exception ex){
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterY(int contour) {
		try {
			double[] y1 = table.getNumberArray("centerY");
			return y1[contour];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getImageHeight() {
		try {
			double[] h1 = table.getNumberArray("height");
			return h1[0];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getImageWidth() {
		try{
			double[] w1 = table.getNumberArray("width");
			return w1[0];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	@SuppressWarnings("deprecation")
	public double getArea(int contour) {
		try {
			double[] a1 = table.getNumberArray("area");
			return a1[contour];
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterGear() {
		try {
			double[] x = table.getNumberArray("centerX");
			double center = (x[0]+x[1])/2;
			return center;
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterFuel() {
		try {
			double[] y = table.getNumberArray("centerY");
			double center = (y[0]+y[1])/2;
			return center;
		} catch (Exception ex) {
			return 123456789;
		}
	}
	
	public void process() {
		grip.process(cam);
	}
	
}
