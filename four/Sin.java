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
public class Sin extends PrefixOperation{
	
	public Sin (Expression expr){
		this.param = expr;
	}
	
	@Override
	public double value( double x){
		return Math.sin( param.value( x ) );
	}
}
