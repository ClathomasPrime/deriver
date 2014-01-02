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

	@Override
	public String getString() {
		return  expression.getString();
	}

	@Override
	public String getString(int parentPres) {
		return  expression.getString( parentPres);
	}

	@Override
	public Operation simplify() {
		return expression.operation.simplify();
	}

	@Override
	public Operation derive() {
		return expression.operation.derive() ;
	}
}
