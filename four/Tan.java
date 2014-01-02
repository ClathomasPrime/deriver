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
public class Tan extends PrefixOperation{
	
	public Tan (Expression expr){
		this.param = expr;
	}
	
	@Override
	public double value( double x){
		return Math.tan( param.value( x ) );
	}

	@Override
	public String getString() {
		return "tan(" + param.getString() + ")";
	}
	
	@Override
	public Operation simplify() {
		return new Tan( Simplify.mod(this.param) );
	}

	@Override
	public Operation derive() {
		return new Quotient( Derive.mod(param), 
							 new Expression( new Power( new Expression( new Cos ( param ) ),
														new Expression( new Number( 2) )) )  );
	}
}