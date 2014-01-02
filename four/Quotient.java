/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Quotient extends InfixOperation{
	public Quotient( Expression L, Expression R){
		this.L = L;
		this.R = R;
	}

	@Override
	public double value(double x) {
		return L.value(x) / R.value(x);
	}
	@Override
	public String getString() {
		return "(" + L.getString() + ")/(" + R.getString() + ")";
	}
	@Override
	public String getString( int parentPres) {
		if( parentPres >= 3 )
			return "(" + L.getString( 3 ) + "/" + R.getString( 3 ) + ")";
		else
			return L.getString( 3 ) + "/" + R.getString( 3 );
	}

	@Override
	public Operation simplify() {
		Expression L = Simplify.mod(this.L);
		Expression R = Simplify.mod(this.R);
		if ( "1.0".equals(R.getString()) ){
			return L.operation;
		} else if ( "0.0".equals(L.getString()) ){
			return new Number(0);
		} else if ( "x".equals(L.getString()) && "x".equals(R.getString()) ) {
			return new Number(1);
		}else {
			return new Quotient( L, R );
		}
	}

	@Override
	public Operation derive() {
		return new Quotient( new Expression( new Difference( new Expression(new Product( Derive.mod(L) , R ) ),
													  new Expression(new Product( L , Derive.mod(R) ) )  ) ), 
							 new Expression(new Power( R,
													   new Expression( new Number(2) ) ) ) ) ;
	}
}
