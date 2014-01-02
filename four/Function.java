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
public class Function extends Displayable{
	public Expression function;
	//private Scale scale = new Scale(0,50,0,200);
	
	public Function( String str){
		function = new Expression(str);
	}
	
	public Function( Expression e){
		function = e;
	}
	
	public Line2D.Double getSegment( double start, double end){
		//System.out.println("[Point:");
		Scale s = DeriverFour.window.scale;
		return new Line2D.Double( s.xScale(start), s.yScale(function.value(start)), 
								  s.xScale(end), s.yScale(function.value(end)) );
		//return new Line2D.Double( 4, 6, 
		//						  1200, 300 );
		
	}
	
}
