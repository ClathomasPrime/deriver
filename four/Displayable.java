/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

import java.awt.geom.*;

/**
 *
 * @author jamesthomas
 */
public class Displayable {
	
	public static class Scale {
		private double x0 = 0;
		private double xScale = 200;
		private double y0 = 0;
		private double yScale = 200;
		
		public Scale(){
			
		}
		public Scale( double x0, double xScale, double y0, double yScale ){
			this.x0 = x0;
			this.xScale = xScale;
			this.y0 = y0;
			this.yScale = yScale;
		}
		
		public double xScale(double x){
			return 400 - xScale*x0 + xScale*x;
		}
		public double yScale(double y){
			return 200 + yScale*y0 - yScale*y;
		}
		public Line2D.Double yAxis(){
			return new Line2D.Double(xScale(0), 0,
									xScale(0), 400);
		}
		public Line2D.Double xAxis(){
			return new Line2D.Double(0, yScale(0),
									800, yScale(0) );
		}
		public double minX(){
			return x0 - 400/xScale;
		}
		public double maxX(){
			return x0 + 400/xScale;
		}
		public double deltaX(){
			return ( maxX()-minX() ) / 2000;
		}
	}
}
