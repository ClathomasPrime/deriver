/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 * 
 * Expression are simplified with this class, 
 *		operations are simplified with their own methods
 * Both options return the new function, not modify the original one
 * The REFERENCES of the results will probably be a tangled mess of 
 *		new objects and references to old one, but the values should be okay.
 *		Just keep everything static
 */
public class Simplify extends ExpressionModifier{

	public static Expression mod(Expression e) {
		return new Expression( e.operation.simplify() );
	}
	
	/* public static Expression mod( Operation o){
		return Expression.id;
	} */
}
