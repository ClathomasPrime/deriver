/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
import java.lang.Math;
public class Power extends InfixOperation{
	public Power( Expression L, Expression R){
		this.L = L;
		this.R = R;
	}

	@Override
	public double value(double x) {
		return Math.pow( L.value(x), R.value(x) );
	}
	@Override
	public String getString() {
		return "(" + L.getString() + ")^(" + R.getString() + ")";
	}
	@Override
	public String getString( int parentPres) {
		if( parentPres >= 4 )
			return "(" + L.getString( 4 ) + "^" + R.getString( 4 ) + ")";
		else
			return L.getString( 4 ) + "^" + R.getString( 4 );
	}

	@Override
	public Operation simplify() {
		Expression L = Simplify.mod(this.L);
		Expression R = Simplify.mod(this.R);
		if( "0.0".equals(R.operation.getString() ) ){
			return new Number(1);
		} else if ( "0.0".equals(L.getString()) ){
			return new Number(0);
		} else if ( "1.0".equals(L.getString()) ){
			return new Number(1);
		} else if ( "1.0".equals(R.getString()) ){
			return L.operation;
		} else {
			return new Power( L, R );
		}
	}

	@Override
	public Operation derive() {
		if ( R.operation instanceof Number){
			return new Product( new Expression(new Number(R.value(0))),
								new Expression( new Product( Derive.mod(L),
															 new Expression(new Power( L, 
																			new Expression(new Number(R.value(0)-1)))))));
		} else {
			return new Product( new Expression( new Power(L,R)) ,
								new Expression( new Sum( new Expression( new Product( Derive.mod(R),
																					  new Expression( new Ln( L ) ) ) ) ,
														 new Expression( new Quotient( new Expression( new Product(R, Derive.mod(L)) ),
																					   L ) ) ) ) ) ;
		}
	}
}
