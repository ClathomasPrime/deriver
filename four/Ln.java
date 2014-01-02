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
public class Ln extends PrefixOperation{
	
	public Ln (Expression expr){
		this.param = expr;
	}
	
	@Override
	public double value( double x){
		return Math.log( param.value( x ) );
	}

	@Override
	public String getString() {
		return "ln(" + param.getString() + ")";
	}
	@Override
	public Operation simplify() {
		Expression param = Simplify.mod( this.param );
		if( "1.0".equals(param.getString() ) ){
			return new Number(0);
		} else {
			return new Ln( param );
		}
	}

	@Override
	public Operation derive() {
		return new Quotient( Derive.mod(param), param);
	}
}