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

	@Override
	public String getString() {
		return "cos(" + param.getString() + ")";
	}

	@Override
	public Operation simplify() {
		return new Cos( Simplify.mod(this.param) );
	}

	@Override
	public Operation derive() {
		return new Product( new Expression(new Number(-1)),
				new Expression(new Product( Derive.mod(param),
											new Expression( new Sin(param ) ) ) ) );
	}
}