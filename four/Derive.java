/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Derive extends ExpressionModifier {

	public static Expression mod(Expression e) {
		return new Expression( e.operation.derive() );
		
		//return Simplify.mod( new Expression( new Sum(e, new Expression(new Number(1)) ) ) );
		/*if( e.operation instanceof Identity){
			return new Expression( new Number(1) );
			
		} else if (  e.operation instanceof Number ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Cos ){
			return new Expression( e.operation );
			
		} else if (  e.operation instanceof Sin ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Tan ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Ln ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Sum ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Difference ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Product ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Quotient ){
			return new Expression( new Number(0) );
			
		} else if (  e.operation instanceof Power ){
			return new Expression( new Number(0) );
			
		} else {
			return new Expression ( new Identity() );
		}*/
	}
	
}
