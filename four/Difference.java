/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Difference extends InfixOperation{
	public Difference( Expression L, Expression R){
		this.L = L;
		this.R = R;
	}

	@Override
	public double value(double x) {
		return L.value(x) - R.value(x);
	}

	@Override
	public String getString() {
		return "(" + L.getString() + ")-(" + R.getString() + ")";
	}
	@Override
	public String getString( int parentPres) {
		//System.out.println( "parentPres: "+ parentPres + ";;    diff" );
		if( parentPres >= 1 )
			return "(" + L.getString( 1 ) + "-" + R.getString( 1 ) + ")";
		else
			return L.getString( 1 ) + "-" + R.getString( 1 );
	}

	@Override
	public Operation simplify() {
		Expression L = Simplify.mod(this.L);
		Expression R = Simplify.mod(this.R);
		if( "0.0".equals( R.getString() ) ){
			return L.operation.simplify();
		} else {
			return new Difference( L, R );
		}
	}
	
	@Override
	public Operation derive() {
		return new Difference( new Expression( L.operation.derive() ), 
							   new Expression( R.operation.derive() )  );
	}
	
}