package snowflake;

import java.awt.Graphics2D;

public class SnowflakeMain {
	public static void main(String[] args) {
		Window.createWindow();
		
	}
	
	public static void iterate(double startx, double starty, double endx, double endy, int iterations, int iteration, Graphics2D g2d	) {
		if(iteration > 0) {
			double slopeX = (startx - endx);
			double slopeY = (starty - endy);
			double angle = Math.atan(slopeY / slopeX);
			double newAngle = angle - Math.PI/6d;
			double newSlope = Math.tan(newAngle);
			double size = 5d / (iterations - iteration + 5);
			
//			double scale = size / Math.sqrt((Math.pow(newSlope, 2) + 1));
//			slopeX = scale;
//			slopeY = scale * newSlope;
			
//			System.out.println(angle + "; " + (slopeY / slopeX) + "; " + newAngle + "; (" + slopeY + ", " + slopeX + ")" + "; (" + startx + ", " + starty + ")" + "; (" + endx + ", " + endy + ")" + "; " + scale);
			
			g2d.drawLine((int)((startx + endx) / 2), (int)((starty + endy) / 2), (int)(((startx + endx) / 2) + -slopeY * size), (int)(((starty + endy) /2) + slopeX * size));
			
			iterate((int)((startx + endx) / 2), (int)((starty + endy) / 2), (int)(((startx + endx) / 2) + -slopeY * size), (int)(((starty + endy) /2) + slopeX * size), iterations, iteration -1, g2d);
		}
		
	}
	
}
