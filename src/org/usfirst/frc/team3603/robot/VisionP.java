package org.usfirst.frc.team3603.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionP {
	
	NetworkTable table = NetworkTable.getTable("GRIP/myContoursReport");
	
	public VisionP() {
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterX() {
		double[] x1 = table.getNumberArray("centerX");
		double x2 = x1[0];
		return x2;
	}
	
	@SuppressWarnings("deprecation")
	public double getCenterY() {
		double[] y1 = table.getNumberArray("centerY");
		double y2 = y1[0];
		return y2;
	}
	
	@SuppressWarnings("deprecation")
	public double getImageHeight() {
		double[] h1 = table.getNumberArray("height");
		double h2 = h1[0];
		return h2;
	}
	
	@SuppressWarnings("deprecation")
	public double getImageWidth() {
		double[] w1 = table.getNumberArray("width");
		double w2 = w1[0];
		return w2;
	}
	
}
