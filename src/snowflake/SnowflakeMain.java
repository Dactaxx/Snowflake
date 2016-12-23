package snowflake;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class SnowflakeMain {
	public static double angle = Math.toRadians(30);
	public static void main(String[] args) {
		Window.createWindow();
		
	}
	
	public static void iterate(double startx, double starty, double startAngle, int iterations, int iteration, Graphics2D g2d) {
		if(iteration > 0) {
			double size = Math.pow(iteration + 1, 3.2);
			double endx = size * Math.cos(angle + startAngle) - size *Math.sin(angle + startAngle) + startx;
			double endy = size * Math.sin(angle + startAngle) + size * Math.cos(angle + startAngle) + starty;
			
			double strokeSize = Math.pow(iteration + 3, 2) / 10d;
			g2d.setStroke(new BasicStroke((float)strokeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

			g2d.drawLine((int)startx, (int)starty, (int)endx, (int)endy);
			iterate((startx + endx) / 2, (starty + endy) / 2, angle + startAngle, iterations, iteration - 1, g2d);
			iterate((startx + endx) / 2, (starty + endy) / 2, -angle + startAngle, iterations, iteration - 1, g2d);
			
			iterate(startx + (endx-startx) * .25, starty + (endy-starty) * .25, angle + startAngle, iterations, iteration - 1, g2d);
			iterate(startx + (endx-startx) * .25, starty + (endy-starty) * .25, -angle + startAngle, iterations, iteration - 1, g2d);
			
			iterate(startx + (endx-startx) * .75, starty + (endy-starty) * .75, angle + startAngle, iterations, iteration - 1, g2d);
			iterate(startx + (endx-startx) * .75, starty + (endy-starty) * .75, -angle + startAngle, iterations, iteration - 1, g2d);
		}
		
	}
	
}
