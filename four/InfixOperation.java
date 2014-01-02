/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public abstract class InfixOperation extends Operation{
	
	protected Expression L;
	protected Expression R;
	
	
	public static InfixOperation getInfixOperation(String type, Expression L, Expression R){
		String noSpace = type.replaceAll("\\s+","");
		String s = noSpace.toLowerCase();
		if( "+".equals(s) ){
			return new Sum( L , R);
		} else if ( "-".equals(s)) {
			return new Difference( L , R);
		}else if ( "*".equals(s)) {
			return new Product( L , R);
		}else if ( "/".equals(s)) {
			return new Quotient( L , R);
		}else if ( "^".equals(s)) {
			return new Power( L , R);
		} else {
			throw new Error("Unrecognized Infix Operation... "
					+ "I don't know how this error would happen, "
					+ "but it would signal a fault in the expression charLoop");
		}
	}
	
	public static final int getPresidence( char c){
		switch( c ){
			case '+':
				return 0;
			case '-':
				return 1;
			case '*':
				return 2;
			case '/':
				return 3;
			case '^':
				return 4;
			default:
				return 100; //bad coding practice
		}
	}
	

}
