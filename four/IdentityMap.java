/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class IdentityMap extends Operation{
	
	private Expression expression;
	
	public IdentityMap(Expression expr){
		expression = expr;
	}
	
	@Override
	public double value( double x){
		return expression.value(x);
	}
}
