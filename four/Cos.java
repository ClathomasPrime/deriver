/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
import java.lang.Math.*;
public class Cos extends PrefixOperation{
	
	public Cos (Expression expr){
		this.param = expr;
	}
	
	@Override
	public double value( double x){
		return Math.cos( param.value( x ) );
	}
}