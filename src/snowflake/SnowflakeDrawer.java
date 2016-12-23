package snowflake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnowflakeDrawer {
	public static void drawSnowflake(int spokes) {
		int width = 3840;
		int height = 2160;
		Point center = new Point(width / 2, height / 2);
		int size = 800;
		BufferedImage snowflake = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2d = snowflake.createGraphics();
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(0, 0, width, height);
		
		g2d.setColor(new Color(255, 255, 255));
		
		double pointx[] = new double[spokes];
		double pointy[] = new double[spokes];
		int iterations = 4;
		double angle = 2d * Math.PI - SnowflakeMain.angle;
		System.out.println(angle);
		
		for(int i = 1; i <= spokes; i++) {
			pointx[i - 1] = Math.cos(i * ((2 * Math.PI) / spokes)) * size + center.x;
			if(i == spokes) {
				pointy[i - 1] = Math.sin(2 * Math.PI + .001) * size + center.y;
				if(pointx[i-1] > center.x) {
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
				}
				if(pointx[i-1] < center.x) {
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
				}
				
			} else {
				pointy[i - 1] = Math.sin(i * ((2 * Math.PI) / spokes)) * size + center.y;
				if(pointx[i-1] >= center.x) {
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4 - 2 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) - Math.PI/4, iterations, iterations, g2d);
				}
				if(pointx[i-1] < center.x) {
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate((center.x + pointx[i-1]) / 2, (center.y + pointy[i-1]) / 2, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .25, center.y + (pointy[i-1]-center.y) * .25, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * .75, center.y + (pointy[i-1]-center.y) * .75, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
					
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + 3 * SnowflakeMain.angle, iterations, iterations, g2d);
					SnowflakeMain.iterate(center.x + (pointx[i-1]-center.x) * 0, center.y + (pointy[i-1]-center.y) * 0, Math.atan((center.y - pointy[i-1]) / (center.x - pointx[i-1])) + Math.PI/4 + SnowflakeMain.angle, iterations, iterations, g2d);
				}
			}
		}
		
		g2d.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		for(int i = 0; i < pointx.length; i++) {
			g2d.drawLine(center.x, center.y, (int)pointx[i], (int)pointy[i]);
			
		}
		
		try {
			ImageIO.write(snowflake, "png", new File("snowflake.png"));
			
		}	catch(IOException e) {
				e.printStackTrace();
			
			}
		
		
	}
	
}
